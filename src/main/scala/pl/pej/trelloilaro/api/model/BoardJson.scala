package pl.pej.trelloilaro.api.model

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class BoardJson(
                  id: String,
                  closed: Option[Boolean] = None,
                  dateLastActivity: Option[String] = None,
                  dateLastView: Option[Option[String]] = None,

                  desc: Option[String] = None,
//                  descData: Option[String] = None,
                  idOrganization: Option[Option[String]] = None,
                  invitations: Option[List[String]] = None,
                  invited: Option[Boolean] = None,

                  name: Option[String] = None,
                  pinned: Option[Boolean] = None,
                  powerUps: Option[List[String]] = None,

                  shortLink: Option[String] = None,
                  shortUrl: Option[String] = None,
                  url: Option[String] = None,
//                  starred: null
//                  subscribed: null

                  actions: Option[List[ActionJson]] = None
//                  cards: List[Card]
                )

object BoardJson extends JsonUtil {
//  implicit val boardFormat = Json.format[Board]


  implicit val boardWrites: Writes[BoardJson] = Json.writes[BoardJson]

  implicit val boardReads: Reads[BoardJson] = (
      (__ \ "id").read[String] and //.map(BoardId(_)) and
      (__ \ "closed").readNullable[Boolean] and
      (__ \ "dateLastActivity").readNullable[String] and
      (__ \ "dateLastView").readNullableNullable[String] and

      (__ \ "desc").readNullable[String] and
      (__ \ "idOrganization").readNullableNullable[String] and
      (__ \ "invitations").readNullable[List[String]] and
      (__ \ "invited").readNullable[Boolean] and

      (__ \ "name").readNullable[String] and
      (__ \ "pinned").readNullable[Boolean] and
      (__ \ "powerUps").readNullable[List[String]] and

      (__ \ "shortLink").readNullable[String] and
      (__ \ "shortUrl").readNullable[String] and
      (__ \ "url").readNullable[String] and

      (__ \ "actions").readNullable[List[ActionJson]]
//      (__ \ "cards").readNullable[List[Action]].map(_.getOrElse(Nil)) and

    )(BoardJson.apply _)


  implicit val boardFormat: Format[BoardJson] = Format(boardReads, boardWrites)

}


