import sbt._
import sbt.Keys._
import scala._
import com.typesafe.sbt.SbtAtmosPlay.atmosPlaySettings

object BuildSettings {
  val buildVersion = "0.0.3"
  val buildScalaVersion = "2.11.2"

  val buildSettings = Defaults.coreDefaultSettings ++ Seq(
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    libraryDependencies ++= Dependencies.list,
    resolvers ++= Resolvers.list,
    organization := "org.tejo"
  )

}

object Resolvers {
  val spray = "spray repo" at "http://repo.spray.io"

  val list = List(spray)
}

object Dependencies {

  val akkaVersion = "2.3.6"

  val sprayClient = "io.spray" % "spray-client_2.11" % "1.3.2" % "test"

  object Serialization {
      lazy val playJson = "com.typesafe.play" %% "play-json" % "2.4.0-M2"

      lazy val bundle = Seq(playJson)
  }

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion  % "test"
  val akkaTest = "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test"
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion % "test"
  val ficus = "net.ceedubs" %% "ficus" % "1.1.1"

  val akka = akkaActor :: akkaTest :: akkaSlf4j :: Nil

//  val typesafeConsole = "com.typesafe.atmos" % "trace-play-2.2.0" % "1.3.1"
//  val typesafeConfig = "com.typesafe" % "config" % "1.0.2"
  val scalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

  val logger = Seq(
    "org.clapper" %% "grizzled-slf4j" % "1.0.2",
    "ch.qos.logback" % "logback-classic" % "1.1.2",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0")

  def list = List(sprayClient, ficus, scalaTest) ++ akka ++ logger ++ Serialization.bundle
}

object TrelloilaroBuild extends Build {

  import BuildSettings._

  val projectName = "trelloilaro"

  lazy val trelloilaro = Project(
    id = projectName,
    base = file("."),
    settings = buildSettings ++ Seq(name := projectName)
  )
}
