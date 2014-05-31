package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait BoardsBuilder { this: RequestBuilder[_] =>

  def withBoards(boards: BoardsParam *) = withParams("boards", boards)

}

trait BoardsParam extends RequestParam

object BoardsRequestBuilder {
  case object all extends BoardsParam with AllRequestParam
  case object members extends BoardsParam
  case object organization extends BoardsParam
  case object public extends BoardsParam
  case object open extends BoardsParam
  case object closed extends BoardsParam
  case object pinned extends BoardsParam
  case object unpinned extends BoardsParam
  case object starred extends BoardsParam

}