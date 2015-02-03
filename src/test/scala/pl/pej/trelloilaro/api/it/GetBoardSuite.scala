package pl.pej.trelloilaro.api.it

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.data.GetBoardTestData
import pl.pej.trelloilaro.api.model.BoardJson
import pl.pej.trelloilaro.api.requestBuilder.GetBoard
import pl.pej.trelloilaro.api.requestBuilder.builder.action.{ActionField, Actions}
import pl.pej.trelloilaro.api.requestBuilder.builder.board.BoardField

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class GetBoardSuite extends FunSuite with ApiTestBase with GetBoardTestData with LazyLogging {

  def testHelper(request: GetBoard)(assertions: BoardJson => Unit): BoardJson = {
    val responseFuture: Future[BoardJson] = client.getBoard(request)

    val response: BoardJson = Await.result(responseFuture, 10 seconds)
    assert(response.id === testBoardFullId)

    assertions(response)

    logger.debug(response.toString)
    response
  }

  ignore("Minimal board (with no fields)") {
    testHelper(BoardTestDataMinimal.request)(BoardTestDataMinimal.assertFieldsDefined)
  }

  test("Primitive fields only (no nested json objects in response)") {
    testHelper(BoardTestDataPrimitiveFields.request)(BoardTestDataPrimitiveFields.assertFieldsDefined)
  }

  ignore("Board: name, desc, closed, all actions with type (small fieldset)") {

    val request = getBoard.withActions(Actions.all).withActionFields(ActionField.`type`).withActionMemberCreator(false).withMemberOrNot(false)
      .withBoardFields(BoardField.name, BoardField.desc, BoardField.closed)

    val res = testHelper(request) { b =>
      assert(b.closed.isDefined)
      assert(b.name.isDefined)
      assert(b.desc.isDefined)
      assert(b.actions.isDefined)

      assert(b.actions.isDefined)
      assert(b.actions.get.nonEmpty)
      b.actions.get.map { a =>
        assert(a.`type`.nonEmpty)
      }
    }
  }

  ignore("Board withActioMemberCreator(true) and withActionsLimit(3)") {

    val request = getBoard.withActionMemberCreator(true).withLimit(3).withActions(Actions.all).withActionFields(ActionField.`type`)

    val board: BoardJson = testHelper(request){ b =>

    }
  }

}
