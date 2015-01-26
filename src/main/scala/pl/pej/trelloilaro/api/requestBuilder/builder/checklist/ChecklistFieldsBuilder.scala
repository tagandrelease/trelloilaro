package pl.pej.trelloilaro.api.requestBuilder.builder.checklist

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestBuilder, RequestParam}

trait ChecklistFieldsBuilder[T] { this: RequestBuilder[T] =>

  protected def checklistFieldsParamName: String = "checklist_fields"

  def withChecklistFields(checklistFields: ChecklistField *) = withParams(checklistFieldsParamName, checklistFields)

}

trait ChecklistField extends RequestParam

object ChecklistField {
  case object all extends ChecklistField with AllRequestParam
  case object name extends ChecklistField
  case object idBoard extends ChecklistField
  case object idCard extends ChecklistField
  case object pos extends ChecklistField
}