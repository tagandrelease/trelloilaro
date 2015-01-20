package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait ActionBuilder[T] { this: RequestBuilder[T] =>

  protected def actionsParamName: String = "actions"
  def withActions(actions: Actions*): T = withParams(actionsParamName, actions)
}


trait Actions extends RequestParam

object Actions {
  case object all extends Actions with AllRequestParam
  case object addAttachmentToCard extends Actions
  case object addChecklistToCard extends Actions
  case object addMemberToBoard extends Actions
  case object addMemberToCard extends Actions
  case object addMemberToOrganization extends Actions
  case object addToOrganizationBoard extends Actions
  case object commentCard extends Actions
  case object copyCommentCard extends Actions
  case object convertToCardFromCheckItem extends Actions
  case object copyBoard extends Actions
  case object createBoard extends Actions
  case object createCard extends Actions
  case object copyCard extends Actions
  case object createList extends Actions
  case object createOrganization extends Actions
  case object deleteAttachmentFromCard extends Actions
  case object deleteBoardInvitation extends Actions
  case object deleteCard extends Actions
  case object deleteOrganizationInvitation extends Actions
  case object disablePowerUp extends Actions
  case object emailCard extends Actions
  case object enablePowerUp extends Actions
  case object makeAdminOfBoard extends Actions
  case object makeNormalMemberOfBoard extends Actions
  case object makeNormalMemberOfOrganization extends Actions
  case object makeObserverOfBoard extends Actions
  case object memberJoinedTrello extends Actions
  case object moveCardFromBoard extends Actions
  case object moveListFromBoard extends Actions
  case object moveCardToBoard extends Actions
  case object moveListToBoard extends Actions
  case object removeAdminFromBoard extends Actions
  case object removeAdminFromOrganization extends Actions
  case object removeChecklistFromCard extends Actions
  case object removeFromOrganizationBoard extends Actions
  case object removeMemberFromCard extends Actions
  case object unconfirmedBoardInvitation extends Actions
  case object unconfirmedOrganizationInvitation extends Actions
  case object updateBoard extends Actions
  case object updateCard extends Actions
  case object updateCheckItemStateOnCard extends Actions
  case object updateChecklist extends Actions
  case object updateList extends Actions
  case object updateMember extends Actions
  case object updateOrganization extends Actions
  case object updateCardIdList extends Actions { override def toString = "updateCard:idList"}
  case object updateCardClosed extends Actions { override def toString = "updateCard:closed"}
  case object updateCardDesc extends Actions { override def toString = "updateCard:desc"}
  case object updateCardName extends Actions { override def toString = "updateCard:name"}
  case object updateListClosed extends Actions { override def toString = "updateList:closed"}
  case object updateListName extends Actions { override def toString = "updateList:name"}
}