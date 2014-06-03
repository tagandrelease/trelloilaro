//package pl.pej.trelloilaro.api.request
//
//import org.scalatest.FunSuite
//import pl.pej.trelloilaro.api.request.builder.action.{Fields, Actions}
//
//class ActionSuite extends FunSuite {
//
//  val builder = ActionRequestBuilder("URL", Map())
//  test("ActionBuilder") {
//
//    val newUrl = builder.actions(Actions.updateBoard ).actions(Actions.addMemberToCard)
//
//    assert(newUrl.toString === "URL&action=addMemberToCard,updateBoard")
//  }
//
//  test("ActionFields") {
//    val newUrl = builder.fields(Fields.data, Fields.date)
//
//    assert(newUrl.toString === "URL&action_fields=data,date")
//  }
//
//  test("ActionEntities") {
//    val newUrl = builder.withEntities(true)
//
//    assert(newUrl.toString === "URL&entities=true")
//  }
//
//}
