package pl.pej.trelloilaro.api.request

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.request.builder.action.Actions
import pl.pej.trelloilaro.api.request.builder.action.ActionFormat.list
import pl.pej.trelloilaro.api.request.builder.action.ActionSince.ActionSinceDate

class GetBoardSuite extends FunSuite {

  val boardId = "<<id>>"

  val emptyBuilder = GetBoard(boardId)

  val date = "2011-11-11"

  test("/boards/[board_id] empty") {
    assert(emptyBuilder.toString === s"/1/boards/$boardId?")
  }

  test("/boards/[board_id] with token and key") {
    val builder = emptyBuilder.withToken("1234").withKey("5678")
    assert(builder.toString === s"/1/boards/$boardId?key=5678&token=1234")
  }

  test("/boards/[board_id] with some actions") {
    val builder = emptyBuilder.actions(Actions.addAttachmentToCard, Actions.addChecklistToCard).actions(Actions.addAttachmentToCard)
    assert(builder.toString === s"/1/boards/$boardId?actions=addAttachmentToCard,addChecklistToCard")
  }

  test("/boards/[board_id] with token, key and some actions") {
    val builder = emptyBuilder.withToken("1234").withKey("5678").actions(Actions.addAttachmentToCard, Actions.addChecklistToCard).actions(Actions.addAttachmentToCard)
    assert(builder.toString === s"/1/boards/$boardId?actions=addAttachmentToCard,addChecklistToCard&key=5678&token=1234")
  }

  test("/boards/[board_id] with action entities") {
    val builder = emptyBuilder.withEntities(true)
    assert(builder.toString === s"/1/boards/$boardId?actions_entities=true")
  }
  test("/boards/[board_id] with action format") {
    val builder = emptyBuilder.withActionFormat(list)
    assert(builder.toString === s"/1/boards/$boardId?actions_format=list")
  }

  test("/boards/[board_id] with since") {
    val builder = emptyBuilder.withActionsSince(ActionSinceDate(date))
    assert(builder.toString === s"/1/boards/$boardId?actions_since=$date")
  }


//  test("/boards/[board_id] with ") {
//    val builder = emptyBuilder.
//    assert(builder.toString === s"/1/boards/$boardId?")
//  }

}
