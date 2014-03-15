package pl.pej.trelloilaro.httpclient

import spray.http._
import spray.client.pipelining._
import akka.actor.ActorSystem
import scala.concurrent.Future
import java.util.concurrent.TimeUnit
import spray.http.HttpHeaders.Host

/** Spray-client based implementation.
  *
  * @param apiKey
  * @param accessToken
  * @param apiVersion
  */
class TrelloHttpClient(val apiKey: String, val accessToken: Option[String] = None, val apiVersion: String = "1") {

  /** Application key with optional access token */
  protected val requestSuffix = s"?key=$apiKey" + accessToken.map("&token="+ _).getOrElse("")

  protected val requestPrefix = s"api.trello.com"

  implicit val system = ActorSystem("trello-web-client")
  implicit val timeout = new akka.util.Timeout(5, TimeUnit.SECONDS)

  import system.dispatcher

  protected val pipeline = setHostToTrello ~> sendReceive

  protected def setHostToTrello = { request: HttpRequest =>
    request.withEffectiveUri(true, Host(requestPrefix))
  }

  protected def formatRequest(path: String) = s"/$apiVersion/$path$requestSuffix"

  private[trelloilaro] def get(path: String): Future[HttpResponse] = {
    pipeline(Get(formatRequest(path)))
  }

}
