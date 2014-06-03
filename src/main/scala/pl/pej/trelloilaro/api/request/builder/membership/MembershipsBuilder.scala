package pl.pej.trelloilaro.api.request.builder.membership

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait MembershipsBuilder[T] { this: RequestBuilder[T] =>

  def withMemberships(value: Memberships) = withOnlyParam("memberships", value)

}
trait OrganizationMembershipsBuilder[T] { this: RequestBuilder[T] =>

  def withOrganizationMemberships(value: Memberships) = withOnlyParam("organization_memberships", value)

}

trait Memberships extends RequestParam

object Memberships {
  case object all extends Memberships
  case object me extends Memberships
  case object normal extends Memberships
  case object admin extends Memberships
  case object active extends Memberships
  case object deactivated extends Memberships

}