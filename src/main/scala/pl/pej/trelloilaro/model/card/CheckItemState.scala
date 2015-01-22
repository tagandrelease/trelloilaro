package pl.pej.trelloilaro.model.card

import play.api.libs.json.Json


case class CheckItemState(idCheckItem: String, state: String)
object CheckItemState {
  implicit val checkItemStateFormat = Json.format[CheckItemState]
}
