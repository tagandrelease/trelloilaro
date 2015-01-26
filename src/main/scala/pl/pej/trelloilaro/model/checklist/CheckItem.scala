package pl.pej.trelloilaro.model.checklist

import play.api.libs.json.Json

case class CheckItem(
                     id: String,
                     state: Option[String],
                     name: Option[String],
                     pos: Option[Int]
                       )
object CheckItem {
  implicit val checkItemsFormat = Json.format[CheckItem]

}

