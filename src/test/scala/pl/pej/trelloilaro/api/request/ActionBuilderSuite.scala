package pl.pej.trelloilaro.api.request

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.request.builder.action.ActionBuilder
import ActionBuilder.updateBoard
import pl.pej.trelloilaro.api.request.builder.action.ActionBuilder

class ActionBuilderSuite extends FunSuite {

  test("ActionRequestBuilder appends correct suffix") {

    val builder = new RequestBuilder("URL") with ActionBuilder

    val newUrl = builder.withAction(updateBoard, ActionBuilder.addMemberToCard)

    assert(newUrl.toString === "URL&action=updateBoard,addMemberToCard")
  }
}
