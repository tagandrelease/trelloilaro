package pl.pej.trelloilaro.api.request.builder.member

import pl.pej.trelloilaro.api.request.RequestBuilder

trait ActionMemberBuilder[T] { this: RequestBuilder[T] =>

  def withActionMember(value: Boolean) = withOnlyParam("action_member", value)

}
