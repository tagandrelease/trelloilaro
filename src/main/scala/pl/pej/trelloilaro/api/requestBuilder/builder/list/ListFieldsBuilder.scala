package pl.pej.trelloilaro.api.requestBuilder.builder.list

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait ListFieldsBuilder[T] { this: RequestBuilder[T] =>

  def withListFields(listFields: ListField *) = withParams("list_fields", listFields)

}

trait ListField extends RequestParam

object ListField {
  case object all extends ListField with AllRequestParam

  case object name extends ListField
  case object closed extends ListField
  case object idBoard extends ListField
  case object pos extends ListField
  case object subscribed extends ListField

}