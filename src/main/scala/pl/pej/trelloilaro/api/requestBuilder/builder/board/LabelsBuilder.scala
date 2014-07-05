package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait LabelsBuilder[T] { this: RequestBuilder[T] =>

  def withLabels(value: Boolean) = withOnlyParam("labels", value)
}