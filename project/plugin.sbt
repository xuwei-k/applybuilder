scalacOptions ++= Seq("-deprecation", "-unchecked", "-language:_")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.11")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.28")

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.6.0")

addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "0.6.0")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.3.9")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}
