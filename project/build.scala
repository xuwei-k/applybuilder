import sbt._, Keys._

import sbtrelease._
import ReleasePlugin.autoImport._
import ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys
import org.scalajs.sbtplugin.cross.CrossProject
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object build {

  private[this] def gitHash(): String = sys.process.Process("git rev-parse HEAD").lines_!.head

  private[this] val tagName = Def.setting{
    s"v${if (releaseUseGlobalVersion.value) (version in ThisBuild).value else version.value}"
  }

  private[this] val tagOrHash = Def.setting{
    if(isSnapshot.value) gitHash() else tagName.value
  }

  def releaseStepAggregateCross[A](key: TaskKey[A]): ReleaseStep = ReleaseStep(
    action = { state =>
      val extracted = Project extract state
      extracted.runAggregated(key in Global in extracted.get(thisProjectRef), state)
    },
    enableCrossBuild = true
  )

  val sonatypeURL = "https://oss.sonatype.org/service/local/repositories/"

  private[this] final val Scala210 = "2.10.6"

  private val projectName = "applybuilder"

  val updateReadme = { state: State =>
    val extracted = Project.extract(state)
    val scalaV = extracted get scalaBinaryVersion
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
    git.commit(message = "update " + readme, sign = false) ! state.log
    "git diff HEAD^" ! state.log
    state
  }

  val updateReadmeProcess: ReleaseStep = updateReadme

  private[this] val unusedWarnings = (
    "-Ywarn-unused" ::
    "-Ywarn-unused-import" ::
    Nil
  )

  val commonSettings = Seq(
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
      setNextVersion,
      commitNextVersion,
      releaseStepCommand("sonatypeReleaseAll"),
      updateReadmeProcess,
      pushChanges
    ),
    scalaVersion := Scala210,
    crossScalaVersions := "2.11.11" :: Scala210 :: "2.12.2" :: "2.13.0-M1" :: Nil,
    organization := "com.github.xuwei-k",
    startYear := Some(2014),
    description := "scalaz.Apply builder",
    scalacOptions in (Compile, doc) ++= {
      val tag = tagOrHash.value
      Seq(
        "-sourcepath", baseDirectory.value.getAbsolutePath,
        "-doc-source-url", s"https://github.com/xuwei-k/applybuilder/tree/${tag}€{FILE_PATH}.scala"
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
      <tag>{tagOrHash.value}</tag>
    </scm>
    ),
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
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
    }.toList.flatten
  ) ++ Seq(Compile, Test).flatMap(c =>
    scalacOptions in (c, console) ~= {_.filterNot(unusedWarnings.toSet)}
  )

  val scalazVersion = SettingKey[String]("scalazVersion")

  val applybuilder = CrossProject(
    projectName, file("."), CustomCrossType
  ).settings(
    commonSettings,
    scalazVersion := "7.2.12",
    libraryDependencies += "org.scalaz" %%% "scalaz-core" % scalazVersion.value
  ).jsSettings(
    scalacOptions += {
      val a = (baseDirectory in LocalRootProject).value.toURI.toString
      val g = "https://raw.githubusercontent.com/xuwei-k/applybuilder/" + tagOrHash.value
      s"-P:scalajs:mapSourceURI:$a->$g/"
    }
  )
}
