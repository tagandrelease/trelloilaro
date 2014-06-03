package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait BoardsBuilder { this: RequestBuilder[_] =>

  def withBoards(boards: Boards *) = withParams("boards", boards)

}

trait Boards extends RequestParam

object Boards {
  case object all extends Boards with AllRequestParam
  case object members extends Boards
  case object organization extends Boards
  case object public extends Boards
  case object open extends Boards
  case object closed extends Boards
  case object pinned extends Boards
  case object unpinned extends Boards
  case object starred extends Boards

}