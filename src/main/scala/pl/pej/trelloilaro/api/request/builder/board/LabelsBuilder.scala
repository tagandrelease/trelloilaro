package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.RequestBuilder

trait LabelsBuilder[T] { this: RequestBuilder[T] =>

  def withLabels(value: Boolean) = withOnlyParam("labels", value)
}