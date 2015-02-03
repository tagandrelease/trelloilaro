package pl.pej.trelloilaro.api.serialization

import com.typesafe.scalalogging.LazyLogging
import pl.pej.trelloilaro.api.model._
import pl.pej.trelloilaro.httpclient.TrelloHttpClient.JsonParseErrorException
import play.api.libs.json.{JsError, JsSuccess, Json}


trait SerializationBase extends LazyLogging {

  def deserializeBoard(boardJSON: String): BoardJson = {

    Json.parse(boardJSON).validate[BoardJson] match {
      case s: JsSuccess[BoardJson] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a Board: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeAction(actionJSON: String): ActionJson = {

    Json.parse(actionJSON).validate[ActionJson] match {
      case s: JsSuccess[ActionJson] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse an Action: " + msg)
        throw JsonParseErrorException(msg)
    }
  }
  def deserializeActions(actionJSON: String): List[ActionJson] = {

    Json.parse(actionJSON).validate[List[ActionJson]] match {
      case s: JsSuccess[List[ActionJson]] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse an action list: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeCards(cardJSON: String): List[CardJson] = {

    Json.parse(cardJSON).validate[List[CardJson]] match {
      case s: JsSuccess[List[CardJson]] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a Card: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeChecklists(ChecklistJSON: String): List[ChecklistJson] = {

    Json.parse(ChecklistJSON).validate[List[ChecklistJson]] match {
      case s: JsSuccess[List[ChecklistJson]] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a Checklist: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeLists(ListJSON: String): List[ListJson] = {

    Json.parse(ListJSON).validate[List[ListJson]] match {
      case s: JsSuccess[List[ListJson]] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a List: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

}
