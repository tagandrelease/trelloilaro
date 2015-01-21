package pl.pej.trelloilaro.api.requestBuilder.builder.member

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait MemberOrNotBuilder[T] { this: RequestBuilder[T] =>

  protected def memberOrNotParamName: String = "members"

  def withMemberOrNot(value: Boolean) = withOnlyParam(memberOrNotParamName, value)

}
