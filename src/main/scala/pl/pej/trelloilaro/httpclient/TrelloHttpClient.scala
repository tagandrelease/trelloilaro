package pl.pej.trelloilaro.httpclient

import com.typesafe.scalalogging.LazyLogging
import muster.codec.jawn.JawnCodec
import spray.client.pipelining
import scala.concurrent.Future
import pl.pej.trelloilaro.api.requestBuilder.{RequestBuilder, GetBoard}
import pl.pej.trelloilaro.model.Board
import spray.http.{HttpCharsets, HttpCharset, HttpResponse}
import scala.concurrent.{ Future, ExecutionContext }
import akka.util.Timeout

/** Supports object oriented queires.
  *
  * Includes domain knowledge: binds RequestBuilder to model instance.
 */
class TrelloHttpClient(apiKey: String) extends TrelloAbstractHttpClient(apiKey) with LazyLogging {

  implicit val ec = ExecutionContext.Implicits.global

  protected def getStringResponse(requestBuilder: RequestBuilder[RequestBuilder[_]]): Future[String] ={
    get(requestBuilder).map{ response =>
      val str = response.entity.asString(HttpCharsets.`UTF-8`)

      logger.debug(str)
      str
    }
  }

  def getBoard(requestBuilder: GetBoard): Future[Board] = getStringResponse(requestBuilder).map(JawnCodec.as[Board](_))
}
