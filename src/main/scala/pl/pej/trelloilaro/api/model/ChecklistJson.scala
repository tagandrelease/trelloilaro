package pl.pej.trelloilaro.api.model

import pl.pej.trelloilaro.api.model.checklist.CheckItemJson
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class ChecklistJson(
                    id: String,
                    idBoard: Option[String] = None,
                    idCard: Option[String] = None,
                    name: Option[String] = None,
                    pos: Option[Int] = None,
                    checkItems: Option[List[CheckItemJson]] = None
                      )

object ChecklistJson {
  implicit val checklistFormat = Json.format[ChecklistJson]

}

