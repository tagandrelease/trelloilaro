package pl.pej.trelloilaro.model.action

import play.api.libs.json.Json

case class ListData(name: String, id: String)
object ListData {  implicit val actionFormat = Json.format[ListData] }


case class BoardData(name: String, id: String)
object BoardData {  implicit val actionFormat = Json.format[BoardData] }


case class CardData(name: String, id: String)
object CardData {  implicit val actionFormat = Json.format[CardData] }

case class ActionData(
                     text: Option[String] = None,
                     list: Option[ListData] = None,
                     board: Option[BoardData] = None,
                     old: Option[BoardData] = None,
                     card: Option[CardData] = None
                       )

object ActionData {
  implicit val actionFormat = Json.format[ActionData]
}