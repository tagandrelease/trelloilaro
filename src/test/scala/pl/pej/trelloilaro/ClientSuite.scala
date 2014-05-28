package pl.pej.trelloilaro

import com.typesafe.config.ConfigFactory
import org.scalatest.FunSuite
import pl.pej.trelloilaro.config.TrelloConfig
import pl.pej.trelloilaro.httpclient.TrelloHttpClient
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import spray.http.HttpResponse
import pl.pej.trelloilaro.api.ApiTestBase


class ClientSuite extends FunSuite with ApiTestBase {

  test("Correct response code for public API") {
    responses_?("board/4d5ea62fd76aa1136000000c")
  }
}
