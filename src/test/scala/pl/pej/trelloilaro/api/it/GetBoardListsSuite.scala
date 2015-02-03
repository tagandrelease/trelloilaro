package pl.pej.trelloilaro.api.it

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.data.GetBoardListsTestData
import pl.pej.trelloilaro.api.model.ListJson
import pl.pej.trelloilaro.api.requestBuilder.GetBoardLists

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class GetBoardListsSuite extends FunSuite with ApiTestBase with GetBoardListsTestData with LazyLogging {

  def testHelper(request: GetBoardLists)(assertions: List[ListJson] => Unit): List[ListJson] = {
    val responseFuture: Future[List[ListJson]] = client.getBoardLists(request)

    val response: List[ListJson] = Await.result(responseFuture, 10 seconds)

    assertions(response)

    logger.debug(response.toString)
    response
  }

  ignore("Minimal checklists (with no fields)") {
    import BoardListsTestDataMinimal._
    testHelper(request)(assertFieldsDefined)
  }
  test("Full checklists") {
    import BoardListsTestData._
    testHelper(request)(assertFieldsDefined)
  }

}
