package pl.pej.trelloilaro.api.requestBuilder

import pl.pej.trelloilaro.api.requestBuilder.builder.board._
import pl.pej.trelloilaro.api.requestBuilder.builder.action._
import pl.pej.trelloilaro.api.requestBuilder.builder.common.{DescBuilder, NameBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.member._
import pl.pej.trelloilaro.api.requestBuilder.builder.card._
import pl.pej.trelloilaro.api.requestBuilder.builder.list.{ListsBuilder, ListFieldsBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.membership.{OrganizationMembershipsBuilder, MembershipsMemberBuilder, MembershipsBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.organization.{OrganizationFieldsBuilder, OrganizationBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.misc.MyPrefsBuilder


/** GET /1/boards/[board_id]
 */
case class GetBoard(
                     boardId: String,
                     params: Map[String, List[String]] = Map()
                   ) extends RequestBuilder[GetBoard](params)
with ActionBuilder[GetBoard] with ActionEntitiesBuilder[GetBoard] with LimitBuilder[GetBoard] with ActionFieldsBuilder[GetBoard]
with ActionFormatBuilder[GetBoard] with SinceBuilder[GetBoard] with BeforeBuilder[GetBoard] with MemberOrNotBuilder[GetBoard] with ActionMemberFieldsBuilder[GetBoard]
with ActionMemberCreatorFieldsBuilder[GetBoard] with ActionMemberCreatorBuilder[GetBoard] with CardsBuilder[GetBoard] with CardFieldsBuilder[GetBoard]
with CardAttachmentsBuilder[GetBoard] with CardAttachmentFieldsBuilder[GetBoard] with CardStickersBuilder[GetBoard]
with BoardStarsBuilder[GetBoard] with ListFieldsBuilder[GetBoard] with ListsBuilder[GetBoard] with MembershipsBuilder[GetBoard] with MembershipsMemberBuilder[GetBoard]
with MembershipsMemberFieldsBuilder[GetBoard] with MembersBuilder[GetBoard] with MemberFieldsBuilder[GetBoard] with MembersInvitedBuilder[GetBoard]
with MembersInvitedFieldsBuilder[GetBoard] with ChecklistsBuilder[GetBoard] with ChecklistFieldsBuilder[GetBoard]
with OrganizationBuilder[GetBoard] with OrganizationFieldsBuilder[GetBoard] with OrganizationMembershipsBuilder[GetBoard] with MyPrefsBuilder[GetBoard]
with BoardFieldsBuilder[GetBoard]
{
  def construct(params: Map[String,List[String]]) = GetBoard(boardId, params)

  override def prefix = s"/boards/$boardId"

  override def httpMethod: HttpMethod = GET

  /** "fields" or "board_fields" depending on method
    */
  override def boardFieldsParamName: String = "fields"

  override protected def memberOrNotParamName: String = "action_member"

  override protected def checklistsParamName: String = "checklists"

  override protected def limitParamName: String = "actions_limit"

  override protected def sinceParamName: String = "actions_since"

  override protected def beforeParamName: String = "actions_before"
}

/** PUT /1/boards/[board_id]
  */
case class PutBoard(boardId: String, params: Map[String, List[String]] = Map()) extends RequestBuilder[PutBoard](params) with
NameBuilder[PutBoard] with DescBuilder[PutBoard] with BoardClosedBuilder[PutBoard] with BoardSubscribedBuilder[PutBoard] with
OrganizationIdBuilder[PutBoard]
{
  def construct(params: Map[String,List[String]]) = PutBoard(boardId, params)

  override def prefix = s"/boards/$boardId"

  override def httpMethod: HttpMethod = PUT


}

//GET /1/boards/[board_id/[field]
//case class GetBoardField(boardId: String, fieldName: BoardsField, params: Map[String,List[String]]) extends RequestBuilder[GetBoardField](params) {
//  def construct(params: Map[String,List[String]]) = GetBoardField(boardId, fieldName, params)
//}
//
////
/** GET /1/boards/[board_id]/actions
  */
case class GetBoardActions(
                     boardId: String,
                     params: Map[String, List[String]] = Map()
                     ) extends RequestBuilder[GetBoardActions](params)
with ActionBuilder[GetBoardActions] with EntitiesBuilder[GetBoardActions]
with LimitBuilder[GetBoardActions] with ActionFieldsBuilder[GetBoardActions]
with ActionFormatBuilder[GetBoardActions] with SinceBuilder[GetBoardActions]
with BeforeBuilder[GetBoardActions] with ActionPageBuilder[GetBoardActions]
with ActionIdModelsBuilder[GetBoardActions]
with MemberOrNotBuilder[GetBoardActions] with ActionMemberFieldsBuilder[GetBoardActions]
with ActionMemberCreatorFieldsBuilder[GetBoardActions] with ActionMemberCreatorBuilder[GetBoardActions]
{
  def construct(params: Map[String,List[String]]) = GetBoardActions(boardId, params)

  override def prefix = s"/boards/$boardId/actions"

  override def httpMethod: HttpMethod = GET

  override protected def actionsParamName: String = "filter"

  override protected def actionFieldsParamName: String = "fields"

  override protected def actionFormatParamName: String = "format"

  override protected def beforeParamName: String = "before"

  override protected def memberOrNotParamName: String = "member"

  override protected def actionMemberFieldsParamName: String = "member_fields"

  override protected def actionMemberCreatorParamName: String = "memberCreator"

  override protected def actionMemberCreatorFieldsParamName: String = "memberCreator_fields"
}


//GET /1/boards/[board_id]/boardStars
//GET /1/boards/[board_id]/cards
case class GetBoardCards(
                     boardId: String,
                     params: Map[String, List[String]] = Map()
                     ) extends RequestBuilder[GetBoardCards](params)
with ActionBuilder[GetBoardCards]
with CardsBuilder[GetBoardCards] with CardFieldsBuilder[GetBoardCards]
with CardAttachmentsBuilder[GetBoardCards] with CardAttachmentFieldsBuilder[GetBoardCards]
with ChecklistsBuilder[GetBoardCards] with CardStickersBuilder[GetBoardCards]
with MemberOrNotBuilder[GetBoardCards] with MemberFieldsBuilder[GetBoardCards]
with LimitBuilder[GetBoardCards] with SinceBuilder[GetBoardCards]
with BeforeBuilder[GetBoardCards]
{
  def construct(params: Map[String,List[String]]) = GetBoardCards(boardId, params)

  override def prefix = s"/boards/$boardId/cards"

  override def httpMethod: HttpMethod = GET

  override def attachmentsParamName: String = "attachments"

  override def attachmentFieldsParamName: String = "attachment_fields"

  override def stickersParamName: String = "stickers"

  override protected def cardsParamName: String = "filter"

  override protected def cardFieldsParamName: String = "fields"
}

//GET /1/boards/[board_id]/cards/[filter]
//GET /1/boards/[board_id]/cards/[idCard]

//GET /1/boards/[board_id]/checklists
//GET /1/boards/[board_id]/deltas
//GET /1/boards/[board_id]/lists
//GET /1/boards/[board_id]/lists/[filter]
//GET /1/boards/[board_id]/members
//GET /1/boards/[board_id]/members/[filter]
//GET /1/boards/[board_id]/members/[idMember]/cards
//GET /1/boards/[board_id]/membersInvited
//GET /1/boards/[board_id]/membersInvited/[field]
//GET /1/boards/[board_id]/memberships
//GET /1/boards/[board_id]/memberships/[idMembership]
//GET /1/boards/[board_id]/myPrefs
//GET /1/boards/[board_id]/organization
//GET /1/boards/[board_id]/organization/[field]
//PUT /1/boards/[board_id]
//PUT /1/boards/[board_id]/closed
//PUT /1/boards/[board_id]/desc
//PUT /1/boards/[board_id]/idOrganization
//PUT /1/boards/[board_id]/labelNames/blue
//PUT /1/boards/[board_id]/labelNames/green
//PUT /1/boards/[board_id]/labelNames/orange
//PUT /1/boards/[board_id]/labelNames/purple
//PUT /1/boards/[board_id]/labelNames/red
//PUT /1/boards/[board_id]/labelNames/yellow
//PUT /1/boards/[board_id]/members
//PUT /1/boards/[board_id]/members/[idMember]
//PUT /1/boards/[board_id]/memberships/[idMembership]
//PUT /1/boards/[board_id]/myPrefs/emailPosition
//PUT /1/boards/[board_id]/myPrefs/idEmailList
//PUT /1/boards/[board_id]/myPrefs/showListGuide
//PUT /1/boards/[board_id]/myPrefs/showSidebar
//PUT /1/boards/[board_id]/myPrefs/showSidebarActivity
//PUT /1/boards/[board_id]/myPrefs/showSidebarBoardActions
//PUT /1/boards/[board_id]/myPrefs/showSidebarMembers
//PUT /1/boards/[board_id]/name
//PUT /1/boards/[board_id]/prefs/background
//PUT /1/boards/[board_id]/prefs/calendarFeedEnabled
//PUT /1/boards/[board_id]/prefs/cardAging
//PUT /1/boards/[board_id]/prefs/cardCovers
//PUT /1/boards/[board_id]/prefs/comments
//PUT /1/boards/[board_id]/prefs/invitations
//PUT /1/boards/[board_id]/prefs/permissionLevel
//PUT /1/boards/[board_id]/prefs/selfJoin
//PUT /1/boards/[board_id]/prefs/voting
//PUT /1/boards/[board_id]/subscribed
//POST /1/boards
//POST /1/boards/[board_id]/calendarKey/generate
//POST /1/boards/[board_id]/checklists
//POST /1/boards/[board_id]/emailKey/generate
//POST /1/boards/[board_id]/lists
//POST /1/boards/[board_id]/markAsViewed
//POST /1/boards/[board_id]/powerUps
//DELETE /1/boards/[board_id]/members/[idMember]
//DELETE /1/boards/[board_id]/powerUps/[powerUp]
