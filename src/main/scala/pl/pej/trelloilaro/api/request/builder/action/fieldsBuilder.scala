package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait FieldBuilder { this: RequestBuilder[_] =>

  def fields(actions: ActionFieldsParam*) = withParams("action_fields", actions)

}

trait ActionFieldsParam extends RequestParam

object Fields {
  case object all extends ActionFieldsParam with AllRequestParam
  case object idMemberCreator extends ActionFieldsParam
  case object data extends ActionFieldsParam
  case object tpe extends ActionFieldsParam
  case object date extends ActionFieldsParam
}