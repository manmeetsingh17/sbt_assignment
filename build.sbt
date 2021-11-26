name := "SbtAssignment"

version := "0.1"

scalaVersion := "2.12.12"


lazy val common = project.in(file("common")).settings(
  libraryDependencies ++= Seq(
    "io.github.embeddedkafka" %% "embedded-kafka" % "3.0.0" % Test,
    "com.softwaremill.sttp.client" %% "json4s" % "2.2.10",
    "org.scalactic" %% "scalactic" % "3.2.9",
  ),

  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % "test",
    "org.mockito" %% "mockito-scala" % "1.16.46" % Test,
  )
)
lazy val Actor = project.in(file("Actor")).settings(
  libraryDependencies ++= Seq(
    "se.scalablesolutions.akka" % "akka-typed-actor" % "1.1.2",
    "com.typesafe.akka" %% "akka-stream" % "2.6.17",
    "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.17",
  ),

  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.17" % Test,
    "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % "test",
  )
)

lazy val root = project.in(file(".")).aggregate(common, Actor)