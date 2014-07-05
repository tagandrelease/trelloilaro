package pl.pej.trelloilaro.api.requestBuilder.builder.misc

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait MyPrefsBuilder[T] { this: RequestBuilder[T] =>

  def withMyPrefs(value: Boolean) = withOnlyParam("myPrefs", value)

}