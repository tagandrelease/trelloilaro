package pl.pej.trelloilaro.model.board

import play.api.libs.json.Json
import play.api.libs.functional.syntax._

case class LabelNames(
                       yellow: String,
                       red: String,
                       purple: String,
                       orange: String,
                       green: String,
                       blue: String
                       )
object LabelNames {
  implicit val labelNamesFormat = Json.format[LabelNames]
}
