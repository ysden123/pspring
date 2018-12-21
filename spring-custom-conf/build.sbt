import sbt.Keys.libraryDependencies

lazy val scalaLoggingVersion = "3.9.0"
lazy val logbackClassicVersion = "1.2.3"
lazy val springBootVersion = "2.0.1.RELEASE"
lazy val scalaTestVersion = "3.0.4"
lazy val scalaCheckVersion = "1.14.0"

lazy val commonSettings = Seq(
  organization := "com.stulsoft",
  version := "1.0.0",
  javacOptions ++= Seq("-source", "11"),
  scalaVersion := "2.12.7",
  scalacOptions ++= Seq(
    "-feature",
    "-language:implicitConversions",
    "-language:postfixOps"),
  libraryDependencies ++= Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
    "ch.qos.logback" % "logback-classic" % logbackClassicVersion,
//    "org.springframework.boot" % "spring-boot-starter-parent" % springBootVersion,
    "org.springframework.boot" % "spring-boot-starter" % springBootVersion,
//    "javax.inject" % "javax.inject",
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "test",
    "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion % "test"
  )
)

lazy val springCustomConf = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "spring-custom-conf"
  )
