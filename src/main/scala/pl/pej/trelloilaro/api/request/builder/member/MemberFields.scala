package pl.pej.trelloilaro.api.request.builder.member

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ActionMemberCreatorFieldsBuilder[T] { this: RequestBuilder[T] =>
  def withActionMemberCreatorFields(fields: MemberField *) = withParams("action_memberCreator_fields", fields)
}

trait MemberFieldsBuilder[T] { this: RequestBuilder[T] =>
  def withMemberFields(fields: MemberField *) = withParams("member_fields", fields)
}

trait MemberField extends RequestParam

object MemberField {
  case object avatarHash extends MemberField
  case object bio extends MemberField
  case object bioData extends MemberField
  case object confirmed extends MemberField
  case object fullName extends MemberField
  case object idPremOrgsAdmin extends MemberField
  case object initials extends MemberField
  case object memberType extends MemberField
  case object products extends MemberField
  case object status extends MemberField
  case object url extends MemberField
  case object username extends MemberField
}