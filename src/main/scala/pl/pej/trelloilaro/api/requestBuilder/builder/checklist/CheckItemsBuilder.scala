package pl.pej.trelloilaro.api.requestBuilder.builder.checklist

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait CheckItemsBuilder[T] { this: RequestBuilder[T] =>

  def checkItemsParamName: String = "checkItems"

  def withCheckItems(checkItems: CheckItems) = withOnlyParam(checkItemsParamName, checkItems)

}

trait CheckItems extends RequestParam

object CheckItems {
  case object all extends CheckItems with AllRequestParam
  case object none extends CheckItems
}