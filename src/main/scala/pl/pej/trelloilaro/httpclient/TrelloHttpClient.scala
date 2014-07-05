package pl.pej.trelloilaro.httpclient

import spray.client.pipelining
import scala.concurrent.Future
import pl.pej.trelloilaro.httpclient.serialization.TrelloJsonFormat
import pl.pej.trelloilaro.api.requestBuilder.GetBoard
import pl.pej.trelloilaro.model.Board
import spray.http.{HttpCharsets, HttpCharset, HttpResponse}
import spray.json._
import DefaultJsonProtocol._
import scala.concurrent.{ Future, ExecutionContext }
import akka.util.Timeout

/** Supports object oriented queires.
  *
  * Includes domain knowledge: binds RequestBuilder to model instance.
 */
class TrelloHttpClient(apiKey: String) extends TrelloAbstractHttpClient(apiKey) {

  def getBoard(requestBuilder: GetBoard): Future[Board] = {
    import TrelloJsonFormat._
    implicit val ec = ExecutionContext.Implicits.global

    val board: Future[Board] = get(requestBuilder).map{ response =>


      response.entity.asString(HttpCharsets.`UTF-8`).parseJson.convertTo[Board]

    }



    board
  }
}
