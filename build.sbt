import sbtrelease._
import ReleaseStateTransformations._
import sbtcrossproject.CrossProject
import scala.sys.process.Process

val isScala3 = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)
)

def Scala212 = "2.12.18"

def gitHash(): String = Process("git rev-parse HEAD").lineStream_!.head

val tagName = Def.setting{
  s"v${if (releaseUseGlobalVersion.value) (ThisBuild / version).value else version.value}"
}

val tagOrHash = Def.setting{
  if(isSnapshot.value) gitHash() else tagName.value
}

def releaseStepAggregateCross[A](key: TaskKey[A]): ReleaseStep = ReleaseStep(
  action = { state =>
    val extracted = Project extract state
    extracted.runAggregated(extracted.get(thisProjectRef) / (Global / key), state)
  },
  enableCrossBuild = true
)

val sonatypeURL = "https://oss.sonatype.org/service/local/repositories/"

val projectName = "applybuilder"

val updateReadme = { state: State =>
  val extracted = Project.extract(state)
  val scalaV = "2.13"
  val v = extracted get version
  val org =  extracted get organization
  val modules = projectName :: Nil
  val snapshotOrRelease = if(extracted get isSnapshot) "snapshots" else "releases"
  val readme = "README.md"
  val readmeFile = file(readme)
  val newReadme = Predef.augmentString(IO.read(readmeFile)).lines.map{ line =>
    val matchReleaseOrSnapshot = line.contains("SNAPSHOT") == v.contains("SNAPSHOT")
    val i = modules.indexWhere(line.contains)
    if(line.startsWith("libraryDependencies") && matchReleaseOrSnapshot){
      s"""libraryDependencies += "${org}" %% "${modules(i)}" % "$v""""
    }else if(line.contains(sonatypeURL) && matchReleaseOrSnapshot){
      val n = modules(i)
      s"- [API Documentation](${sonatypeURL}${snapshotOrRelease}/archive/${org.replace('.','/')}/${n}_${scalaV}/${v}/${n}_${scalaV}-${v}-javadoc.jar/!/index.html)"
    }else line
  }.mkString("", "\n", "\n")
  IO.write(readmeFile, newReadme)
  val git = new Git(extracted get baseDirectory)
  git.add(readme) ! state.log
  git.commit(message = "update " + readme, sign = false, signOff = false) ! state.log
  Process("git diff HEAD^") ! state.log
  state
}

val updateReadmeProcess: ReleaseStep = updateReadme

val unusedWarnings = (
  "-Ywarn-unused" ::
  Nil
)

val commonSettings = Def.settings(
  publishTo := sonatypePublishToBundle.value,
  name := projectName,
  sourcesInBase := false,
  fullResolvers ~= {_.filterNot(_.name == "jcenter")},
  credentials ++= ((sys.env.get("SONATYPE_USER"), sys.env.get("SONATYPE_PASS")) match {
    case (Some(user), Some(pass)) =>
      Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass) :: Nil
    case _ =>
      Nil
  }),
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
    releaseStepAggregateCross(PgpKeys.publishSigned),
    releaseStepCommandAndRemaining("+ applybuilderNative/publishSigned"),
    releaseStepCommandAndRemaining("sonatypeBundleRelease"),
    setNextVersion,
    commitNextVersion,
    updateReadmeProcess,
    pushChanges
  ),
  scalaVersion := Scala212,
  crossScalaVersions := Scala212 :: "2.13.12" :: "3.3.1" :: Nil,
  organization := "com.github.xuwei-k",
  startYear := Some(2014),
  description := "scalaz.Apply builder",
  (Compile / doc / scalacOptions) ++= {
    val tag = tagOrHash.value
    if (isScala3.value) {
      Nil
    } else {
      Seq(
        "-sourcepath", baseDirectory.value.getAbsolutePath,
        "-doc-source-url", s"https://github.com/xuwei-k/applybuilder/tree/${tag}€{FILE_PATH}.scala"
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
  licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, v)) if v <= 12 =>
        Seq(
          "-Ypartial-unification"
        )
      case _ =>
        Nil
    }
  },
  scalacOptions ++= (
    "-deprecation" ::
    "-Xlint" ::
    "-unchecked" ::
    "-language:existentials" ::
    "-language:higherKinds" ::
    "-language:implicitConversions" ::
    Nil
  ) ++ PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
    case Some((2, v)) if v >= 11 => unusedWarnings
  }.toList.flatten,
  Seq(Compile, Test).flatMap(c =>
    c / console / scalacOptions ~= {_.filterNot(unusedWarnings.toSet)}
  )
)

val scalazVersion = SettingKey[String]("scalazVersion")

val applybuilder = CrossProject(
  id = projectName,
  base = file(".")
)(
  JSPlatform, JVMPlatform, NativePlatform
).crossType(
  CustomCrossType
).settings(
  commonSettings,
  scalazVersion := "7.3.7",
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
  libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % "test",
  libraryDependencies += "org.scalaz" %%% "scalaz-core" % scalazVersion.value
).jsSettings(
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

val applybuilderJVM = applybuilder.jvm
val applybuilderJS = applybuilder.js.enablePlugins(ScalaJSJUnitPlugin)
val applybuilderNative = applybuilder.native.enablePlugins(ScalaNativeJUnitPlugin)

val root = Project(
  "root", file(".")
).settings(
  commonSettings,
  Compile / scalaSource := baseDirectory.value / "dummy",
  Test / scalaSource := baseDirectory.value / "dummy",
  PgpKeys.publishSigned := {},
  PgpKeys.publishLocalSigned := {},
  publishLocal := {},
  Compile / publishArtifact := false,
  publish := {}
).aggregate(
  applybuilderJVM, applybuilderJS
)
