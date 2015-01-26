package pl.pej.trelloilaro.api.requestBuilder.board

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.requestBuilder.GetBoardChecklists
import pl.pej.trelloilaro.api.requestBuilder.builder.card.{Card, CardField}
import pl.pej.trelloilaro.api.requestBuilder.builder.checklist.{ChecklistField, Checklists, CheckItemField, CheckItems}

class GetBoardChecklistsSuite extends FunSuite {


  val boardId = "<<id>>"
  val emptyBuilder = GetBoardChecklists(boardId)


  test("/boards/[board_id]/checklists") {
    val builder = emptyBuilder

    assert(builder.toString === s"/boards/$boardId/checklists?")
  }
//  GET /1/boards/[board_id]/checklists
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

  test("/boards/[board_id]/checklists cards") {
    val builder = emptyBuilder.withCards(Card.open)

    assert(builder.toString === s"/boards/$boardId/checklists?cards=open")
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

  test("/boards/[board_id]/checklists card fields") {
    val builder = emptyBuilder.withCardFields(CardField.badges,
      CardField.descData, CardField.idMembers)

    assert(builder.toString === s"/boards/$boardId/checklists?card_fields=badges,descData,idMembers")
  }
//  checkItems (optional)
//  Default: all
//  Valid Values: One of:
//  all
//  none

  test("/boards/[board_id]/checklists checkItems") {
    val builder = emptyBuilder.withCheckItems(CheckItems.all).withCheckItems(CheckItems.all)

    assert(builder.toString === s"/boards/$boardId/checklists?checkItems=all")
  }
//  checkItem_fields (optional)
//  Default: name,nameData,pos,state
//  Valid Values: all or a comma-separated list of:
//  name
//  nameData
//  pos
//  state
//  type

  test("/boards/[board_id]/checklists checkItem_fields") {
    val builder = emptyBuilder.withCheckItemFields(CheckItemField.name,CheckItemField.nameData)

    assert(builder.toString === s"/boards/$boardId/checklists?checkItem_fields=name,nameData")
  }
//  filter (optional)
//  Default: all
//  Valid Values: One of:
//  all
//  none

  test("/boards/[board_id]/checklists filter") {
    val builder = emptyBuilder.withChecklists(Checklists.none)

    assert(builder.toString === s"/boards/$boardId/checklists?filter=none")
  }
//  fields (optional)
//  Default: all
//  Valid Values: all or a comma-separated list of:
//  idBoard
//  idCard
//  name
//  pos

  test("/boards/[board_id]/checklists fields") {
    val builder = emptyBuilder.withChecklistFields(ChecklistField.idBoard, ChecklistField.pos)

    assert(builder.toString === s"/boards/$boardId/checklists?fields=idBoard,pos")
  }


}
