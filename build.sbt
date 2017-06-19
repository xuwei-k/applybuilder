import com.typesafe.sbt.pgp.PgpKeys
import build._

val applybuilderJVM = applybuilder.jvm
val applybuilderJS = applybuilder.js
val applybuilderNative = applybuilder.native.settings(
  scalaVersion := Scala211
)

val root = Project(
  "root", file(".")
).settings(
  commonSettings,
  scalaSource in Compile := file("dummy"),
  scalaSource in Test := file("dummy"),
  PgpKeys.publishSigned := {},
  PgpKeys.publishLocalSigned := {},
  publishLocal := {},
  publishArtifact in Compile := false,
  publish := {}
).aggregate(
  applybuilderJVM, applybuilderJS
)
