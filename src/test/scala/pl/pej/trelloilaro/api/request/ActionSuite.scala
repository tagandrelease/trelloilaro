package pl.pej.trelloilaro.api.request

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.request.builder.action.{ActionFieldsRequestBuilder, ActionFieldsBuilder, ActionBuilder}
import ActionBuilder.updateBoard

class ActionSuite extends FunSuite {

  val builder = ActionRequestBuilder("URL")
  test("ActionBuilder") {

    val newUrl = builder.withAction(updateBoard, ActionBuilder.addMemberToCard)

    assert(newUrl.toString === "URL&action=updateBoard,addMemberToCard")
  }

  test("ActionFields") {
    val newUrl = builder.withActionFields(ActionFieldsRequestBuilder.data, ActionFieldsRequestBuilder.date)

    assert(newUrl.toString === "URL&action_fields=data,date")
  }

  test("ActionEntities") {
    val newUrl = builder.withActionsEntities(true)

    assert(newUrl.toString === "URL&entities=true")
  }


}
