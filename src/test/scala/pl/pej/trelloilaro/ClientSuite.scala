package pl.pej.trelloilaro

import com.typesafe.config.ConfigFactory
import org.scalatest.FunSuite
import pl.pej.trelloilaro.config.TrelloConfig
import pl.pej.trelloilaro.httpclient.TrelloHttpClient
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import spray.http.HttpResponse


class ClientSuite extends FunSuite{

  val config = TrelloConfig.load


  test("Correct response code for public API") {

    val client = new TrelloHttpClient(config.keys.appKey)

    val future: Future[HttpResponse] = client.get("board/4d5ea62fd76aa1136000000c")

    val res: HttpResponse = Await.result(future, 10 seconds)

    assert(res.status.isSuccess)
    println(res)
  }
}
