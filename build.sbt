resolvers += Resolver.sonatypeRepo("public")

name := "ScalaProject"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies += "ch.qos.logback" % "logback-core" % "1.2.3"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.17"

libraryDependencies += "junit" % "junit" % "4.12" % Test

lazy val hello = taskKey[Unit]("An example task")
lazy val root = (project in file(".")).settings(hello := {
  println("Hello!")
})