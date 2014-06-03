package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{RequestParam, RequestBuilder}

trait ActionFormatBuilder[T] { this: RequestBuilder[T] =>

  def withActionFormat(format: ActionFormat) = withOnlyParam("actions_format", format)

}

trait ActionFormat extends RequestParam

object ActionFormat {
  case object count extends ActionFormat
  case object list extends ActionFormat
  case object minimal extends ActionFormat
}