import sbt._
import sbt.Keys._
import scala._
import com.typesafe.sbt.SbtAtmosPlay.atmosPlaySettings

object BuildSettings {
  val buildVersion = "0.1"
  val buildScalaVersion = "2.11.2"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    libraryDependencies ++= Dependencies.list,
    resolvers ++= Resolvers.list
  )

}

object Resolvers {
  val spray = "spray repo" at "http://repo.spray.io"

  lazy val jawn = "Jawn" at "http://dl.bintray.com/non/maven"

  val list = List(spray, jawn)
}

object Dependencies {

  val akkaVersion = "2.3.6"
  val musterVer = "0.3.0"

  val sprayClient = "io.spray" % "spray-client_2.11" % "1.3.2"

  object Serialization {
//    lazy val musterJawn = "org.json4s" %% "muster-codec-jawn" % musterVer
//    lazy val musterJson4s= "org.json4s" %% "muster-codec-json4s" % musterVer
//    lazy val musterString = "org.json4s" %% "muster-codec-string" % musterVer
//
//    lazy val bundle = Seq(musterJawn, musterJson4s, musterString)
      lazy val playJson = "com.typesafe.play" % "play-json_2.11" % "2.4.0-M2"

      lazy val bundle = Seq(playJson)
  }

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaTest = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
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
