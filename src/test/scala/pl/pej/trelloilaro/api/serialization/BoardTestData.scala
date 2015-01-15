package pl.pej.trelloilaro.api.serialization

import org.scalatest.Suite
import pl.pej.trelloilaro.api.requestBuilder.GetBoard
import pl.pej.trelloilaro.api.requestBuilder.builder.board
import pl.pej.trelloilaro.model.Board

/** Triples Request-JSON-Object to be used in tests.
  */
trait BoardTestData { this: Suite =>

  val testBoardShortId = "kVYrEz26"
  val testBoardFullId = "53aef54598654cd1f4486f08"
  def getBoard = GetBoard(testBoardShortId)

  protected object BoardTestDataMinimal {

    val request = getBoard.withFields()

    val json = s"""{
                 |  "id" : "$testBoardFullId"
                 |}
                 |""".stripMargin

    val example = Board(testBoardFullId)

    def assertFieldsDefined(b: Board): Unit = {

    }

  }

  protected object BoardTestDataPrimitiveFields {

    import board.{BoardField => F}
    val request = getBoard.withFields(F.closed, F.dateLastActivity, F.dateLastView, F.desc, F.descData, F.idOrganization,
      F.invitations, F.invited, F.name, F.pinned, F.powerUps, F.shortLink, F.shortUrl, F.starred, F.subscribed, F.url)

    val json = s"""{
                  |  "id" : "$testBoardFullId",
                  |  "closed" : false,
                  |  "dateLastActivity" : "2015-01-13T21:50:47.986Z",
                  |  "dateLastView" : null,
                  |  "desc" : "",
                  |  "descData" : null,
                  |  "idOrganization" : null,
                  |  "invitations" : [ ],
                  |  "invited" : false,
                  |  "name" : "ApiTestBoard",
                  |  "pinned" : false,
                  |  "powerUps" : [ "voting" ],
                  |  "shortLink" : "kVYrEz26",
                  |  "shortUrl" : "https://trello.com/b/kVYrEz26",
                  |  "starred" : null,
                  |  "subscribed" : null,
                  |  "url" : "https://trello.com/b/kVYrEz26/apitestboard"
                  |  }""".stripMargin

    val example = Board(
      id = testBoardFullId,
      closed = Some(false),
      dateLastActivity = Some("2015-01-13T21:50:47.986Z"),
      dateLastView = Some(None),
      desc = Some(""),
//      |  "descData" : null,
      idOrganization = Some(None),
      invitations = Some(Nil),
      invited = Some(false),
      name = Some("ApiTestBoard"),
      pinned = Some(false),
      powerUps = Some(List("voting")),
      shortLink = Some("kVYrEz26"),
      shortUrl = Some("https://trello.com/b/kVYrEz26"),
//    |  "starred" : null,
//    |  "subscribed" : null,
      url = Some("https://trello.com/b/kVYrEz26/apitestboard")
  )

    def assertFieldsDefined(b: Board): Unit = {
      assert(b.closed.isDefined)
      assert(b.dateLastActivity.isDefined)
      assert(b.dateLastView.isDefined)
      assert(b.desc.isDefined)
      assert(b.idOrganization.isDefined)
      assert(b.invitations.isDefined)
      assert(b.invited.isDefined)
      assert(b.name.isDefined)
      assert(b.pinned.isDefined)
      assert(b.powerUps.isDefined)
      assert(b.shortLink.isDefined)
      assert(b.shortUrl.isDefined)
      assert(b.url.isDefined)

    }

  }


  protected object BoardTestDataFull {

  }

}
