package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait EntitiesBuilder[T] { this: RequestBuilder[T] =>

  def withEntities(value: Boolean) = withOnlyParam( "entities", value)

}

trait ActionEntitiesBuilder[T] { this: RequestBuilder[T] =>

  def withEntities(value: Boolean) = withOnlyParam( "actions_entities", value)

}
