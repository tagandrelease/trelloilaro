package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{ActionRequestBuilder, RequestParam, RequestBuilder}

trait EntitiesBuilder { this: RequestBuilder[_] =>

  def withEntities(value: Boolean) = withParam( "entities", value)

}
