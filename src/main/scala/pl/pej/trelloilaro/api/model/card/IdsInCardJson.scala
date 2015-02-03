package pl.pej.trelloilaro.api.model.card

import pl.pej.trelloilaro.api.model.JsonUtil
import play.api.libs.json._
import play.api.libs.functional.syntax._


/** Class created because of 22 arguments scala limit
  * to contain identifiers in cards
  *
  * @param idAttachmentCover
  * @param idBoard
  * @param idChecklists
  * @param idLabels
  * @param idList
  * @param idMembers
  * @param idMembersVoted
  * @param idShort
  */
case class IdsInCardJson(
                      idAttachmentCover: Option[Option[String]] = None,
                      idBoard: Option[String] = None,
                      idChecklists: Option[List[String]] = None,
                      idLabels: Option[List[String]] = None,
                      idList: Option[String] = None,
                      idMembers: Option[List[String]] = None,
                      idMembersVoted: Option[List[String]] = None,
                      idShort: Option[Int] = None
                      )

object IdsInCardJson extends JsonUtil {
  implicit val idsInCardReads: Reads[IdsInCardJson] = (
    (__ \ "idAttachmentCover").readNullableNullable[String] and
      (__ \ "idBoard").readNullable[String] and
      (__ \ "idChecklists").readNullable[List[String]] and
      (__ \ "idLabels").readNullable[List[String]] and
      (__ \ "idList").readNullable[String] and
      (__ \ "idMembers").readNullable[List[String]] and
      (__ \ "idMembersVoted").readNullable[List[String]] and
      (__ \ "idShort").readNullable[Int]
    )(IdsInCardJson.apply _)
}