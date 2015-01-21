package pl.pej.trelloilaro.api.requestBuilder.builder.card

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait CardFieldsBuilder[T] { this: RequestBuilder[T] =>

  protected def cardFieldsParamName = "card_fields"

  def withCardFields(cardFields: CardField *) = withParams(cardFieldsParamName, cardFields)

}

trait CardField extends RequestParam

object CardField {
  case object all extends CardField with AllRequestParam

  case object badges extends CardField
  case object checkItemStates extends CardField
  case object closed extends CardField
  case object dateLastActivity extends CardField
  case object desc extends CardField
  case object descData extends CardField
  case object due extends CardField
  case object idBoard extends CardField
  case object idChecklists extends CardField
  case object idList extends CardField
  case object idMembers extends CardField
  case object idMembersVoted extends CardField
  case object idShort extends CardField
  case object idAttachmentCover extends CardField
  case object manualCoverAttachment extends CardField
  case object labels extends CardField
  case object name extends CardField
  case object pos extends CardField
  case object shortLink extends CardField
  case object shortUrl extends CardField
  case object subscribed extends CardField
  case object url extends CardField

}