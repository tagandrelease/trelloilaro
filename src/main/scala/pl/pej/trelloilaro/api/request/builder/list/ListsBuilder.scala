package pl.pej.trelloilaro.api.request.builder.list

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ListsBuilder[T] { this: RequestBuilder[T] =>

  def withLists(list: Lists) = withOnlyParam("lists", list)

}

trait Lists extends RequestParam

object Lists {
  case object all extends Lists
  case object none extends Lists
  case object open extends Lists
  case object closed extends Lists
}