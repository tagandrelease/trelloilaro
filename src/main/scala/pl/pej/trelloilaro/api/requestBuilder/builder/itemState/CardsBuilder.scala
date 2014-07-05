//package pl.pej.trelloilaro.api.request.builder.itemState
//
//import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}
//
//trait CheckItemStateFieldsBuilder[T] { this: RequestBuilder[T] =>
//
//  def withItemStateFieldsCheckedFields(fields: CheckItemStateField*) = withParams("checkItemStates_fields", fields)
//}
//
//trait CheckItemStateField extends RequestParam
//
//object CheckItemStateField {
//  case object all extends CheckItemStateField
//  case object idCheckItem extends CheckItemStateField
//  case object state extends CheckItemStateField
//}