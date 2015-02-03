package pl.pej.trelloilaro.api.data

import org.scalatest.Suite
import pl.pej.trelloilaro.api.model.ChecklistJson
import pl.pej.trelloilaro.api.model.checklist.CheckItemJson
import pl.pej.trelloilaro.api.requestBuilder.GetBoardChecklists
import pl.pej.trelloilaro.api.requestBuilder.builder.card.Card
import pl.pej.trelloilaro.api.requestBuilder.builder.checklist.{CheckItemField, CheckItems, ChecklistField}
import pl.pej.trelloilaro.api.serialization.BoardId

/** Triples Request-JSON-Object to be used in tests.
   */
trait GetBoardChecklistsTestData extends BoardId { this: Suite =>

   def getBoardChecklists = GetBoardChecklists(testBoardShortId)

   protected object BoardChecklistsTestDataMinimal {

     val request = getBoardChecklists.withCards(Card.none).withCheckItems(CheckItems.none).withChecklistFields()

     def json = """[ {
                  |  "id" : "54bfded3b3fab88459a29a6c"
                  |} ]
                  |""".stripMargin

     def example = List(
      ChecklistJson("54bfded3b3fab88459a29a6c")
     )

     def assertFieldsDefined(b: List[ChecklistJson]): Unit = {

     }
   }


  protected object BoardChecklistsTestData {

    val request = getBoardChecklists.withCards(Card.none).withCheckItems(CheckItems.all)
      .withCheckItemFields(CheckItemField.all).withChecklistFields(ChecklistField.all)

    def json = """[ {
                 |  "id" : "54bfded3b3fab88459a29a6c",
                 |  "name" : "Checklist",
                 |  "idBoard" : "53aef54598654cd1f4486f08",
                 |  "idCard" : "54b5933743bebd1aa598e90c",
                 |  "pos" : 16384,
                 |  "checkItems" : [ {
                 |    "state" : "complete",
                 |    "id" : "54bfded8169333049807f2d2",
                 |    "name" : "Elekti bongustan bieron",
                 |    "nameData" : null,
                 |    "type" : null,
                 |    "pos" : 16928
                 |  }, {
                 |    "state" : "complete",
                 |    "id" : "54bfdedd04e6613bff133574",
                 |    "name" : "Aĉeti ĝin",
                 |    "nameData" : null,
                 |    "type" : null,
                 |    "pos" : 34045
                 |  }, {
                 |    "state" : "incomplete",
                 |    "id" : "54bfdee536f4c5c712dd7e0e",
                 |    "name" : "Enverŝi en glason",
                 |    "nameData" : null,
                 |    "type" : null,
                 |    "pos" : 51367
                 |  }, {
                 |    "state" : "incomplete",
                 |    "id" : "54bfdeea261eb6b0e754ee42",
                 |    "name" : "Fortrinki",
                 |    "nameData" : null,
                 |    "type" : null,
                 |    "pos" : 68412
                 |  } ]
                 |} ]
                 |""".stripMargin

    def example = List(
      ChecklistJson(
        id = "54bfded3b3fab88459a29a6c",
        name = Some("Checklist"),
        idBoard = Some("53aef54598654cd1f4486f08"),
        idCard = Some("54b5933743bebd1aa598e90c"),
        pos = Some(16384),
        checkItems = Some(List(
          CheckItemJson(
            state = Some("complete"),
            id = "54bfded8169333049807f2d2",
            name = Some("Elekti bongustan bieron"),
            pos = Some(16928)),
          CheckItemJson(
            state = Some("complete"),
            id = "54bfdedd04e6613bff133574",
            name = Some("Aĉeti ĝin"),
            pos = Some(34045)),
          CheckItemJson(
            state = Some("incomplete"),
            id = "54bfdee536f4c5c712dd7e0e",
            name = Some("Enverŝi en glason"),
            pos = Some(51367)),
          CheckItemJson(
            state = Some("incomplete"),
            id = "54bfdeea261eb6b0e754ee42",
            name = Some("Fortrinki"),
            pos = Some(68412))
      )
        )
    ))

    def assertFieldsDefined(b: List[ChecklistJson]): Unit = {
      b.forall { c: ChecklistJson => c.idBoard.isDefined}
      b.forall { c: ChecklistJson => c.idCard.isDefined}
      b.forall { c: ChecklistJson => c.checkItems.isDefined}
      b.forall { c: ChecklistJson => c.name.isDefined}
      b.forall { c: ChecklistJson => c.pos.isDefined}
      b.forall { c: ChecklistJson => c.checkItems.map{ items =>
        items.forall{ i =>
          i.name.isDefined && i.pos.isDefined && i.state.isDefined
        }
      }.getOrElse(true)
      }
    }
  }
}
