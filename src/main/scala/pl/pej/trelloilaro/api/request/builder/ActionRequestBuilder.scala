package pl.pej.trelloilaro.api.request.builder

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ActionRequestBuilder { this: RequestBuilder =>

  def withAction(actions: ActionParam*) = RequestBuilder(url, "action", actions)

}

trait ActionParam extends RequestParam

object ActionRequestBuilder {
  case object all extends ActionParam with AllRequestParam
  case object addAttachmentToCard extends ActionParam
  case object addChecklistToCard extends ActionParam
  case object addMemberToBoard extends ActionParam
  case object addMemberToCard extends ActionParam
  case object addMemberToOrganization extends ActionParam
  case object addToOrganizationBoard extends ActionParam
  case object commentCard extends ActionParam
  case object copyCommentCard extends ActionParam
  case object convertToCardFromCheckItem extends ActionParam
  case object copyBoard extends ActionParam
  case object createBoard extends ActionParam
  case object createCard extends ActionParam
  case object copyCard extends ActionParam
  case object createList extends ActionParam
  case object createOrganization extends ActionParam
  case object deleteAttachmentFromCard extends ActionParam
  case object deleteBoardInvitation extends ActionParam
  case object deleteCard extends ActionParam
  case object deleteOrganizationInvitation extends ActionParam
  case object disablePowerUp extends ActionParam
  case object emailCard extends ActionParam
  case object enablePowerUp extends ActionParam
  case object makeAdminOfBoard extends ActionParam
  case object makeNormalMemberOfBoard extends ActionParam
  case object makeNormalMemberOfOrganization extends ActionParam
  case object makeObserverOfBoard extends ActionParam
  case object memberJoinedTrello extends ActionParam
  case object moveCardFromBoard extends ActionParam
  case object moveListFromBoard extends ActionParam
  case object moveCardToBoard extends ActionParam
  case object moveListToBoard extends ActionParam
  case object removeAdminFromBoard extends ActionParam
  case object removeAdminFromOrganization extends ActionParam
  case object removeChecklistFromCard extends ActionParam
  case object removeFromOrganizationBoard extends ActionParam
  case object removeMemberFromCard extends ActionParam
  case object unconfirmedBoardInvitation extends ActionParam
  case object unconfirmedOrganizationInvitation extends ActionParam
  case object updateBoard extends ActionParam
  case object updateCard extends ActionParam
  case object updateCheckItemStateOnCard extends ActionParam
  case object updateChecklist extends ActionParam
  case object updateList extends ActionParam
  case object updateMember extends ActionParam
  case object updateOrganization extends ActionParam
  case object updateCardIdList extends ActionParam { override def toString = "updateCard:idList"}
  case object updateCardClosed extends ActionParam { override def toString = "updateCard:closed"}
  case object updateCardDesc extends ActionParam { override def toString = "updateCard:desc"}
  case object updateCardName extends ActionParam { override def toString = "updateCard:name"}
  case object updateListClosed extends ActionParam { override def toString = "updateList:closed"}
  case object updateListName extends ActionParam { override def toString = "updateList:name"}
}