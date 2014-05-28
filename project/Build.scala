import sbt._
import sbt.Keys._
import scala._
import com.typesafe.sbt.SbtAtmosPlay.atmosPlaySettings

object BuildSettings {
  val buildVersion = "0.1"
  val buildScalaVersion = "2.10.3"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    libraryDependencies ++= Dependencies.list,
    resolvers ++= Resolvers.list
  )

}

object Resolvers {
  val spray = "spray repo" at "http://repo.spray.io"

  val list = List(spray)
}

object Dependencies {

  val akkaVersion = "2.2.3"

  val sprayClient = "io.spray" % "spray-client" % "1.2.0"
  val sprayJson = "io.spray" %%  "spray-json" % "1.2.5"

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaTest = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
  val ficus = "net.ceedubs" %% "ficus" % "1.0.0"

  val akka = akkaActor :: akkaTest :: akkaSlf4j :: Nil

//  val typesafeConsole = "com.typesafe.atmos" % "trace-play-2.2.0" % "1.3.1"
//  val typesafeConfig = "com.typesafe" % "config" % "1.0.2"
  val scalaTest = "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

  val logger = Seq(
    "org.clapper" %% "grizzled-slf4j" % "1.0.2",
    "ch.qos.logback" % "logback-classic" % "1.1.2")

  def list = List(sprayClient, sprayJson, ficus, scalaTest) ++ akka ++ logger
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
