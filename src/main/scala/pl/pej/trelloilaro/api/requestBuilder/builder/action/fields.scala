package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait ActionFieldsBuilder[T] { this: RequestBuilder[T] =>

  protected def actionFieldsParamName: String = "action_fields"

  def withActionFields(actions: ActionField*) = withParams(actionFieldsParamName, actions)

}

trait ActionField extends RequestParam

object ActionField {
  case object all extends ActionField with AllRequestParam
  case object idMemberCreator extends ActionField
  case object data extends ActionField
  case object `type` extends ActionField
  case object date extends ActionField
}