package pl.pej.trelloilaro.api.it

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.data.GetBoardCardsTestData
import pl.pej.trelloilaro.api.model.CardJson
import pl.pej.trelloilaro.api.requestBuilder.GetBoardCards

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class GetBoardCardsSuite extends FunSuite with ApiTestBase with GetBoardCardsTestData with LazyLogging {

  def testHelper(request: GetBoardCards)(assertions: List[CardJson] => Unit): List[CardJson] = {
    val responseFuture: Future[List[CardJson]] = client.getBoardCards(request)

    val response: List[CardJson] = Await.result(responseFuture, 10 seconds)

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
