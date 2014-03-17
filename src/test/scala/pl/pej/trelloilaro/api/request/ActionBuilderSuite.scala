package pl.pej.trelloilaro.api.request

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.request.builder.ActionRequestBuilder
import pl.pej.trelloilaro.api.request.builder.ActionRequestBuilder.updateBoard

class ActionBuilderSuite extends FunSuite {

  test("ActionRequestBuilder appends correct suffix") {

    val builder = new RequestBuilder("URL") with ActionRequestBuilder

    val newUrl = builder.withAction(updateBoard, ActionRequestBuilder.addMemberToCard)

    assert(newUrl.toString === "URL&action=updateBoard,addMemberToCard")
  }
}
