package pl.pej.trelloilaro.model


import pl.pej.trelloilaro.model.board.{LabelNames, BoardPrefs}
import play.api.libs.json._
import play.api.libs.functional.syntax._

/*

"id" : "53aef54598654cd1f4486f08",
"closed" : false,
"dateLastActivity" : "2015-01-13T21:50:47.986Z",
"dateLastView" : null,
"desc" : "",
"descData" : null,
"idOrganization" : null,
"invitations" : [ ],
"invited" : false,
"name" : "ApiTestBoard",
"pinned" : false,
"powerUps" : [ "voting" ],
"shortLink" : "kVYrEz26",
"shortUrl" : "https://trello.com/b/kVYrEz26",
"starred" : null,
"subscribed" : null,
"url" : "https://trello.com/b/kVYrEz26/apitestboard"
*/



case class Board(
                  id: String,
                  closed: Option[Boolean] = None,
                  dateLastActivity: Option[Option[String]] = None,
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

                  actions: Option[List[Action]] = None
//                  cards: List[Card]
                )

object Board extends JsonUtil {
//  implicit val boardFormat = Json.format[Board]


  implicit val boardWrites: Writes[Board] = Json.writes[Board]

  implicit val boardReads: Reads[Board] = (
      (__ \ "id").read[String] and //.map(BoardId(_)) and
      (__ \ "closed").readNullable[Boolean] and
      (__ \ "dateLastActivity").readNullableNullable[String] and
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

      (__ \ "actions").readNullable[List[Action]]
//      (__ \ "cards").readNullable[List[Action]].map(_.getOrElse(Nil)) and

    )(Board.apply _)


//  implicit val boardFormat: Format[Board] = Format(boardReads, boardWrites)

}


