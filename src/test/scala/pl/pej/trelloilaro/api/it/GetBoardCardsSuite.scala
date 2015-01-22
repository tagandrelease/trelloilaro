package pl.pej.trelloilaro.api.it

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.data.{GetBoardCardsTestData, GetBoardActionsTestData}
import pl.pej.trelloilaro.api.requestBuilder.{GetBoardCards, GetBoardActions}
import pl.pej.trelloilaro.model.{Card, Action}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class GetBoardCardsSuite extends FunSuite with ApiTestBase with GetBoardCardsTestData with LazyLogging {

  def testHelper(request: GetBoardCards)(assertions: List[Card] => Unit): List[Card] = {
    val responseFuture: Future[List[Card]] = client.getBoardCards(request)

    val response: List[Card] = Await.result(responseFuture, 10 seconds)

    assertions(response)

    logger.debug(response.toString)
    response
  }

  ignore("Minimal cards (with no fields)") {
    testHelper(BoardCardsTestDataMinimal.request)(BoardCardsTestDataMinimal.assertFieldsDefined)
  }
  test("All primitive fields + badges of cards") {
    testHelper(BoardCardsTestDataPrimitiveFields.request)(BoardCardsTestDataPrimitiveFields.assertFieldsDefined)
  }

}
