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
                 |  "id" : "$testBoardShortId"
                 |}
                 |""".stripMargin

    val example = Board(testBoardShortId)

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

    val fullBoardJSON = ""

  }

}
