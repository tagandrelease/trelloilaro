package pl.pej.trelloilaro.api.request.builder.membership

import pl.pej.trelloilaro.api.request.RequestBuilder

trait MembershipsMemberBuilder[T] { this: RequestBuilder[T] =>

  def withMembershipsMember(value: Boolean) = withOnlyParam("memberships_member", value)

}