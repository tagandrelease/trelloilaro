package pl.pej.trelloilaro.model


import pl.pej.trelloilaro.model.board.{LabelNames, OrganizationId, BoardPrefs}
import play.api.libs.json._
import play.api.libs.functional.syntax._

//case class BoardId(str: String) extends AnyVal



case class Board(
                  id: String,
                  name: String,
                  desc: String,
                  closed: Boolean,
                  idOrganization: Option[OrganizationId],
                  pinned: Boolean,
                  url: String,
                  shortUrl: String,
                  prefs: BoardPrefs,
                  labelNames: LabelNames
//                  action: List[Action],
//                  cards: List[Card]
                )

object Board {
//  implicit val boardFormat = Json.format[Board]


  implicit val boardWrites: Writes[Board] = Json.writes[Board]

  implicit val boardReads: Reads[Board] = (
      (__ \ "id").read[String] and
      (__ \ "name").read[String] and
      (__ \ "desc").read[String] and
      (__ \ "closed").read[Boolean] and
      (__ \ "idOrganization").readNullable[OrganizationId] and
      (__ \ "pinned").read[Boolean] and
      (__ \ "url").read[String] and
      (__ \ "shortUrl").read[String] and
      (__ \ "prefs").read[BoardPrefs] and
      (__ \ "labelNames").read[LabelNames] //and
//      (__ \ "action").readNullable[List[Action]].map(_.getOrElse(Nil)) and
//      (__ \ "cards").readNullable[List[Action]].map(_.getOrElse(Nil)) and
    )(Board.apply _)

  implicit val boardFormat: Format[Board] = Format(boardReads, boardWrites)

}


