package pl.pej.trelloilaro.httpclient.serialization

import spray.json.DefaultJsonProtocol._
import pl.pej.trelloilaro.model._
import pl.pej.trelloilaro.model.Board
import pl.pej.trelloilaro.model.BoardId
import pl.pej.trelloilaro.model.BoardPrefs
import pl.pej.trelloilaro.model.OrganizationId

object TrelloJsonFormat {
  implicit val boardIdJF = jsonFormat1(BoardId)
  implicit val orgJF = jsonFormat1(OrganizationId)
  implicit val boardPrefsJF = jsonFormat16(BoardPrefs)

  implicit val labelNamesJF = jsonFormat6(LabelNames)

  implicit val actionJF = jsonFormat1(Action)
  implicit val cardJF = jsonFormat1(Card)

  implicit val boardJF = jsonFormat10(Board)
}