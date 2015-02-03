package pl.pej.trelloilaro.api.data

import org.scalatest.Suite
import pl.pej.trelloilaro.api.model.{ListJson, ChecklistJson}
import pl.pej.trelloilaro.api.model.checklist.CheckItemJson
import pl.pej.trelloilaro.api.requestBuilder.builder.list.ListField
import pl.pej.trelloilaro.api.requestBuilder.{GetBoardLists, GetBoardChecklists}
import pl.pej.trelloilaro.api.requestBuilder.builder.card.Card
import pl.pej.trelloilaro.api.requestBuilder.builder.checklist.{CheckItemField, CheckItems, ChecklistField}
import pl.pej.trelloilaro.api.serialization.BoardId

/** Triples Request-JSON-Object to be used in tests.
   */
trait GetBoardListsTestData extends BoardId { this: Suite =>

   def getBoardLists = GetBoardLists(testBoardShortId)

   protected object BoardListsTestDataMinimal {

     val request = getBoardLists.withCards(Card.none).withListFields()

     def json = """[ {
                  |  "id" : "53aef54598654cd1f4486f09"
                  |}, {
                  |  "id" : "53aef54598654cd1f4486f0a"
                  |}, {
                  |  "id" : "53aef54598654cd1f4486f0b"
                  |} ]""".stripMargin

     def example = List(
       ListJson(
         id = "53aef54598654cd1f4486f09"),
       ListJson(
        id = "53aef54598654cd1f4486f0a"),
       ListJson(
        id = "53aef54598654cd1f4486f0b")
     )

     def assertFieldsDefined(b: List[ListJson]): Unit = {

     }
   }


  protected object BoardListsTestData {

    val request = getBoardLists.withCards(Card.none).withListFields(ListField.all)

    def json = """[ {
                 |  "id" : "53aef54598654cd1f4486f09",
                 |  "name" : "To Do",
                 |  "closed" : false,
                 |  "idBoard" : "53aef54598654cd1f4486f08",
                 |  "pos" : 16384,
                 |  "subscribed" : null
                 |}, {
                 |  "id" : "53aef54598654cd1f4486f0a",
                 |  "name" : "Doing",
                 |  "closed" : false,
                 |  "idBoard" : "53aef54598654cd1f4486f08",
                 |  "pos" : 32768,
                 |  "subscribed" : null
                 |}, {
                 |  "id" : "53aef54598654cd1f4486f0b",
                 |  "name" : "Done",
                 |  "closed" : false,
                 |  "idBoard" : "53aef54598654cd1f4486f08",
                 |  "pos" : 49152,
                 |  "subscribed" : null
                 |} ]""".stripMargin

    def example = List(
      ListJson(
        id = "53aef54598654cd1f4486f09",
        name = Some("To Do"),
        closed = Some(false),
        idBoard = Some("53aef54598654cd1f4486f08"),
        pos = Some(16384)),
      ListJson(
        id = "53aef54598654cd1f4486f0a",
        name = Some("Doing"),
        closed = Some(false),
        idBoard = Some("53aef54598654cd1f4486f08"),
        pos = Some(32768)),
      ListJson(
        id = "53aef54598654cd1f4486f0b",
        name = Some("Done"),
        closed = Some(false),
        idBoard = Some("53aef54598654cd1f4486f08"),
        pos = Some(49152))
    )
    def assertFieldsDefined(b: List[ListJson]): Unit = {

    }
  }
}
