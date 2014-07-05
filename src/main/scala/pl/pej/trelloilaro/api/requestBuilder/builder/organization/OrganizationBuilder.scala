package pl.pej.trelloilaro.api.requestBuilder.builder.organization

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder


trait OrganizationBuilder[T] { this: RequestBuilder[T] =>

  def withOrganization(value: Boolean) = withOnlyParam("organization", value)

}