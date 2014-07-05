package pl.pej.trelloilaro.api.it

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.requestBuilder.GetBoard
import scala.concurrent.Future
import spray.http.HttpResponse
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._

class BoardSuite extends FunSuite with ApiTestBase {

  test("Basic board (empty getboard request)") {

    val request = GetBoard("kVYrEz26")

    val responseFuture: Future[HttpResponse] = client.get(request.toString)

    val response: HttpResponse = Await.result(boardFuture, 10 seconds)


    val board = response.

  }


}
