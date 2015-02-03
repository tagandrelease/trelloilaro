package pl.pej.trelloilaro.api.model.card

import play.api.libs.json.Json

case class CheckItemStateJson(idCheckItem: String, state: String)
object CheckItemStateJson {
  implicit val checkItemStateFormat = Json.format[CheckItemStateJson]
}
