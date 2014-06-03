package pl.pej.trelloilaro.api.request.builder.member

import pl.pej.trelloilaro.api.request.RequestBuilder

trait MembersBuilder[T] { this: RequestBuilder[T] =>

  def withMembers(value: Boolean) = withOnlyParam("members", value)
}
