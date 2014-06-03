package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ChecklistsBuilder[T] { this: RequestBuilder[T] =>

  def withChecklists(checklists: Checklists *) = withParams("checklists", checklists)

}

trait Checklists extends RequestParam

object Checklists {
  case object all extends Boards with AllRequestParam
  case object none extends Boards
}