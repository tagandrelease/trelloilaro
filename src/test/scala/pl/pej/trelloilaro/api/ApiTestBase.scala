package pl.pej.trelloilaro.api

import pl.pej.trelloilaro.config.TrelloConfig
import pl.pej.trelloilaro.httpclient.TrelloHttpClient
import scala.concurrent.Future
import spray.http.HttpResponse
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import org.scalatest.FunSuite
import grizzled.slf4j.Logging


trait ApiTestBase {

  val config = TrelloConfig.load
  val client = new TrelloHttpClient(config.keys.appKey)

}