package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardMemberFieldsBuilder {
  this: RequestBuilder[_] =>

  def withCardMemberFields(fields: CardMemberFieldsParam *) = withParams("card_member_fields", fields)

}

trait CardMemberFieldsParam extends RequestParam

object CardMemberFieldsRequestBuilder {
  case object all extends CardMemberFieldsParam with AllRequestParam

  case object avatarHash extends CardMemberFieldsParam
  case object bio extends CardMemberFieldsParam
  case object bioData extends CardMemberFieldsParam
  case object confirmed extends CardMemberFieldsParam
  case object fullName extends CardMemberFieldsParam
  case object idPremOrgsAdmin extends CardMemberFieldsParam
  case object initials extends CardMemberFieldsParam
  case object memberType extends CardMemberFieldsParam
  case object products extends CardMemberFieldsParam
  case object status extends CardMemberFieldsParam
  case object url extends CardMemberFieldsParam
  case object username extends CardMemberFieldsParam
}