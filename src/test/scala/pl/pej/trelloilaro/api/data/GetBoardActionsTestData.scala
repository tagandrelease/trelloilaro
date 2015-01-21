package pl.pej.trelloilaro.api.data

import org.scalatest.Suite
import pl.pej.trelloilaro.api.requestBuilder.builder.action.ActionField
import pl.pej.trelloilaro.api.requestBuilder.{GetBoardActions, GetBoard}
import pl.pej.trelloilaro.api.serialization.BoardId
import pl.pej.trelloilaro.model.{Action, Board}

/** Triples Request-JSON-Object to be used in tests.
   */
trait GetBoardActionsTestData extends BoardId { this: Suite =>

   def getBoardActions = GetBoardActions(testBoardShortId)

   protected object BoardActionsTestDataMinimal {

     val request = getBoardActions.withActionFields(ActionField.`type`).withMemberOrNot(false).withActionMemberCreator(false)

     def json = """[ {
                  |  "id" : "54b70a5c9237745d4b209511",
                  |  "type" : "updateBoard"
                  |}, {
                  |  "id" : "54b70a1ff97d7ca49585912f",
                  |  "type" : "unconfirmedBoardInvitation"
                  |}, {
                  |  "id" : "54b709fba5a61328b90ccdb6",
                  |  "type" : "enablePowerUp"
                  |}, {
                  |  "id" : "54b5933843bebd1aa598e90d",
                  |  "type" : "createCard"
                  |}, {
                  |  "id" : "54b5932f460c94e54a4a1b81",
                  |  "type" : "updateCard"
                  |}, {
                  |  "id" : "54b5932a21340cd822a5c8db",
                  |  "type" : "createCard"
                  |}, {
                  |  "id" : "54b5931f26ceced2fe86ead6",
                  |  "type" : "addMemberToCard"
                  |}, {
                  |  "id" : "54615567b38e3685c4910615",
                  |  "type" : "createCard"
                  |}, {
                  |  "id" : "53aef54598654cd1f4486f0d",
                  |  "type" : "createBoard"
                  |} ]
                  |""".stripMargin

     def example = List(
         Action("54b70a5c9237745d4b209511", `type` = Some("updateBoard")),
         Action("54b70a1ff97d7ca49585912f", `type` = Some("unconfirmedBoardInvitation")),
         Action("54b709fba5a61328b90ccdb6", `type` = Some("enablePowerUp")),
         Action("54b5933843bebd1aa598e90d", `type` = Some("createCard")),
         Action("54b5932f460c94e54a4a1b81", `type` = Some("updateCard")),
         Action("54b5932a21340cd822a5c8db", `type` = Some("createCard")),
         Action("54b5931f26ceced2fe86ead6", `type` = Some("addMemberToCard")),
         Action("54615567b38e3685c4910615", `type` = Some("createCard")),
         Action("53aef54598654cd1f4486f0d", `type` = Some("createBoard"))
     )

     def assertFieldsDefined(b: List[Action]): Unit = {

       b.forall { a: Action => a.`type`.isDefined}
     }
   }


  protected object BoardActionsTestDataPrimitiveFields {

    val request = getBoardActions.withEntities(false)
      .withActionFields(ActionField.date, ActionField.idMemberCreator, ActionField.`type`)
      .withMemberOrNot(false)
      .withActionMemberCreator(false)

    def json = """"""

    def example = ???/*List(
      Action("54b70a5c9237745d4b209511", `type` = Some("updateBoard")),
      Action("54b70a1ff97d7ca49585912f", `type` = Some("unconfirmedBoardInvitation")),
      Action("54b709fba5a61328b90ccdb6", `type` = Some("enablePowerUp")),
      Action("54b5933843bebd1aa598e90d", `type` = Some("createCard")),
      Action("54b5932f460c94e54a4a1b81", `type` = Some("updateCard")),
      Action("54b5932a21340cd822a5c8db", `type` = Some("createCard")),
      Action("54b5931f26ceced2fe86ead6", `type` = Some("addMemberToCard")),
      Action("54615567b38e3685c4910615", `type` = Some("createCard")),
      Action("53aef54598654cd1f4486f0d", `type` = Some("createBoard"))
    )*/

    def assertFieldsDefined(b: List[Action]): Unit = {

      b.forall { a: Action => a.`type`.isDefined}
      b.forall { a: Action => a.date.isDefined}
      b.forall { a: Action => a.idMemberCreator.isDefined}
    }
  }


}
