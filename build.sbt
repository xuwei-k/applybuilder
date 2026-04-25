import sbtrelease._
import ReleaseStateTransformations._
import scala.sys.process.Process

val isScala3 = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)
)

def Scala212 = "2.12.21"

val scalaVersions = Seq(Scala212, "2.13.18", "3.3.7")

def gitHash(): String = Process("git rev-parse HEAD").lineStream_!.head

val tagName = Def.setting {
  s"v${if (releaseUseGlobalVersion.value) (ThisBuild / version).value else version.value}"
}

val tagOrHash = Def.setting {
  if (isSnapshot.value) gitHash() else tagName.value
}

val projectName = "applybuilder"

val updateReadme: State => State = { state =>
  val extracted = Project.extract(state)
  val scalaV = "2.13"
  val v = extracted get version
  val org = extracted get organization
  val modules = projectName :: Nil
  val snapshotOrRelease = if (extracted get isSnapshot) "snapshots" else "releases"
  val readme = "README.md"
  val readmeFile = file(readme)
  val newReadme = IO
    .readLines(readmeFile)
    .map { line =>
      val matchReleaseOrSnapshot = line.contains("SNAPSHOT") == v.contains("SNAPSHOT")
      val i = modules.indexWhere(line.contains)
      if (line.startsWith("libraryDependencies") && matchReleaseOrSnapshot) {
        s"""libraryDependencies += "${org}" %% "${modules(i)}" % "$v""""
      } else line
    }
    .mkString("", "\n", "\n")
  IO.write(readmeFile, newReadme)
  val git = new Git(extracted get baseDirectory)
  git.add(readme) ! state.log
  git.commit(message = "update " + readme, sign = false, signOff = false) ! state.log
  Process("git diff HEAD^") ! state.log
  state
}

val updateReadmeProcess: ReleaseStep = updateReadme

val unusedWarnings = Seq(
  "-Ywarn-unused",
)

val commonSettings = Def.settings(
  publishTo := (if (isSnapshot.value) None else localStaging.value),
  name := projectName,
  sourcesInBase := false,
  commands += Command.command("updateReadme")(updateReadme),
  releaseTagName := tagName.value,
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    updateReadmeProcess,
    tagRelease,
    releaseStepCommandAndRemaining("publishSigned"),
    releaseStepCommandAndRemaining("sonaRelease"),
    setNextVersion,
    commitNextVersion,
    updateReadmeProcess,
    pushChanges
  ),
  organization := "com.github.xuwei-k",
  startYear := Some(2014),
  description := "scalaz.Apply builder",
  (Compile / doc / scalacOptions) ++= {
    val tag = tagOrHash.value
    if (isScala3.value) {
      Nil
    } else {
      Seq(
        "-sourcepath",
        baseDirectory.value.getAbsolutePath,
        "-doc-source-url",
        s"https://github.com/xuwei-k/applybuilder/tree/${tag}€{FILE_PATH}.scala"
      )
    }
  },
  Test / logBuffered := false,
  pomExtra := (
    <url>https://github.com/xuwei-k/applybuilder</url>
    <developers>
      <developer>
        <id>xuwei-k</id>
        <name>Kenji Yoshida</name>
        <url>https://github.com/xuwei-k</url>
      </developer>
    </developers>
    <scm>
      <url>git@github.com:xuwei-k/applybuilder.git</url>
      <connection>scm:git:git@github.com:xuwei-k/applybuilder.git</connection>
      <tag>{tagOrHash.value}</tag>
    </scm>
  ),
  licenses := Seq("MIT" -> url("https://opensource.org/license/MIT")),
  scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, v)) if v <= 12 =>
        Seq(
          "-language:higherKinds",
          "-Ypartial-unification"
        )
      case _ =>
        Nil
    }
  },
  scalacOptions ++= Seq(
    "-deprecation",
    "-Xlint",
    "-unchecked",
    "-language:existentials",
    "-language:implicitConversions",
  ) ++ PartialFunction
    .condOpt(CrossVersion.partialVersion(scalaVersion.value)) {
      case Some((2, v)) if v >= 11 => unusedWarnings
    }
    .toList
    .flatten,
  Seq(Compile, Test).flatMap(c => c / console / scalacOptions ~= { _.filterNot(unusedWarnings.toSet) })
)

val scalazVersion = SettingKey[String]("scalazVersion")

val applybuilder = projectMatrix
  .withId(projectName)
  .in(file("."))
  .defaultAxes()
  .settings(
    commonSettings,
    scalazVersion := "7.3.8",
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
    libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % "test",
    libraryDependencies += "org.scalaz" %%% "scalaz-core" % scalazVersion.value
  )
  .jvmPlatform(
    scalaVersions,
  )
  .jsPlatform(
    scalaVersions,
    scalacOptions += {
      val a = (LocalRootProject / baseDirectory).value.toURI.toString
      val g = "https://raw.githubusercontent.com/xuwei-k/applybuilder/" + tagOrHash.value
      val key = CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) =>
          "-scalajs-mapSourceURI"
        case _ =>
          "-P:scalajs:mapSourceURI"
      }
      s"${key}:$a->$g/"
    }
  )
  .nativePlatform(
    scalaVersions,
  )
  .configure(p =>
    p.id.takeWhile(x => ('2' != x) && ('3' != x)) match {
      case "applybuilderNative" =>
        p.enablePlugins(ScalaNativeJUnitPlugin)
      case "applybuilderJS" =>
        p.enablePlugins(ScalaJSJUnitPlugin)
      case "applybuilderJVM" =>
        p
    }
  )

val root = Project(
  "root",
  file(".")
).settings(
  commonSettings,
  autoScalaLibrary := false,
  Compile / scalaSource := baseDirectory.value / "dummy",
  Test / scalaSource := baseDirectory.value / "dummy",
  PgpKeys.publishSigned := {},
  PgpKeys.publishLocalSigned := {},
  publishLocal := {},
  Compile / publishArtifact := false,
  publish := {}
).aggregate(
  applybuilder.projectRefs *
)
