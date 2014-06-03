package pl.pej.trelloilaro.api.request

import pl.pej.trelloilaro.api.request.builder.board._
import pl.pej.trelloilaro.api.request.builder.action._
import pl.pej.trelloilaro.api.request.builder.member._
import pl.pej.trelloilaro.api.request.builder.card._
import pl.pej.trelloilaro.api.request.builder.list.{ListsBuilder, ListFieldsBuilder}
import pl.pej.trelloilaro.api.request.builder.membership.{MembershipsMemberBuilder, MembershipsBuilder}


/** GET /1/boards/[board_id]
 */
case class GetBoard(
                     boardId: String,
                     params: Map[String, List[String]] = Map()
                   ) extends RequestBuilder[GetBoard](params)
with ActionBuilder[GetBoard] with ActionEntitiesBuilder[GetBoard] with ActionsLimitBuilder[GetBoard] with ActionFieldsBuilder[GetBoard]
with ActionFormatBuilder[GetBoard] with ActionSinceBuilder[GetBoard] with ActionMemberBuilder[GetBoard] with ActionMemberFieldsBuilder[GetBoard]
with ActionMemberCreatorFieldsBuilder[GetBoard] with ActionMemberCreatorBuilder[GetBoard] with CardsBuilder[GetBoard] with CardFieldsBuilder[GetBoard]
with CardAttachmentsBuilder[GetBoard] with CardAttachmentFieldsBuilder[GetBoard] with CardChecklistsBuilder[GetBoard] with CardStickersBuilder[GetBoard]
with BoardStarsBuilder[GetBoard] with ListFieldsBuilder[GetBoard] with ListsBuilder[GetBoard] with MembershipsBuilder[GetBoard] with MembershipsMemberBuilder[GetBoard]
with MembershipsMemberFieldsBuilder[GetBoard] with MembersBuilder[GetBoard] with MemberFieldsBuilder[GetBoard]
{
  def construct(params: Map[String,List[String]]) = GetBoard(boardId, params)

  override def prefix = s"/1/boards/$boardId"
}

//GET /1/boards/[board_id/[field]
//case class GetBoardField(boardId: String, fieldName: BoardsField, params: Map[String,List[String]]) extends RequestBuilder[GetBoardField](params) {
//  def construct(params: Map[String,List[String]]) = GetBoardField(boardId, fieldName, params)
//}
//
////GET /1/boards/[board_id]/actions
//case class GetBoardActions(boardId: String, params: Map[String,List[String]]) extends RequestBuilder[GetBoardField](params) {
//  def construct(params: Map[String,List[String]]) = GetBoardField(boardId, fieldName, params)
//}
//GET /1/boards/[board_id]/boardStars
//GET /1/boards/[board_id]/cards
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
