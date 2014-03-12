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

  val commonSettings = ReleasePlugin.releaseSettings ++ Sonatype.sonatypeSettings ++ Seq(
    sourcesInBase := false,
    credentials ++= ((sys.env.get("SONATYPE_USER"), sys.env.get("SONATYPE_PASS")) match {
      case (Some(user), Some(pass)) =>
        Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass) :: Nil
      case _ =>
        Nil
    }),
    ReleasePlugin.ReleaseKeys.releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      releaseStepAggregateCross(PgpKeys.publishSigned),
      setNextVersion,
      commitNextVersion,
      releaseStepAggregateCross(Sonatype.SonatypeKeys.sonatypeReleaseAll),
      pushChanges
    ),
    scalaVersion := "2.10.3",
    crossScalaVersions := List("2.11.0-RC1", "2.10.3", "2.9.3"),
    organization := "com.github.xuwei-k",
    startYear := Some(2014),
    scmInfo := Some(ScmInfo(
      url("https://github.com/xuwei-k/applybuilder"),
      "scm:git:git@github.com:xuwei-k/applybuilder.git"
    )),
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
    ),
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
    scalacOptions ++= Seq("-deprecation", "-Xlint", "-unchecked") ++ (
      if(scalaVersion.value.startsWith("2.9")) Seq("-Ydependent-method-types") else Seq("-language:_")
    ),
    showDoc in Compile <<= (doc in Compile, target in doc in Compile) map { (_, out) =>
      java.awt.Desktop.getDesktop.open(out / "index.html")
    }
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
      libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.6"
    ) : _*
  )

  val scalaz71 = Project(
    "applybuilder71", file("scalaz71")
  ).settings(
    baseSettings ++ Seq(
      libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.0-M6"
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

