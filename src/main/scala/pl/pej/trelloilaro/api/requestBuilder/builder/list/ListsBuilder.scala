package pl.pej.trelloilaro.api.requestBuilder.builder.list

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait ListsBuilder[T] { this: RequestBuilder[T] =>

  protected def listsParamName = "lists"

  def withLists(list: Lists) = withOnlyParam(listsParamName, list)

}

trait Lists extends RequestParam

object Lists {
  case object all extends Lists
  case object none extends Lists
  case object open extends Lists
  case object closed extends Lists
}