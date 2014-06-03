package pl.pej.trelloilaro.api.request

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.request.builder.action.{ActionField, Actions}
import pl.pej.trelloilaro.api.request.builder.action.ActionFormat.list
import pl.pej.trelloilaro.api.request.builder.action.ActionSince.ActionSinceDate
import pl.pej.trelloilaro.api.request.builder.member.{Members, MemberField}
import pl.pej.trelloilaro.api.request.builder.card.{CardAttachmentField, CardField, Card}
import pl.pej.trelloilaro.api.request.builder.board.{BoardField, ChecklistField, Checklists}
import pl.pej.trelloilaro.api.request.builder.list.Lists
import pl.pej.trelloilaro.api.request.builder.membership.Memberships
import pl.pej.trelloilaro.api.request.builder.organization.OrganizationField

/** Writing this shit seems like too-shitty-to-be-done,
  * but in fact at least lets you turn off your brain
  * and enjoy the music, so it's worth it.
  */
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

  test("/boards/[board_id] with limit") {
    val builder = emptyBuilder.withActionsLimit(50)
    assert(builder.toString === s"/1/boards/$boardId?actions_limit=50")
  }

  test("/boards/[board_id] with action fields") {
    val builder = emptyBuilder.withActionFields(ActionField.date, ActionField.`type`)
    assert(builder.toString === s"/1/boards/$boardId?action_fields=date,type")
  }

  test("/boards/[board_id] with action member") {
    val builder = emptyBuilder.withActionMember(false).withActionMember(false)
    assert(builder.toString === s"/1/boards/$boardId?action_member=false")
  }
  test("/boards/[board_id] with action member fields") {
    import MemberField._
    val builder = emptyBuilder.withActionMemberFields(bio, bioData, confirmed, initials)
    assert(builder.toString === s"/1/boards/$boardId?action_member_fields=bio,bioData,confirmed,initials")
  }
  test("/boards/[board_id] with action member creator") {
    val builder = emptyBuilder.withActionMemberCreator(false)
    assert(builder.toString === s"/1/boards/$boardId?action_memberCreator=false")
  }
  test("/boards/[board_id] with action member creator fields") {
    val builder = emptyBuilder.withActionMemberCreatorFields(MemberField.status, MemberField.url)
    assert(builder.toString === s"/1/boards/$boardId?action_memberCreator_fields=status,url")
  }
  test("/boards/[board_id] with cards") {
    val builder = emptyBuilder.withCards(Card.closed).withCards(Card.open)
    assert(builder.toString === s"/1/boards/$boardId?cards=open")
  }
  test("/boards/[board_id] with card fields") {
    val builder = emptyBuilder.withCardFields(CardField.closed, CardField.due)
    assert(builder.toString === s"/1/boards/$boardId?card_fields=closed,due")
  }

  test("/boards/[board_id] with card attachments") {
    val builder = emptyBuilder.withCardAttachmentsCoverOnly.withCardAttachments(false)
    assert(builder.toString === s"/1/boards/$boardId?card_attachments=false")
  }
  test("/boards/[board_id] with card attachment fields") {
    val builder = emptyBuilder.withCardAttachmentFields(CardAttachmentField.edgeColor)
    assert(builder.toString === s"/1/boards/$boardId?card_attachment_fields=edgeColor")
  }
  test("/boards/[board_id] with card checklist") {
    val builder = emptyBuilder.withCardChecklists(Checklists.all)
    assert(builder.toString === s"/1/boards/$boardId?card_checklists=all")
  }
  test("/boards/[board_id] with card stickers") {
    val builder = emptyBuilder.withCardStickers(false)
    assert(builder.toString === s"/1/boards/$boardId?card_stickers=false")
  }

  test("/boards/[board_id] with board stars") {
    val builder = emptyBuilder.withBoardStars(false)
    assert(builder.toString === s"/1/boards/$boardId?board_stars=false")
  }
  test("/boards/[board_id] with lists") {
    val builder = emptyBuilder.withLists(Lists.open)
    assert(builder.toString === s"/1/boards/$boardId?lists=open")
  }
  test("/boards/[board_id] with memberships") {
    val builder = emptyBuilder.withMemberships(Memberships.normal)
    assert(builder.toString === s"/1/boards/$boardId?memberships=normal")
  }
  test("/boards/[board_id] with membership member") {
    val builder = emptyBuilder.withMembershipsMember(true)
    assert(builder.toString === s"/1/boards/$boardId?memberships_member=true")
  }
  test("/boards/[board_id] with membership member fields") {
    val builder = emptyBuilder.withMembershipsMemberFields(MemberField.fullName)
    assert(builder.toString === s"/1/boards/$boardId?memberships_member_fields=fullName")
  }
  test("/boards/[board_id] with members") {
    val builder = emptyBuilder.withMembers(Members.admins)
    assert(builder.toString === s"/1/boards/$boardId?members=admins")
  }
  test("/boards/[board_id] with member fields") {
    val builder = emptyBuilder.withMemberFields(MemberField.url)
    assert(builder.toString === s"/1/boards/$boardId?member_fields=url")
  }
  test("/boards/[board_id] with members invited") {
    val builder = emptyBuilder.withMembersInvited(Members.normal)
    assert(builder.toString === s"/1/boards/$boardId?membersInvited=normal")
  }
  test("/boards/[board_id] with members invited fields") {
    val builder = emptyBuilder.withMembersInvitedFields(MemberField.avatarHash)
    assert(builder.toString === s"/1/boards/$boardId?membersInvited_fields=avatarHash")
  }
  test("/boards/[board_id] with checklists") {
    val builder = emptyBuilder.withChecklists(Checklists.all)
    assert(builder.toString === s"/1/boards/$boardId?checklists=all")
  }
  test("/boards/[board_id] with checklist fields") {
    val builder = emptyBuilder.withChecklistFields(ChecklistField.idBoard)
    assert(builder.toString === s"/1/boards/$boardId?checklist_fields=idBoard")
  }
  test("/boards/[board_id] with organization") {
    val builder = emptyBuilder.withOrganization(false)
    assert(builder.toString === s"/1/boards/$boardId?organization=false")
  }
  test("/boards/[board_id] with organization fields") {
    val builder = emptyBuilder.withOrganizationFields(OrganizationField.name)
    assert(builder.toString === s"/1/boards/$boardId?organization_fields=name")
  }
  test("/boards/[board_id] with organization memberships") {
    val builder = emptyBuilder.withOrganizationMemberships(Memberships.me)
    assert(builder.toString === s"/1/boards/$boardId?organization_memberships=me")
  }

  test("/boards/[board_id] with my prefs") {
    val builder = emptyBuilder.withMyPrefs(false)
    assert(builder.toString === s"/1/boards/$boardId?myPrefs=false")
  }

  test("/boards/[board_id] with fields") {
    val builder = emptyBuilder.withFields(BoardField.dateLastActivity)
    assert(builder.toString === s"/1/boards/$boardId?fields=dateLastActivity")
  }

}
