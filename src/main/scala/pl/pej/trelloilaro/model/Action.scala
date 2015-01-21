package pl.pej.trelloilaro.model


import play.api.libs.json.Json
import play.api.libs.functional.syntax._


case class Action(id: String,
                  date: Option[String] = None,
                  idMemberCreator: Option[String] = None,
                  `type`: Option[String] = None
                   )
object Action {
  implicit val actionFormat = Json.format[Action]
}
