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
abstract class RequestBuilder  { this: { def copy(s: String): RequestBuilder } =>
  def url: String
  override def toString: String = url

  /** Constructor for standard enumeration
    *
    * @param url url prefix
    * @param argument api argument name
    * @param params enumerations for the value
    * @return
    */
  def cp(url: String, argument: String, params: Seq[RequestParam]): RequestBuilder = {

    val argumentList =
      if(params.exists(p => p.isInstanceOf[AllRequestParam])) "all"
      else params.distinct.mkString(",")

    copy(s"$url&$argument=$argumentList")
  }

  def cp(url: String, argument: String, value: Boolean): RequestBuilder = copy(s"$url&$argument=${value.toString}")
  def cp(url: String, argument: String, value: Int): RequestBuilder = copy(s"$url&$argument=${value.toString}")
  def cp(url: String, argument: String, value: String): RequestBuilder = copy(s"$url&$argument=${value}")
}

case class BoardRequestBuilder(url: String) extends RequestBuilder with BoardFieldsBuilder with BoardsBuilder
case class CardRequestBuilder(url: String) extends RequestBuilder with CardAttachmentFieldsBuilder with CardAttachmentsBuilder with CardFieldsBuilder with CardMemberFieldsBuilder with CardsBuilder with CardStickersBuilder
case class ActionRequestBuilder(url: String) extends RequestBuilder with ActionFieldsBuilder with ActionBuilder with ActionsEntitiesRequestBuilder with ActionBeforeBuilder with ActionSinceBuilder with ActionsLimitBuilder

object RequestBuilder {

}
