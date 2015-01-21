package pl.pej.trelloilaro.api.requestBuilder.board

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.requestBuilder.builder.action.{Before, Since, Actions}
import pl.pej.trelloilaro.api.requestBuilder.builder.board.Checklists
import pl.pej.trelloilaro.api.requestBuilder.builder.card.{CardField, Card, CardAttachmentField}
import pl.pej.trelloilaro.api.requestBuilder.GetBoardCards
import pl.pej.trelloilaro.api.requestBuilder.builder.member.MemberField

class GetBoardCardsSuite extends FunSuite {


  val boardId = "<<id>>"
  val emptyBuilder = GetBoardCards(boardId)

  //  GET /1/boards/[board_id]/cards
  //
  test("/boards/[board_id]/cards empty") {
    assert(emptyBuilder.toString === s"/boards/$boardId/cards?")
  }

  //  Required permissions: read
//  Arguments
//  actions (optional)
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

  test("/boards/[board_id]/cards actions") {
    import Actions._
    val actions = List(addAttachmentToCard, addChecklistToCard,copyBoard,deleteCard,
    moveCardFromBoard,updateBoard)
    val builder = emptyBuilder.withActions(actions:_*)

    assert(builder.toString === s"/boards/$boardId/cards?actions=${actions.mkString(",")}")
  }

  //  attachments (optional)
//  Default: false
//  Valid Values: A boolean value or &quot;cover&quot; for only card cover attachments

  test("/boards/[board_id]/cards attachments") {
    val builder = emptyBuilder.withCardAttachmentsCoverOnly.withCardAttachments(true)

    assert(builder.toString === s"/boards/$boardId/cards?attachments=true")
  }

  //    attachment_fields (optional)

//  Default: all
//  Valid Values: all or a comma-separated list of:
//  bytes
//  date
//  edgeColor
//  idMember
//  isUpload
//  mimeType
//  name
//  previews
//  url

  test("/boards/[board_id]/cards attachment_fields") {
    import CardAttachmentField._
    val fields = List(bytes, date, edgeColor,idMember, isUpload, mimeType, name, previews)
    val builder = emptyBuilder.withCardAttachmentFields(fields:_*)

    assert(builder.toString === s"/boards/$boardId/cards?attachment_fields=${fields.mkString(",")}")
  }

//  stickers (optional)
//  Default: false
//  Valid Values:
//  true
//  false
  test("/boards/[board_id]/cards stickers") {
    val builder = emptyBuilder.withCardStickers(false)

    assert(builder.toString === s"/boards/$boardId/cards?stickers=false")
  }

  //  members (optional)
//  Default: false
//  Valid Values:
//  true
//  false

  test("/boards/[board_id]/cards members") {
    val builder = emptyBuilder.withMemberOrNot(false).withMemberOrNot(false)

    assert(builder.toString === s"/boards/$boardId/cards?members=false")
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
//  checkItemStates (optional)
//  Default: false
//  Valid Values:
//  true
//  false

  test("/boards/[board_id]/cards member_fields") {
    val builder = emptyBuilder.withMemberFields(MemberField.bio,MemberField.bioData,MemberField.fullName)

    assert(builder.toString === s"/boards/$boardId/cards?member_fields=bio,bioData,fullName")
  }

  //  checklists (optional)
//  Default: none
//  Valid Values: One of:
//  all
//  none

  test("/boards/[board_id]/cards checklists") {
    val builder = emptyBuilder.withChecklists(Checklists.all)

    assert(builder.toString === s"/boards/$boardId/cards?checklists=all")
  }

  //  limit (optional)
//  Valid Values: a number from 1 to 1000

  test("/boards/[board_id]/cards limit") {
    val builder = emptyBuilder.withLimit(123)

    assert(builder.toString === s"/boards/$boardId/cards?limit=123")
  }

//  since (optional)
//  Valid Values: A date, or null

  test("/boards/[board_id]/cards since") {
    val builder = emptyBuilder.since(Since.SinceDate("2000-02-02"))

    assert(builder.toString === s"/boards/$boardId/cards?since=2000-02-02")
  }

  //  before (optional)
//  Valid Values: A date, or null

  test("/boards/[board_id]/cards before") {
    val builder = emptyBuilder.before(Before.`null`)

    assert(builder.toString === s"/boards/$boardId/cards?before=null")
  }

  //  filter (optional)
//  Default: visible
//  Valid Values: One of:
//  all
//  closed
//  none
//  open
//  visible

  test("/boards/[board_id]/cards filter") {
    val builder = emptyBuilder.withCards(Card.open)

    assert(builder.toString === s"/boards/$boardId/cards?filter=open")
  }

  //  fields (optional)
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


  test("/boards/[board_id]/cards fields") {
    import CardField._
    val fields = List(badges,checkItemStates,closed,due,idBoard,idMembers,idShort)
    val builder = emptyBuilder.withCardFields(fields:_*)

    assert(builder.toString === s"/boards/$boardId/cards?fields=${fields.mkString(",")}")
  }


}
