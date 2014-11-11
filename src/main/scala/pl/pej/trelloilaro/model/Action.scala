package pl.pej.trelloilaro.model


import play.api.libs.json.Json
import play.api.libs.functional.syntax._


case class Action(name: String)
object Action {
  implicit val actionFormat = Json.format[Action]
}
