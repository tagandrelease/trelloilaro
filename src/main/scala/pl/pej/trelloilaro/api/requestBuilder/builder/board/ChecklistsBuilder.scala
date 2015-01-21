package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait ChecklistsBuilder[T] { this: RequestBuilder[T] =>

  protected def checklistsParamName: String = "checklists"

  def withChecklists(checklists: Checklists) = withOnlyParam(checklistsParamName, checklists)

}

trait Checklists extends RequestParam

object Checklists {
  case object all extends Checklists with AllRequestParam
  case object none extends Checklists

}