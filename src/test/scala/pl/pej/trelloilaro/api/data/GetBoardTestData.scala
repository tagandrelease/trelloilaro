package pl.pej.trelloilaro.api.data

import org.scalatest.Suite
import pl.pej.trelloilaro.api.model.BoardJson
import pl.pej.trelloilaro.api.requestBuilder.GetBoard
import pl.pej.trelloilaro.api.serialization.BoardId

/** Triples Request-JSON-Object to be used in tests.
  */
trait GetBoardTestData extends BoardId { this: Suite =>

  def getBoard = GetBoard(testBoardShortId)

  protected object BoardTestDataMinimal {

    val request = getBoard.withBoardFields()

    val json = s"""{
                 |  "id" : "$testBoardFullId"
                 |}
                 |""".stripMargin

    val example = BoardJson(testBoardFullId)

    def assertFieldsDefined(b: BoardJson): Unit = {

    }

  }

  protected object BoardTestDataPrimitiveFields {

    import pl.pej.trelloilaro.api.requestBuilder.builder.board.{BoardField => F}
    val request = getBoard.withBoardFields(F.closed, F.dateLastActivity, F.dateLastView, F.desc, F.descData, F.idOrganization,
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

    val example = BoardJson(
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

    def assertFieldsDefined(b: BoardJson): Unit = {
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
