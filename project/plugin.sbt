scalacOptions ++= Seq("-deprecation", "-Xlint", "-unchecked", "-language:_")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.1")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.5")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.22")

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.3.1")

addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.3.6")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}
