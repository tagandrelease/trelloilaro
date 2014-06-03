package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ActionFieldsBuilder[T] { this: RequestBuilder[T] =>

  def withFields(actions: ActionField*) = withParams("action_fields", actions)

}

trait ActionField extends RequestParam

object ActionField {
  case object all extends ActionField with AllRequestParam
  case object idMemberCreator extends ActionField
  case object data extends ActionField
  case object tpe extends ActionField
  case object date extends ActionField
}