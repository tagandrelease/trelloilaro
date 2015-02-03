package pl.pej.trelloilaro.api.model.board

import play.api.libs.json.Json
import play.api.libs.functional.syntax._


case class BoardPrefsJson(
                       permissionLevel: String,
                       voting: String,
                       comments: String,
                       invitations: String,
                       selfJoin: Boolean,
                       cardCovers: Boolean,
                       background: String,
                       backgroundColor: String,
                       backgroundImage: Option[String],
                       backgroundImageScaled: Option[String],
                       backgroundTile: Boolean,
                       backgroundBrightness: String,
                       canBePublic: Boolean,
                       canBeOrg: Boolean,
                       canBePrivate: Boolean,
                       canInvite: Boolean
                       )

object BoardPrefsJson {
  implicit val boardPrefsFormat = Json.format[BoardPrefsJson]
}
