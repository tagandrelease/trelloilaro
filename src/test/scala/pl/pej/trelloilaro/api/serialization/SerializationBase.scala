package pl.pej.trelloilaro.api.serialization

import com.typesafe.scalalogging.LazyLogging
import pl.pej.trelloilaro.httpclient.TrelloHttpClient.JsonParseErrorException
import pl.pej.trelloilaro.model.{Checklist, Card, Action, Board}
import play.api.libs.json.{JsError, JsSuccess, Json}


trait SerializationBase extends LazyLogging {

  def deserializeBoard(boardJSON: String): Board = {

    Json.parse(boardJSON).validate[Board] match {
      case s: JsSuccess[Board] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a Board: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeAction(actionJSON: String): Action = {

    Json.parse(actionJSON).validate[Action] match {
      case s: JsSuccess[Action] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse an Action: " + msg)
        throw JsonParseErrorException(msg)
    }
  }
  def deserializeActions(actionJSON: String): List[Action] = {

    Json.parse(actionJSON).validate[List[Action]] match {
      case s: JsSuccess[List[Action]] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse an action list: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeCards(cardJSON: String): List[Card] = {

    Json.parse(cardJSON).validate[List[Card]] match {
      case s: JsSuccess[List[Card]] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a Card: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeChecklists(ChecklistJSON: String): List[Checklist] = {

    Json.parse(ChecklistJSON).validate[List[Checklist]] match {
      case s: JsSuccess[List[Checklist]] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a Checklist: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

}
