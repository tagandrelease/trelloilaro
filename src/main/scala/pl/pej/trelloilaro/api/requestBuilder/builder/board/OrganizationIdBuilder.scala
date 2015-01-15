package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder
import pl.pej.trelloilaro.api.requestBuilder.builder.common.StringValidator

trait OrganizationIdBuilder[T] extends StringValidator[T] { this: RequestBuilder[T] =>

  def withIdOrganization(id: String) = withOnlyParamValidated("idOrganization", id)

}
