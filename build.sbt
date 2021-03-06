name := "pict-workshop"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  ws,
  "com.typesafe.akka" %% "akka-stream" % "2.4.2-RC1",
  "com.typesafe.akka" %% "akka-slf4j" % "2.4.2-RC1",
  "org.scala-lang.modules" %% "scala-async" % "0.9.5",

  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-encoding", "UTF-8"       // yes, this is 2 args
)
