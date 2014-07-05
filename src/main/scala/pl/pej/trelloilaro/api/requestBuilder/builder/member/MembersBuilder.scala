package pl.pej.trelloilaro.api.requestBuilder.builder.member

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait MembersBuilder[T] { this: RequestBuilder[T] =>

  def withMembers(values: Members*) = withParams("members", values)
}
trait MembersInvitedBuilder[T] { this: RequestBuilder[T] =>

  def withMembersInvited(values: Members*) = withParams("membersInvited", values)
}

trait Members extends RequestParam

object Members {
  case object all extends Members with AllRequestParam
  case object none extends Members
  case object normal extends Members
  case object admins extends Members
  case object owners extends Members
}