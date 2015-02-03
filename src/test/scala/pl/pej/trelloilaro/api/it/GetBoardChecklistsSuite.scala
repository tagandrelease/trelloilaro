package pl.pej.trelloilaro.api.it

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.data.GetBoardChecklistsTestData
import pl.pej.trelloilaro.api.model.ChecklistJson
import pl.pej.trelloilaro.api.requestBuilder.GetBoardChecklists

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class GetBoardChecklistsSuite extends FunSuite with ApiTestBase with GetBoardChecklistsTestData with LazyLogging {

  def testHelper(request: GetBoardChecklists)(assertions: List[ChecklistJson] => Unit): List[ChecklistJson] = {
    val responseFuture: Future[List[ChecklistJson]] = client.getBoardChecklists(request)

    val response: List[ChecklistJson] = Await.result(responseFuture, 10 seconds)

    assertions(response)

    logger.debug(response.toString)
    response
  }

  test("Minimal lists (with no fields)") {
    import BoardChecklistsTestDataMinimal._
    testHelper(request)(assertFieldsDefined)
  }
  ignore("Full lists") {
    import BoardChecklistsTestData._
    testHelper(request)(assertFieldsDefined)
  }

}
