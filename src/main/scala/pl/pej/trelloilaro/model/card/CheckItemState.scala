package pl.pej.trelloilaro.model.card

import play.api.libs.json.Json

/** Zakładam, ze to wystepuje tylko w cardzie a w checliscie jest cos innego
  *
  * @param idCheckItem
  * @param state
  */
case class CheckItemState(idCheckItem: String, state: String)
object CheckItemState {
  implicit val checkItemStateFormat = Json.format[CheckItemState]
}
