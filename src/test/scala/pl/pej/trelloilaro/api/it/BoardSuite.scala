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

  val testBoardId = "kVYrEz26"
  def getBoard = GetBoard(testBoardId)


  def testHelper(request: GetBoard): Board = {

    val responseFuture: Future[Board] = client.getBoard(request)

    val response: Board = Await.result(responseFuture, 10 seconds)

    response
  }

  test("Basic board (empty getboard request)") {

    val request = getBoard

    testHelper(request)
  }

  test("Board withActioMemberCreator(true) and withActionsLimit(3)") {

    val request = getBoard.withActionMemberCreator(true).withActionsLimit(3)

    val board = testHelper(request)
    assert(board.action.size <= 3)

  }

}
