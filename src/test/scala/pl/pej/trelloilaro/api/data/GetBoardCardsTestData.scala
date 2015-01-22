package pl.pej.trelloilaro.api.data

import org.scalatest.Suite
import pl.pej.trelloilaro.api.requestBuilder.builder.card.CardField
import pl.pej.trelloilaro.api.requestBuilder.{GetBoardCards, GetBoardActions}
import pl.pej.trelloilaro.api.requestBuilder.builder.action.{Actions, ActionField}
import pl.pej.trelloilaro.api.serialization.BoardId
import pl.pej.trelloilaro.model._
import pl.pej.trelloilaro.model.card.{Badges, IdsInCard, CheckItemState}

/** Triples Request-JSON-Object to be used in tests.
   */
trait GetBoardCardsTestData extends BoardId { this: Suite =>

   def getBoardCards = GetBoardCards(testBoardShortId)

   protected object BoardCardsTestDataMinimal {

     val request = getBoardCards

     def json = """[ {
                  |  "id" : "54b5932921340cd822a5c8da"
                  |}, {
                  |  "id" : "54615567b38e3685c4910614"
                  |}, {
                  |  "id" : "54b5933743bebd1aa598e90c"
                  |} ]""".stripMargin

     def example = List(
       Card("54b5932921340cd822a5c8da"),
       Card("54615567b38e3685c4910614"),
       Card("54b5933743bebd1aa598e90c")
     )

     def assertFieldsDefined(b: List[Card]): Unit = {

     }
   }


  protected object BoardCardsTestDataPrimitiveFields {

    val request = {
      import CardField._
      getBoardCards.withCardFields(all)
    }

    def json = """[{
                 |  "id" : "54b5933743bebd1aa598e90c",
                 |  "checkItemStates" : [ {
                 |    "idCheckItem" : "54bfded8169333049807f2d2",
                 |    "state" : "complete"
                 |  }, {
                 |    "idCheckItem" : "54bfdedd04e6613bff133574",
                 |    "state" : "complete"
                 |  } ],
                 |  "closed" : false,
                 |  "dateLastActivity" : "2015-01-21T17:16:29.280Z",
                 |  "desc" : "",
                 |  "descData" : null,
                 |  "email" : null,
                 |  "idBoard" : "53aef54598654cd1f4486f08",
                 |  "idList" : "53aef54598654cd1f4486f0b",
                 |  "idMembersVoted" : [ ],
                 |  "idShort" : 3,
                 |  "idAttachmentCover" : null,
                 |  "manualCoverAttachment" : false,
                 |  "idLabels" : [ ],
                 |  "name" : "Have a beer",
                 |  "pos" : 65535,
                 |  "shortLink" : "RJCblPT4",
                 |  "badges" : {
                 |    "votes" : 0,
                 |    "viewingMemberVoted" : false,
                 |    "subscribed" : false,
                 |    "fogbugz" : "",
                 |    "checkItems" : 4,
                 |    "checkItemsChecked" : 2,
                 |    "comments" : 0,
                 |    "attachments" : 0,
                 |    "description" : false,
                 |    "due" : "2015-01-22T11:00:00.000Z"
                 |  },
                 |  "due" : "2015-01-22T11:00:00.000Z",
                 |  "idChecklists" : [ "54bfded3b3fab88459a29a6c" ],
                 |  "idMembers" : [ ],
                 |  "labels" : [ ],
                 |  "shortUrl" : "https://trello.com/c/RJCblPT4",
                 |  "subscribed" : false,
                 |  "url" : "https://trello.com/c/RJCblPT4/3-have-a-beer"
                 |} ]
                 |""".stripMargin

    def example = List(Card(
      id = "54b5933743bebd1aa598e90c",
      checkItemStates = Some(List(
        CheckItemState("54bfded8169333049807f2d2", "complete"),
        CheckItemState("54bfdedd04e6613bff133574", "complete")
      )),
      closed = Some(false),
      dateLastActivity = Some("2015-01-21T17:16:29.280Z"),
      desc = Some(""),
      descData = Some(None),
      email = Some(None),
      ids = IdsInCard(
        idBoard = Some("53aef54598654cd1f4486f08"),
        idList = Some("53aef54598654cd1f4486f0b"),
        idMembersVoted = Some(List()),
        idShort = Some(3),
        idAttachmentCover = Some(None),
        idLabels = Some(List()),
        idChecklists = Some(List("54bfded3b3fab88459a29a6c")),
        idMembers = Some(List())
      ),
      manualCoverAttachment = Some(false),
      name = Some("Have a beer"),
      pos = Some(65535),
      shortLink = Some("RJCblPT4"),
      badges = Some(Badges(
        votes = 0,
        viewingMemberVoted = false,
        subscribed = false,
        fogbugz = "",
        checkItems = 4,
        checkItemsChecked = 2,
        comments = 0,
        attachments = 0,
        description = false,
        due = Some("2015-01-22T11:00:00.000Z")
      )),
      due = Some(Some("2015-01-22T11:00:00.000Z")),
    //    labels = Some(List()),
      shortUrl = Some("https://trello.com/c/RJCblPT4"),
      subscribed = Some(false),
      url = Some("https://trello.com/c/RJCblPT4/3-have-a-beer")
    ))

    def assertFieldsDefined(cards: List[Card]): Unit = {

      assert(cards.forall{_.badges.isDefined})
      assert(cards.forall{_.closed.isDefined})
      assert(cards.forall{_.dateLastActivity.isDefined})
      assert(cards.forall{_.descData.isDefined})
      assert(cards.forall{_.due.isDefined})
      assert(cards.forall{_.email.isDefined})
      assert(cards.forall{_.ids.idAttachmentCover.isDefined})
      assert(cards.forall{_.ids.idBoard.isDefined})
      assert(cards.forall{_.ids.idChecklists.isDefined})
      assert(cards.forall{_.ids.idLabels.isDefined})
      assert(cards.forall{_.ids.idList.isDefined})
      assert(cards.forall{_.ids.idMembers.isDefined})
      assert(cards.forall{_.ids.idMembersVoted.isDefined})
      assert(cards.forall{_.ids.idShort.isDefined})

      assert(cards.forall{_.manualCoverAttachment.isDefined})
      assert(cards.forall{_.name.isDefined})
      assert(cards.forall{_.pos.isDefined})
      assert(cards.forall{_.shortLink.isDefined})
      assert(cards.forall{_.shortUrl.isDefined})
      assert(cards.forall{_.subscribed.isDefined})
      assert(cards.forall{_.url.isDefined})
    }
  }


}
