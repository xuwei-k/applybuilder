import sbt._, Keys._

import sbtrelease._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys
import xerial.sbt.Sonatype

object build extends Build {

  def gitHash: Option[String] = scala.util.Try(
    sys.process.Process("git rev-parse HEAD").lines_!.head
  ).toOption

  val showDoc = TaskKey[Unit]("showDoc")

  val copySources = taskKey[Unit]("copy source files")
  val generatedSourceDir = "generated"
  val cleanSrc = taskKey[Unit]("clean generated sources")

  def releaseStepAggregateCross[A](key: TaskKey[A]): ReleaseStep = ReleaseStep(
    action = { state =>
      val extracted = Project extract state
      extracted.runAggregated(key in Global in extracted.get(thisProjectRef), state)
    },
    enableCrossBuild = true
  )

  val sonatypeURL = "https://oss.sonatype.org/service/local/repositories/"

  private[this] final val Scala210 = "2.10.5"

  val updateReadme = { state: State =>
    val extracted = Project.extract(state)
    val scalaV = extracted get scalaBinaryVersion
    val v = extracted get version
    val org =  extracted get organization
    val modules = ("70" :: "71" :: Nil).map("applybuilder" + _)
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
    git.commit("update " + readme) ! state.log
    "git diff HEAD^" ! state.log
    state
  }

  val updateReadmeProcess: ReleaseStep = updateReadme

  private[this] val unusedWarnings = (
    "-Ywarn-unused" ::
    "-Ywarn-unused-import" ::
    Nil
  )

  val commonSettings = ReleasePlugin.releaseSettings ++ Sonatype.sonatypeSettings ++ Seq(
    sourcesInBase := false,
    credentials ++= ((sys.env.get("SONATYPE_USER"), sys.env.get("SONATYPE_PASS")) match {
      case (Some(user), Some(pass)) =>
        Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass) :: Nil
      case _ =>
        Nil
    }),
    commands += Command.command("updateReadme")(updateReadme),
    ReleasePlugin.ReleaseKeys.releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      updateReadmeProcess,
      tagRelease,
      releaseStepAggregateCross(PgpKeys.publishSigned),
      setNextVersion,
      commitNextVersion,
      releaseStepAggregateCross(Sonatype.SonatypeKeys.sonatypeReleaseAll),
      updateReadmeProcess,
      pushChanges
    ),
    scalaVersion := Scala210,
    crossScalaVersions := "2.11.7" :: Scala210 :: "2.9.3" :: Nil,
    organization := "com.github.xuwei-k",
    startYear := Some(2014),
    description := "scalaz.Apply builder",
    scalacOptions in (Compile, doc) ++= {
      val tag = if(isSnapshot.value) gitHash.getOrElse("master") else { "v" + version.value }
      Seq(
        "-sourcepath", baseDirectory.value.getAbsolutePath,
        "-doc-source-url", s"https://github.com/xuwei-k/applybuilder/tree/${tag}/ApplyBuilder.scala"
      )
    },
    logBuffered in Test := false,
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
      <tag>{if(isSnapshot.value) gitHash.getOrElse("master") else { "v" + version.value }}</tag>
    </scm>
    ),
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
    scalacOptions ++= Seq("-deprecation", "-Xlint", "-unchecked") ++ (
      if(scalaVersion.value.startsWith("2.9")) Seq("-Ydependent-method-types")
      else (
        "-language:existentials" ::
        "-language:higherKinds" ::
        "-language:implicitConversions" ::
        Nil
      )
    ) ++ PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
      case Some((2, v)) if v >= 11 => unusedWarnings
    }.toList.flatten,
    showDoc in Compile <<= (doc in Compile, target in doc in Compile) map { (_, out) =>
      java.awt.Desktop.getDesktop.open(out / "index.html")
    }
  ) ++ Seq(Compile, Test).flatMap(c =>
    scalacOptions in (c, console) ~= {_.filterNot(unusedWarnings.toSet)}
  )

  val baseSettings = commonSettings ++ Seq(
    copySources := {
      val fileName = "ApplyBuilder.scala"
      IO.copyFile(
        (baseDirectory in LocalRootProject).value / fileName,
        (scalaSource in Compile).value / generatedSourceDir / fileName
      )
    },
    compile in Compile <<= (compile in Compile) dependsOn copySources,
    packageSrc in Compile <<= (packageSrc in Compile).dependsOn(compile in Compile),
    cleanSrc := IO.delete((scalaSource in Compile).value / generatedSourceDir),
    clean <<= clean dependsOn cleanSrc
  )

  val scalaz70 = Project(
    "applybuilder70", file("scalaz70")
  ).settings(
    baseSettings ++ Seq(
      libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.7"
    ) : _*
  )

  val scalaz71 = Project(
    "applybuilder71", file("scalaz71")
  ).settings(
    baseSettings ++ Seq(
      libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.3"
    ) : _*
  )

  val root = Project(
    "applybuilder", file(".")
  ).settings(
    commonSettings : _*
  ).settings(
    publishArtifact := false,
    publish := {},
    publishLocal := {}
  ).aggregate(scalaz70, scalaz71)

}

