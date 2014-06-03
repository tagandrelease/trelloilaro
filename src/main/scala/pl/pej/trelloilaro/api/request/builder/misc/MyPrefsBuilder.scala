package pl.pej.trelloilaro.api.request.builder.misc

import pl.pej.trelloilaro.api.request.RequestBuilder

trait MyPrefsBuilder[T] { this: RequestBuilder[T] =>

  def withMyPrefs(value: Boolean) = withOnlyParam("myPrefs", value)

}