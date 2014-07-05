package pl.pej.trelloilaro.httpclient

import spray.http._
import spray.client.pipelining._
import akka.actor.ActorSystem
import scala.concurrent.Future
import java.util.concurrent.TimeUnit
import spray.http.HttpHeaders.Host
import pl.pej.trelloilaro.api.requestBuilder.{RequestBuilder =>  TrelloRequestBuilder}

/** Spray-client based implementation.
  *
  * Provides String-Future[HttpRequest] interface.
  * RequestBuilder-DomainObject is realised in subclass.
  *
  * @param apiKey
  * @param accessToken
  * @param apiVersion
  */
abstract class TrelloAbstractHttpClient(val apiKey: String, val accessToken: Option[String] = None, val apiVersion: String = "1") {

  protected val requestPrefix = s"api.trello.com"

  implicit val system = ActorSystem("trello-web-client")
  implicit val timeout = new akka.util.Timeout(5, TimeUnit.SECONDS)

  import system.dispatcher

  protected val pipeline = setHostToTrello ~> sendReceive

  protected def setHostToTrello = { request: HttpRequest =>
    request.withEffectiveUri(true, Host(requestPrefix))
  }

  protected def formatRequest(path: String) = s"/$apiVersion/$path"

  protected def get[T](requestBuilder: TrelloRequestBuilder[TrelloRequestBuilder[_]]): Future[HttpResponse] = {

    val withToken = accessToken match {
      case Some(token) => requestBuilder.withKey(apiKey).withToken(token)
      case None => requestBuilder.withKey(apiKey)
    }
    pipeline(Get(formatRequest(withToken.toString)))
  }

}