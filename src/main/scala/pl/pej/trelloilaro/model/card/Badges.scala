package pl.pej.trelloilaro.model.card

import play.api.libs.json.Json

case class Badges(
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
object Badges {
  implicit val badgesFormat = Json.format[Badges]
}

