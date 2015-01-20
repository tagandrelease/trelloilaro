package pl.pej.trelloilaro.api.requestBuilder.board

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.requestBuilder.GetBoardActions
import pl.pej.trelloilaro.api.requestBuilder.builder.action._
import pl.pej.trelloilaro.api.requestBuilder.builder.member.MemberField

class GetBoardActionsSuite extends FunSuite {


  val boardId = "<<id>>"
  val emptyBuilder = GetBoardActions(boardId)

  val date = "2011-11-11"

  test("/boards/[board_id]/actions empty") {
    assert(emptyBuilder.toString === s"/boards/$boardId/actions?")
  }


  //  Arguments
//
//  entities (optional)
//  Default: false
//  Valid Values:
//  true
//  false

  test("/boards/[board_id]/actions with entities") {
    val builder = emptyBuilder.withEntities(true).withEntities(false)

      assert(builder.toString === s"/boards/$boardId/actions?entities=false")
  }
//  filter (optional)
//  Default: all
//  Valid Values: all or a comma-separated list of:
//  addAttachmentToCard
//  addChecklistToCard
//  addMemberToBoard
//  addMemberToCard
//  addMemberToOrganization
//  addToOrganizationBoard
//  commentCard
//  convertToCardFromCheckItem
//  copyBoard
//  copyCard
//  copyCommentCard
//  createBoard
//  createCard
//  createList
//  createOrganization
//  deleteAttachmentFromCard
//  deleteBoardInvitation
//  deleteCard
//  deleteOrganizationInvitation
//  disablePowerUp
//  emailCard
//  enablePowerUp
//  makeAdminOfBoard
//  makeNormalMemberOfBoard
//  makeNormalMemberOfOrganization
//  makeObserverOfBoard
//  memberJoinedTrello
//  moveCardFromBoard
//  moveCardToBoard
//  moveListFromBoard
//  moveListToBoard
//  removeChecklistFromCard
//  removeFromOrganizationBoard
//  removeMemberFromCard
//  unconfirmedBoardInvitation
//  unconfirmedOrganizationInvitation
//  updateBoard
//  updateCard
//  updateCard:closed
//  updateCard:desc
//  updateCard:idList
//  updateCard:name
//  updateCheckItemStateOnCard
//  updateChecklist
//  updateList
//  updateList:closed
//  updateList:name
//  updateMember
//  updateOrganization

  test("/boards/[board_id]/actions with filter") {

    import Actions._
    val builder = emptyBuilder.withActions(copyBoard,copyCard,copyCommentCard,createBoard,createCard,createList)

      assert(builder.toString === s"/boards/$boardId/actions?filter=copyBoard,copyCard,copyCommentCard,createBoard,createCard,createList")
  }
//  fields (optional)
//  Default: all
//  Valid Values: all or a comma-separated list of:
//  data
//  date
//  idMemberCreator
//  type

  test("/boards/[board_id]/actions with fields") {
    val builder = emptyBuilder.withActionFields(ActionField.data, ActionField.idMemberCreator)

      assert(builder.toString === s"/boards/$boardId/actions?fields=data,idMemberCreator")
  }
//  limit (optional)
//  Default: 50
//  Valid Values: a number from 0 to 1000

  test("/boards/[board_id]/actions with limit") {
    val builder = emptyBuilder.withActionsLimit(555)

      assert(builder.toString === s"/boards/$boardId/actions?limit=555")
  }
//  format (optional)
//  Default: list
//  Valid Values: One of:
//  count
//  list
//  minimal

  test("/boards/[board_id]/actions with format") {
    val builder = emptyBuilder.withActionFormat(ActionFormat.count).withActionFormat(ActionFormat.list)

      assert(builder.toString === s"/boards/$boardId/actions?format=list")
  }
//  since (optional)
//  Valid Values: A date, null or lastView

  test("/boards/[board_id]/actions with since") {
    val builder = emptyBuilder.withActionsSince(ActionsSince.lastView)

      assert(builder.toString === s"/boards/$boardId/actions?since=lastView")
  }
//  before (optional)
//  Valid Values: A date, or null

  test("/boards/[board_id]/actions with before") {
    val builder = emptyBuilder.withActionsBefore(ActionsBefore.ActionBeforeDate("2000-01-01"))

      assert(builder.toString === s"/boards/$boardId/actions?before=2000-01-01")
  }
//  page (optional)
//  Default: 0
//  Valid Values: Page * limit must be less than 1000

  test("/boards/[board_id]/actions with page") {
    val builder = emptyBuilder.withPage(123)

      assert(builder.toString === s"/boards/$boardId/actions?page=123")
  }
//  idModels (optional)
//  Valid Values: Only return actions related to these model ids

  test("/boards/[board_id]/actions with idModels") {
    val builder = emptyBuilder.withActionIdModels(ActionIdModels.Id("ASDF"))

      assert(builder.toString === s"/boards/$boardId/actions?idModels=ASDF")
  }
//    member (optional)
//  Default: true
//  Valid Values:
//  true
//  false

  test("/boards/[board_id]/actions with member") {
    val builder = emptyBuilder.withActionMember(true).withActionMember(true)

      assert(builder.toString === s"/boards/$boardId/actions?member=true")
  }
//  member_fields (optional)
//  Default: avatarHash,fullName,initials,username
//  Valid Values: all or a comma-separated list of:
//  avatarHash
//  bio
//  bioData
//  confirmed
//  fullName
//  idPremOrgsAdmin
//  initials
//  memberType
//  products
//  status
//  url
//  username

  test("/boards/[board_id]/actions with member_fields") {
    import MemberField._
    val builder = emptyBuilder.withActionMemberFields(bio, bioData)

    assert(builder.toString === s"/boards/$boardId/actions?member_fields=bio,bioData")
  }
//  memberCreator (optional)
//  Default: true
//  Valid Values:
//  true
//  false

  test("/boards/[board_id]/actions with memberCreator ") {
    val builder = emptyBuilder.withActionMemberCreator(false).withActionMemberCreator(true)

    assert(builder.toString === s"/boards/$boardId/actions?memberCreator=true")
  }
//  memberCreator_fields (optional)
//  Default: avatarHash,fullName,initials,username
//  Valid Values: all or a comma-separated list of:
//  avatarHash
//  bio
//  bioData
//  confirmed
//  fullName
//  idPremOrgsAdmin
//  initials
//  memberType
//  products
//  status
//  url
//  username

  test("/boards/[board_id]/actions with memberCreator_fields") {
    val builder = emptyBuilder.withActionMemberCreatorFields(MemberField.bio, MemberField.initials)

      assert(builder.toString === s"/boards/$boardId/actions?memberCreator_fields=bio,initials")
  }


}
