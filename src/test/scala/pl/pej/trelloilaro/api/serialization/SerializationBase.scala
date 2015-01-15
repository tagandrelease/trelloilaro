package pl.pej.trelloilaro.api.serialization

import com.typesafe.scalalogging.LazyLogging
import pl.pej.trelloilaro.httpclient.TrelloHttpClient.JsonParseErrorException
import pl.pej.trelloilaro.model.{Card, Action, Board}
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
        logger.error("Json error while trying to parse a Action: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

  def deserializeCard(cardJSON: String): Card = {

    Json.parse(cardJSON).validate[Card] match {
      case s: JsSuccess[Card] => s.get
      case e: JsError =>
        val msg = JsError.toFlatJson(e).toString()
        logger.error("Json error while trying to parse a Card: " + msg)
        throw JsonParseErrorException(msg)
    }
  }

}
