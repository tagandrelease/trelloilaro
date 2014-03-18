package pl.pej.trelloilaro.api.request

import pl.pej.trelloilaro.api.request.builder.board.{BoardsBuilder, BoardFieldsBuilder}
import pl.pej.trelloilaro.api.request.builder.card._
import pl.pej.trelloilaro.api.request.builder.action._

/** One possible value for an argument.
  *
  * eg: https://api.(...)list_fields=name&fields=name,desc&key=(...)
  * the RequestParams are name and desc
  *
  */
trait RequestParam
trait AllRequestParam

/** Builder for the requests. Accumulates the request string.
  * @param url currently stored formated arguments
  *
  * TODO: store unformatted args and format on final call
  */
case class RequestBuilder(url: String) extends BoardBuilders with CardBuilders with ActionBuilders {
  override def toString: String = url
}

trait BoardBuilders extends BoardFieldsBuilder with BoardsBuilder { this: RequestBuilder => }
trait CardBuilders extends CardAttachmentFieldsBuilder with CardAttachmentsBuilder with CardFieldsBuilder with CardMemberFieldsBuilder with CardsBuilder with CardStickersBuilder { this: RequestBuilder => }
trait ActionBuilders extends ActionFieldsBuilder with ActionBuilder with ActionsEntitiesRequestBuilder with ActionBeforeBuilder with ActionSinceBuilder with ActionsLimitBuilder { this: RequestBuilder => }

object RequestBuilder {

  RequestBuilder("asdf").withAction()

  /** Constructor for standard enumeration
    *
    * @param url url prefix
    * @param argument api argument name
    * @param params enumerations for the value
    * @return
    */
  def apply(url: String, argument: String, params: Seq[RequestParam]): RequestBuilder = {

    val argumentList =
      if(params.exists(p => p.isInstanceOf[AllRequestParam])) "all"
      else params.distinct.mkString(",")

    RequestBuilder(s"$url&$argument=$argumentList")
  }

  def apply(url: String, argument: String, value: Boolean): RequestBuilder = RequestBuilder(s"$url&$argument=${value.toString}")
  def apply(url: String, argument: String, value: Int): RequestBuilder = RequestBuilder(s"$url&$argument=${value.toString}")
  def apply(url: String, argument: String, value: String): RequestBuilder = RequestBuilder(s"$url&$argument=${value}")
}
