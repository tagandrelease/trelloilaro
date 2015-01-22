package pl.pej.trelloilaro.model.card

import pl.pej.trelloilaro.model.JsonUtil
import play.api.libs.json._
import play.api.libs.functional.syntax._


case class IdsInCard(
                      idAttachmentCover: Option[Option[String]] = None,
                      idBoard: Option[String] = None,
                      idChecklists: Option[List[String]] = None,
                      idLabels: Option[List[String]] = None,
                      idList: Option[String] = None,
                      idMembers: Option[List[String]] = None,
                      idMembersVoted: Option[List[String]] = None,
                      idShort: Option[Int] = None
                      )

object IdsInCard extends JsonUtil {
  implicit val idsInCardReads: Reads[IdsInCard] = (
    (__ \ "idAttachmentCover").readNullableNullable[String] and
      (__ \ "idBoard").readNullable[String] and
      (__ \ "idChecklists").readNullable[List[String]] and
      (__ \ "idLabels").readNullable[List[String]] and
      (__ \ "idList").readNullable[String] and
      (__ \ "idMembers").readNullable[List[String]] and
      (__ \ "idMembersVoted").readNullable[List[String]] and
      (__ \ "idShort").readNullable[Int]
    )(IdsInCard.apply _)
}