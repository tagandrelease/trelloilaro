package pl.pej.trelloilaro.api.model.card

import play.api.libs.json.Json

case class BadgesJson(
                   votes: Int,
                   viewingMemberVoted: Boolean,
                   subscribed: Boolean,
                   fogbugz: String,
                   checkItems: Int,
                   checkItemsChecked: Int,
                   comments: Int,
                   attachments: Int,
                   description: Boolean,
                   due: Option[String]
                   )
object BadgesJson {
  implicit val badgesFormat = Json.format[BadgesJson]
}

