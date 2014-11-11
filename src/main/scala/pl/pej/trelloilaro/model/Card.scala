package pl.pej.trelloilaro.model

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Card(name: String)
object Card {
  implicit val cardFormat = Json.format[Card]
}
