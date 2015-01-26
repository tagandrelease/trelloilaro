package pl.pej.trelloilaro.httpclient

import java.io.{File, FileWriter}

import com.typesafe.scalalogging.LazyLogging
import pl.pej.trelloilaro.httpclient.TrelloHttpClient.JsonParseErrorException
import spray.client.pipelining
import scala.concurrent.stm.Source
import scala.concurrent.{Promise, Future, ExecutionContext}
import pl.pej.trelloilaro.api.requestBuilder._
import pl.pej.trelloilaro.model._
import spray.http.{HttpCharsets, HttpCharset, HttpResponse}
import akka.util.Timeout
import play.api.libs.json._
import play.api.libs.functional.syntax._

/** Supports object oriented queires.
  *
  * Includes domain knowledge: binds RequestBuilder to model instance.
 */
class TrelloHttpClient(apiKey: String) extends TrelloAbstractHttpClient(apiKey) with LazyLogging {

  implicit val ec = ExecutionContext.Implicits.global

  protected def getStringResponse(requestBuilder: RequestBuilder[RequestBuilder[_]]): Future[String] = {
    get(requestBuilder).map{ response =>
      val str = response.entity.asString(HttpCharsets.`UTF-8`)

//      logger.debug(str)
      str
    }
  }

  def getBoard(requestBuilder: GetBoard): Future[Board] = {

    getStringResponse(requestBuilder).map { json =>
      val parsed = Json.parse(json)

      logger.debug("Board parsed: " + Json.prettyPrint(parsed))

      parsed.validate[Board] match {
        case s: JsSuccess[Board] =>

          s.get
        case e: JsError =>
          val msg = JsError.toFlatJson(e).toString()
          logger.error("Json error while trying to parse a Board: " + msg)
          throw JsonParseErrorException(msg)
      }
    }
  }

  def getBoardActions(requestBuilder: GetBoardActions): Future[List[Action]] = {
    getStringResponse(requestBuilder).map { json =>
      val parsed = Json.parse(json)

      logger.debug("Actions parsed: " + Json.prettyPrint(parsed))
      val writer = new FileWriter(new File("/home/tomaszym/git/actions.json"))
      writer.write(Json.prettyPrint(parsed))
      writer.flush()

      parsed.validate[List[Action]] match {
        case s: JsSuccess[List[Action]] =>

          s.get
        case e: JsError =>
          val msg = JsError.toFlatJson(e).toString()
          logger.error("Json error while trying to parse a list of actions: " + msg)
          throw JsonParseErrorException(msg)
      }
    }
  }

  def getBoardCards(requestBuilder: GetBoardCards): Future[List[Card]] = {
    getStringResponse(requestBuilder).map { json =>
      val parsed = Json.parse(json)

      logger.debug("Cards parsed: " + Json.prettyPrint(parsed))

      parsed.validate[List[Card]] match {
        case s: JsSuccess[List[Card]] =>

          s.get
        case e: JsError =>
          val msg = JsError.toFlatJson(e).toString()
          logger.error("Json error while trying to parse a list of cards: " + msg)
          throw JsonParseErrorException(msg)
      }
    }
  }

  def getBoardChecklists(requestBuilder: GetBoardChecklists): Future[List[Checklist]] = {
    getStringResponse(requestBuilder).map { json =>
      val parsed = Json.parse(json)

      logger.debug("Checklists parsed: " + Json.prettyPrint(parsed))

      parsed.validate[List[Checklist]] match {
        case s: JsSuccess[List[Checklist]] =>

          s.get
        case e: JsError =>
          val msg = JsError.toFlatJson(e).toString()
          logger.error("Json error while trying to parse a list of Checklists: " + msg)
          throw JsonParseErrorException(msg)
      }
    }
  }


}

object TrelloHttpClient {

  case class JsonParseErrorException(s: String) extends RuntimeException
}