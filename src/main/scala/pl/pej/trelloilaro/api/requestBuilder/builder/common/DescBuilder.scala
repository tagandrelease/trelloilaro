package pl.pej.trelloilaro.api.requestBuilder.builder.common

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait DescBuilder[T] extends StringValidator[T] { this: RequestBuilder[T] =>

  def withDesc(desc: String) = withOnlyParamValidated("desc", desc, minLength = 0)

}
