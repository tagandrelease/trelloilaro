package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ChecklistsBuilder[T] { this: RequestBuilder[T] =>

  def withChecklists(checklists: Checklists) = withOnlyParam("checklists", checklists)

}
trait CardChecklistsBuilder[T] { this: RequestBuilder[T] =>

  def withCardChecklists(checklists: Checklists) = withOnlyParam("card_checklists", checklists)

}

trait Checklists extends RequestParam

object Checklists {
  case object all extends Checklists with AllRequestParam
  case object none extends Checklists

}