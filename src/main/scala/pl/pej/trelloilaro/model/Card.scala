package pl.pej.trelloilaro.model

import pl.pej.trelloilaro.model.card.{IdsInCard, CheckItemState, Badges}
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Card( id: String,
                 badges: Option[Badges] = None,
                 checkItemStates: Option[List[CheckItemState]] = None,
                 closed: Option[Boolean] = None,
                 dateLastActivity: Option[String] = None,
                 desc: Option[String] = None,
                 descData: Option[Option[String]] = None,
                 due: Option[Option[String]] = None,
                 email: Option[Option[String]] = None,
                 ids: IdsInCard = IdsInCard(),
    //               labels: Option[List[Label]] = None,
                 manualCoverAttachment: Option[Boolean] = None,
                 name: Option[String] = None,
                 pos: Option[Int] = None,
                 shortLink: Option[String] = None,
                 shortUrl: Option[String] = None,
                 subscribed: Option[Boolean] = None,
                 url: Option[String] = None
               )

object Card extends JsonUtil {

//  implicit val cardWrites: Writes[Card] = Json.writes[Card]

  implicit val cardReads: Reads[Card] = (
    (__ \ "id").read[String] and
      (__ \ "badges").readNullable[Badges] and
      (__ \ "checkItemStates").readNullable[List[CheckItemState]] and
      (__ \ "closed").readNullable[Boolean] and
      (__ \ "dateLastActivity").readNullable[String] and
      (__ \ "desc").readNullable[String] and
      (__ \ "descData").readNullableNullable[String] and
      (__ \ "due").readNullableNullable[String] and
      (__ \ "email").readNullableNullable[String] and
  //               labels: Option[List[Label]] = None,
      (__ \ "manualCoverAttachment").readNullable[Boolean] and
      (__ \ "name").readNullable[String] and
      (__ \ "pos").readNullable[Int] and
      (__ \ "shortLink").readNullable[String] and
      (__ \ "shortUrl").readNullable[String] and
      (__ \ "subscribed").readNullable[Boolean] and
      (__ \ "url").readNullable[String] and(IdsInCard.idsInCardReads)
    ){(id, badges, checkItemStates, closed, dateLastActivity, desc, descData, due,
    email, manualCoverAttachment, name, pos, shortLink, shortUrl, subscribed, url, ids) =>
    Card(id, badges, checkItemStates, closed, dateLastActivity, desc, descData, due,
      email,ids, manualCoverAttachment, name, pos, shortLink, shortUrl, subscribed, url)
  }


//  implicit val cardFormat = Format(cardReads, cardWrites)
}
