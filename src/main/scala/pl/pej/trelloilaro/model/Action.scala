package pl.pej.trelloilaro.model


import pl.pej.trelloilaro.model.action.ActionData
import play.api.libs.json.Json
import play.api.libs.functional.syntax._


case class Action(id: String,
                  date: Option[String] = None,
                  idMemberCreator: Option[String] = None,
                  `type`: Option[String] = None
//                  data: Option[ActionData] = None
                   )
object Action {
  implicit val actionFormat = Json.format[Action]
}
