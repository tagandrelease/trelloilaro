package pl.pej.trelloilaro.model

case class BoardId(str: String) extends AnyVal
case class OrganizationId(str: String) extends AnyVal

/*

 Changes here may require changes in `JsonFormat`

  */


case class BoardPrefs(
                      permissionLevel: String,
                      voting: String,
                      comments: String,
                      invitations: String,
                      selfJoin: Boolean,
                      cardCovers: Boolean,
                      background: String,
                      backgroundColor: String,
                      backgroundImage: String,
                      backgroundImageScaled: String,
                      backgroundTile: Boolean,
                      backgroundBrightness: String,
                      canBePublic: Boolean,
                      canBeOrg: Boolean,
                      canBePrivate: Boolean,
                      canInvite: Boolean
                     )

case class LabelNames(
                      yellow: String,
                      red: String,
                      purple: String,
                      orange: String,
                      green: String,
                      blue: String
                     )

case class Board(
                  id: BoardId,
                  name: String,
                  desc: String,
                  closed: Boolean,
                  idOrganization: OrganizationId,
                  url: String,
                  shortUrl: String,
                  prefs: BoardPrefs,
                  action: List[Action],
                  cards: List[Card]
                )

case class Action(name: String)

case class Card(name: String)