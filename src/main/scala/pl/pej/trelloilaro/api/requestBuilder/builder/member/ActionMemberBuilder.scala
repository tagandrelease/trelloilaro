package pl.pej.trelloilaro.api.requestBuilder.builder.member

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait ActionMemberBuilder[T] { this: RequestBuilder[T] =>

  def withActionMember(value: Boolean) = withOnlyParam("action_member", value)

}
