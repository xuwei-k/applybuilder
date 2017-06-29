scalacOptions ++= Seq("-deprecation", "-Xlint", "-unchecked", "-language:_")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.1")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.5")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "1.1")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.17")

addSbtPlugin("org.scala-native" % "sbt-scalajs-crossproject" % "0.2.0")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.3.1")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}
