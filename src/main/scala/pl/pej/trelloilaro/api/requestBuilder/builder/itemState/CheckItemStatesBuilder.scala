package pl.pej.trelloilaro.api.requestBuilder.builder.itemState

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait CheckItemStatesBuilder[T] { this: RequestBuilder[T] =>

  def withCheckItemStates(value: Boolean) = withOnlyParam("checkItemStates", value)

}