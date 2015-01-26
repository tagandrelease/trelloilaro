package pl.pej.trelloilaro.model

import pl.pej.trelloilaro.model.checklist.CheckItem
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Checklist(
                    id: String,
                    idBoard: Option[String] = None,
                    idCard: Option[String] = None,
                    name: Option[String] = None,
                    pos: Option[Int] = None,
                    checkItems: Option[List[CheckItem]] = None
                      )

object Checklist {
  implicit val checklistFormat = Json.format[Checklist]

}

