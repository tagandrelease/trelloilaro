package pl.pej.trelloilaro.api.requestBuilder.builder.checklist

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait CheckItemFieldsBuilder[T] { this: RequestBuilder[T] =>

  def CheckItemFieldsParamName: String = "checkItem_fields"
  
  def withCheckItemFields(fields: CheckItemField *) = withParams(CheckItemFieldsParamName, fields)

}

trait CheckItemField extends RequestParam

object CheckItemField {
  case object all extends CheckItemField with AllRequestParam
  case object name extends CheckItemField
  case object nameData extends CheckItemField
  case object pos extends CheckItemField
  case object state extends CheckItemField
  case object `type` extends CheckItemField


}