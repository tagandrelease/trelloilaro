package pl.pej.trelloilaro.api.request.builder.organization

import pl.pej.trelloilaro.api.request.RequestBuilder


trait OrganizationBuilder[T] { this: RequestBuilder[T] =>

  def withOrganization(value: Boolean) = withOnlyParam("organization", value)

}