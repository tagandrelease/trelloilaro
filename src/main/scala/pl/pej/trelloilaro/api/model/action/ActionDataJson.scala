package pl.pej.trelloilaro.api.model.action

import play.api.libs.json.Json

case class ListDataJson(name: String, id: String)
object ListDataJson {  implicit val actionFormat = Json.format[ListDataJson] }


case class BoardDataJson(name: String, id: String)
object BoardDataJson {  implicit val actionFormat = Json.format[BoardDataJson] }


case class CardDataJson(name: String, id: String)
object CardDataJson {  implicit val actionFormat = Json.format[CardDataJson] }

case class ActionDataJson(
                     text: Option[String] = None,
                     list: Option[ListDataJson] = None,
                     board: Option[BoardDataJson] = None,
                     old: Option[BoardDataJson] = None,
                     card: Option[CardDataJson] = None
                       )

object ActionDataJson {
  implicit val actionFormat = Json.format[ActionDataJson]
}