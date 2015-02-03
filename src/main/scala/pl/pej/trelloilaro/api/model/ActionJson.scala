package pl.pej.trelloilaro.api.model


import play.api.libs.json.Json
import play.api.libs.functional.syntax._


case class ActionJson(id: String,
                  date: Option[String] = None,
                  idMemberCreator: Option[String] = None,
                  `type`: Option[String] = None
//                  data: Option[ActionData] = None
                   )
object ActionJson {
  implicit val actionFormat = Json.format[ActionJson]
}
