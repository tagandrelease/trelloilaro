package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait ChecklistFieldsBuilder[T] { this: RequestBuilder[T] =>

  def withChecklistFields(checklistFields: ChecklistField *) = withParams("checklist_fields", checklistFields)

}

trait ChecklistField extends RequestParam

object ChecklistField {
  case object all extends ChecklistField with AllRequestParam
  case object name extends Boards
  case object idBoard extends Boards
  case object idCard extends Boards
  case object pos extends Boards
}