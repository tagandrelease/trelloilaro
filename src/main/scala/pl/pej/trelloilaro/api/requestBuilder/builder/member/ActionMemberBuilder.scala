package pl.pej.trelloilaro.api.requestBuilder.builder.member

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait ActionMemberBuilder[T] { this: RequestBuilder[T] =>

  protected def actionMemberParamName: String = "action_member"

  def withActionMember(value: Boolean) = withOnlyParam(actionMemberParamName, value)

}
