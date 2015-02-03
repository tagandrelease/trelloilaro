package pl.pej.trelloilaro.api.model

import play.api.libs.json.Json

case class ListJson(
                   id: String,
                   name: Option[String] = None,
                   closed: Option[Boolean] = None,
                   idBoard: Option[String] = None,
                   pos: Option[Int] = None
//                   subscribed: Option[Option[String]]
                     )

object ListJson {
  implicit val listFormat = Json.format[ListJson]

}

