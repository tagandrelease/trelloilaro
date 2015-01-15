package pl.pej.trelloilaro.api.requestBuilder.board

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.requestBuilder.PutBoard
import pl.pej.trelloilaro.api.requestBuilder.builder.action.ActionFormat.list
import pl.pej.trelloilaro.api.requestBuilder.builder.action.ActionSince.ActionSinceDate
import pl.pej.trelloilaro.api.requestBuilder.builder.action.{ActionField, Actions}
import pl.pej.trelloilaro.api.requestBuilder.builder.board.{BoardField, ChecklistField, Checklists}
import pl.pej.trelloilaro.api.requestBuilder.builder.card.{Card, CardAttachmentField, CardField}
import pl.pej.trelloilaro.api.requestBuilder.builder.common.{ValueTooShortException, ValueTooLongException}
import pl.pej.trelloilaro.api.requestBuilder.builder.list.Lists
import pl.pej.trelloilaro.api.requestBuilder.builder.member.{MemberField, Members}
import pl.pej.trelloilaro.api.requestBuilder.builder.membership.Memberships
import pl.pej.trelloilaro.api.requestBuilder.builder.organization.OrganizationField

class PutBoardSuite extends FunSuite {

  val boardId = "<<id>>"

  val emptyBuilder = PutBoard(boardId)

  val date = "2011-11-11"

  test("PUT /boards/[board_id] empty") {
    assert(emptyBuilder.toString === s"/boards/$boardId?")
  }

  test("PUT /boards/[board_id] with name (length 1-16384)") {
    val builder = emptyBuilder.withName("jes 2015")
    assert(builder.toString === s"/boards/$boardId?name=jes+2015")

    intercept[ValueTooLongException] {
      emptyBuilder.withName("x"*16385)
    }
    intercept[ValueTooShortException] {
      emptyBuilder.withName("")
    }
  }

  test("PUT /boards/[board_id] with desc (length 0-16384)") {
    val builder = emptyBuilder.withDesc("interesting thing")

    assert(builder.toString === s"/boards/$boardId?desc=interesting+thing")

    intercept[ValueTooLongException] {
      emptyBuilder.withName("x"*16385)
    }
  }

  test("PUT /boards/[board_id] with closed") {
    val builder = emptyBuilder.withBoardClosed(true).withBoardClosed(false)
      assert(builder.toString === s"/boards/$boardId?closed=false")
  }

  test("PUT /boards/[board_id] with subscribed") {
    val builder = emptyBuilder.withBoardSubscribed(true).withBoardSubscribed(false)
      assert(builder.toString === s"/boards/$boardId?subscribed=false")
  }

  test("PUT /boards/[board_id] with idOrganization") {
    val builder = emptyBuilder.withIdOrganization("i d")
      assert(builder.toString === s"/boards/$boardId?idOrganization=i+d")

    intercept[ValueTooLongException] {
      emptyBuilder.withIdOrganization("x"*16385)
    }
  }


//  prefs/permissionLevel (optional)
//  Valid Values: One of:
//  org
//  private
//  public
//  prefs/selfJoin (optional)
//  Valid Values:
//  true
//  false
//  prefs/cardCovers (optional)
//  Valid Values:
//  true
//  false
//  prefs/invitations (optional)
//  Valid Values: One of:
//  admins
//  members
//  prefs/voting (optional)
//  Valid Values: One of:
//  disabled
//  members
//  observers
//  org
//  public
//  prefs/comments (optional)
//  Valid Values: One of:
//  disabled
//  members
//  observers
//  org
//  public
//  prefs/background (optional)
//  Valid Values: A standard background name, or the id of a custom background
//  prefs/cardAging (optional)
//  Valid Values: One of:
//  pirate
//  regular
//  prefs/calendarFeedEnabled (optional)
//  Valid Values:
//  true
//  false
//  labelNames/green (optional)
//  Valid Values: a string with a length from 0 to 16384
//  labelNames/yellow (optional)
//  Valid Values: a string with a length from 0 to 16384
//  labelNames/orange (optional)
//  Valid Values: a string with a length from 0 to 16384
//  labelNames/red (optional)
//  Valid Values: a string with a length from 0 to 16384
//  labelNames/purple (optional)
//  Valid Values: a string with a length from 0 to 16384
//  labelNames/blue (optional)
//  Valid Values: a string with a length from 0 to 16384


}
