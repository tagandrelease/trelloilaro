package pl.pej.trelloilaro.api.request.builder.itemState

import pl.pej.trelloilaro.api.request.{RequestBuilder}

trait CheckItemStatesBuilder[T] { this: RequestBuilder[T] =>

  def withItemStatesChecked(value: Boolean) = withOnlyParam("checkItemStates", value)

}