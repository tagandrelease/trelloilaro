package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardFieldsBuilder { this: RequestBuilder =>

  def withCardFields(cardFields: CardFieldsParam *) = cp(url, "card_fields", cardFields)

}

trait CardFieldsParam extends RequestParam

object CardFieldsRequestBuilder {
  case object all extends CardFieldsParam with AllRequestParam

  case object badges extends CardFieldsParam
  case object checkItemStates extends CardFieldsParam
  case object closed extends CardFieldsParam
  case object dateLastActivity extends CardFieldsParam
  case object desc extends CardFieldsParam
  case object descData extends CardFieldsParam
  case object due extends CardFieldsParam
  case object idBoard extends CardFieldsParam
  case object idChecklists extends CardFieldsParam
  case object idList extends CardFieldsParam
  case object idMembers extends CardFieldsParam
  case object idMembersVoted extends CardFieldsParam
  case object idShort extends CardFieldsParam
  case object idAttachmentCover extends CardFieldsParam
  case object manualCoverAttachment extends CardFieldsParam
  case object labels extends CardFieldsParam
  case object name extends CardFieldsParam
  case object pos extends CardFieldsParam
  case object shortLink extends CardFieldsParam
  case object shortUrl extends CardFieldsParam
  case object subscribed extends CardFieldsParam
  case object url extends CardFieldsParam

}