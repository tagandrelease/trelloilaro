package pl.pej.trelloilaro.api.it

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.requestBuilder.GetBoard
import scala.concurrent.Future
import spray.http.HttpResponse
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import pl.pej.trelloilaro.model.Board
import pl.pej.trelloilaro.api.ApiTestBase

class BoardSuite extends FunSuite with ApiTestBase {

  test("Basic board (empty getboard request)") {

    val request = GetBoard("kVYrEz26")

    val responseFuture: Future[Board] = client.getBoard(request)

    val response: Board = Await.result(responseFuture, 10 seconds)

    println(response)

  }


}
