package pl.pej.trelloilaro.api.it

import com.typesafe.scalalogging.LazyLogging
import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.ApiTestBase
import pl.pej.trelloilaro.api.data.GetBoardChecklistsTestData
import pl.pej.trelloilaro.api.requestBuilder.GetBoardChecklists
import pl.pej.trelloilaro.model.Checklist

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class GetBoardChecklistsSuite extends FunSuite with ApiTestBase with GetBoardChecklistsTestData with LazyLogging {

  def testHelper(request: GetBoardChecklists)(assertions: List[Checklist] => Unit): List[Checklist] = {
    val responseFuture: Future[List[Checklist]] = client.getBoardChecklists(request)

    val response: List[Checklist] = Await.result(responseFuture, 10 seconds)

    assertions(response)

    logger.debug(response.toString)
    response
  }

  ignore("Minimal checklists (with no fields)") {
    import BoardChecklistsTestDataMinimal._
    testHelper(request)(assertFieldsDefined)
  }
  test("Full checklists") {
    import BoardChecklistsTestData._
    testHelper(request)(assertFieldsDefined)
  }

}
