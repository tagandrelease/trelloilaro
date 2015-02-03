package pl.pej.trelloilaro.api.model.board

import play.api.libs.json.Json
import play.api.libs.functional.syntax._

case class LabelNamesJson(
                       yellow: String,
                       red: String,
                       purple: String,
                       orange: String,
                       green: String,
                       blue: String
                       )
object LabelNamesJson {
  implicit val labelNamesFormat = Json.format[LabelNamesJson]
}
