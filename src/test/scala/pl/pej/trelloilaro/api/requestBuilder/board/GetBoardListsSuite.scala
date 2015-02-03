package pl.pej.trelloilaro.api.requestBuilder.board

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.requestBuilder.GetBoardLists
import pl.pej.trelloilaro.api.requestBuilder.builder.card.{CardField, Card}
import pl.pej.trelloilaro.api.requestBuilder.builder.list.{ListField, Lists}

class GetBoardListsSuite extends FunSuite {

  val boardId = "<<id>>"
  val emptyBuilder = GetBoardLists(boardId)


  test("/boards/[board_id]/lists") {
    val builder = emptyBuilder

    assert(builder.toString === s"/boards/$boardId/lists?")
  }


//  GET /1/boards/[board_id]/lists
//
//  Required permissions: read
//  Arguments
//  cards (optional)
//  Default: none
//  Valid Values: One of:
//  all
//  closed
//  none
//  open
//  visible

  test("/boards/[board_id]/lists cards") {
    val builder = emptyBuilder.withCards(Card.open)

    assert(builder.toString === s"/boards/$boardId/lists?cards=open")
  }

  //  card_fields (optional)
//  Default: all
//  Valid Values: all or a comma-separated list of:
//  badges
//  checkItemStates
//  closed
//  dateLastActivity
//  desc
//  descData
//  due
//  email
//  idAttachmentCover
//  idBoard
//  idChecklists
//  idLabels
//  idList
//  idMembers
//  idMembersVoted
//  idShort
//  labels
//  manualCoverAttachment
//  name
//  pos
//  shortLink
//  shortUrl
//  subscribed
//  url

  test("/boards/[board_id]/lists card_fields") {
    val builder = emptyBuilder.withCardFields(CardField.badges,CardField.desc)

    assert(builder.toString === s"/boards/$boardId/lists?card_fields=badges,desc")
  }

  //  filter (optional)
//  Default: open
//  Valid Values: One of:
//  all
//  closed
//  none
//  open

  test("/boards/[board_id]/lists filter") {
    val builder = emptyBuilder.withLists(Lists.closed)

    assert(builder.toString === s"/boards/$boardId/lists?filter=closed")
  }

  //  fields (optional)
//  Default: all
//  Valid Values: all or a comma-separated list of:
//  closed
//  idBoard
//  name
//  pos
//  subscribed
//

  test("/boards/[board_id]/lists fields") {
    val builder = emptyBuilder.withListFields(ListField.idBoard)

    assert(builder.toString === s"/boards/$boardId/lists?fields=idBoard")
  }

}
