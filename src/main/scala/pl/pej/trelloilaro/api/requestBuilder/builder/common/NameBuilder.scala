package pl.pej.trelloilaro.api.requestBuilder.builder.common

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait NameBuilder[T] extends StringValidator[T] { this: RequestBuilder[T] =>

  def withName(name: String) = withOnlyParamValidated("name", name, minLength = 1)

}
