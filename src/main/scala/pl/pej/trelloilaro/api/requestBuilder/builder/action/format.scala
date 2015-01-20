package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.{RequestParam, RequestBuilder}

trait ActionFormatBuilder[T] { this: RequestBuilder[T] =>

  protected def actionFormatParamName: String = "actions_format"

  def withActionFormat(format: ActionFormat) = withOnlyParam(actionFormatParamName, format)

}

trait ActionFormat extends RequestParam

object ActionFormat {
  case object count extends ActionFormat
  case object list extends ActionFormat
  case object minimal extends ActionFormat
}