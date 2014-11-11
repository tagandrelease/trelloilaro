package pl.pej.trelloilaro.model.board

import play.api.libs.json.Json
import play.api.libs.functional.syntax._


case class BoardPrefs(
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

object BoardPrefs {
  implicit val boardPrefsFormat = Json.format[BoardPrefs]
}
