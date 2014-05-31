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
  *
  * TODO: store unformatted args and format on final call
  */
abstract class RequestBuilder[T](prefix: String, params: Map[String, List[String]])  { this: { def construct(param: String, value: Map[String, List[String]]): T} =>

  override def toString: String = prefix + "&" + params.map{ case (k,v) =>
    s"$k=${v.mkString(",")}"
  }.toList.sorted.mkString("&")


  def withParam(paramName: String, value: Boolean): T = withParam(paramName, value.toString)
  def withParam(paramName: String, value: Int): T = withParam(paramName, value.toString)
  def withParam(paramName: String, value: String): T = withStringParam(paramName, List(value))

  def withParams(paramName: String, values: Seq[RequestParam]): T = {

    val stringValues =
      if(values.exists(p => p.isInstanceOf[AllRequestParam])) List("all")
      else values.distinct.map(_.toString)

    withStringParam(paramName, stringValues)
  }

  //TODO rename
  private def withStringParam(paramName: String, values: Seq[String]): T = {

    val oldParams = params.get(paramName)

    val newParams: List[String] = oldParams match {
      case None => values.toList

      case Some(old) => // need to join params
        (old ++ values).distinct.sorted
    }

    construct(prefix, params.updated(paramName, newParams))
  }
}

case class BoardRequestBuilder(prefix: String, params: Map[String, List[String]]) extends RequestBuilder[BoardRequestBuilder](prefix, params)
            with BoardFieldsBuilder with BoardsBuilder {
  def construct(prefix: String, params: Map[String,List[String]]) = BoardRequestBuilder(prefix, params)
}
case class CardRequestBuilder(prefix: String, params: Map[String, List[String]]) extends RequestBuilder[CardRequestBuilder](prefix, params)
           with CardAttachmentFieldsBuilder with CardAttachmentsBuilder with CardFieldsBuilder with CardMemberFieldsBuilder with CardsBuilder with CardStickersBuilder {
  def construct(prefix: String, params: Map[String,List[String]]) = CardRequestBuilder(prefix, params)
}
case class ActionRequestBuilder(prefix: String, params: Map[String, List[String]]) extends RequestBuilder[ActionRequestBuilder](prefix, params)
           with FieldBuilder with ActionBuilder with EntitiesBuilder with BeforeBuilder with SinceBuilder with LimitBuilder{
  def construct(prefix: String, params: Map[String,List[String]]) = ActionRequestBuilder(prefix, params)
}
