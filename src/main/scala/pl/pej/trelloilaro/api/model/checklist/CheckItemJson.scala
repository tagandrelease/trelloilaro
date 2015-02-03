package pl.pej.trelloilaro.api.model.checklist

import play.api.libs.json.Json

case class CheckItemJson(
                     id: String,
                     state: Option[String],
                     name: Option[String],
                     pos: Option[Int]
                       )
object CheckItemJson {
  implicit val checkItemsFormat = Json.format[CheckItemJson]

}

