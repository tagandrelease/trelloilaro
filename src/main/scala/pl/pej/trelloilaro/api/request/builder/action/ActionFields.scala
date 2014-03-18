package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ActionFieldsBuilder { this: RequestBuilder =>

  def withActionFields(actions: ActionFieldsParam*) = RequestBuilder(url, "action_fields", actions)

}

trait ActionFieldsParam extends RequestParam

object ActionFieldsRequestBuilder {
  case object all extends ActionFieldsParam with AllRequestParam
  case object idMemberCreator extends ActionFieldsParam
  case object data extends ActionFieldsParam
  case object tpe extends ActionFieldsParam
  case object date extends ActionFieldsParam
}