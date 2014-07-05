package pl.pej.trelloilaro.api.requestBuilder.builder.membership

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait MembershipsMemberBuilder[T] { this: RequestBuilder[T] =>

  def withMembershipsMember(value: Boolean) = withOnlyParam("memberships_member", value)

}