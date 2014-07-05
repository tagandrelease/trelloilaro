package pl.pej.trelloilaro.api

import pl.pej.trelloilaro.config.TrelloConfig
import pl.pej.trelloilaro.httpclient.TrelloHttpClient
import scala.concurrent.Future
import spray.http.HttpResponse
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import org.scalatest.FunSuite
import grizzled.slf4j.Logging


trait ApiTestBase extends Logging {

  val config = TrelloConfig.load
  val client = new TrelloHttpClient(config.keys.appKey)
//  val future: Future[HttpResponse] = client.get("board/4d5ea62fd76aa1136000000c")

  def responses_?(url: String) = {
    val future = client.get(url)
    val res = Await.result(future, 10 seconds)

    assert(res.status.isSuccess)

    info(res.entity.asString)
  }
}