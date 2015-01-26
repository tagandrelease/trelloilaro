package pl.pej.trelloilaro.api.requestBuilder

import java.net.URLEncoder

import pl.pej.trelloilaro.api.requestBuilder.builder.board.{BoardsBuilder, BoardFieldsBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.card._
import pl.pej.trelloilaro.api.requestBuilder.builder.action._

/** One possible value for an argument.
  *
  * eg: https://api.(...)list_fields=name&fields=name,desc&key=(...)
  * the RequestParams are name and desc
  *
  */
trait RequestParam
trait AllRequestParam

/** Builder for the requests. Accumulates the requestBuilder string.
  *
  */
abstract class RequestBuilder[+T](params: Map[String, List[String]]) {

  def httpMethod: HttpMethod

  override def toString: String = prefix + "?" + params.map{ case (k,v) =>

    s"$k=${v.map(URLEncoder.encode(_,"UTF-8")).mkString(",")}"
  }.toList.sorted.mkString("&")

  def construct(value: Map[String, List[String]]): T

  def prefix: String

  def withToken(token: String): T = withParam("token", token)
  def withKey(key: String): T = withParam("key", key)

//  protected def withParam(paramName: String, value: Boolean): T = withParam(paramName, value.toString)
//  protected def withParam(paramName: String, value: Int): T = withParam(paramName, value.toString)
  protected def withParam(paramName: String, value: String): T = withStringParam(paramName, List(value))

  protected def withParams(paramName: String, values: Seq[RequestParam]): T = {

    val stringValues =
      if(values.exists(p => p.isInstanceOf[AllRequestParam])) List("all")
      else values.distinct.map(_.toString)

    withStringParam(paramName, stringValues)
  }

  /** Appends more comma separated params
    *
    * @param paramName
    * @param values
    * @return
    */
  private def withStringParam(paramName: String, values: Seq[String]): T = {

    val oldParams = params.get(paramName)

    val newParams: List[String] = oldParams match {
      case None => values.toList

      case Some(old) => // need to join params
        (old ++ values).distinct.sorted
    }

    construct(params.updated(paramName, newParams))
  }


  protected def withOnlyParam(paramName: String, value: RequestParam): T = withOnlyParam(paramName, value.toString)
  protected def withOnlyParam(paramName: String, value: Int): T = withOnlyParam(paramName, value.toString)
  protected def withOnlyParam(paramName: String, value: Boolean): T = withOnlyParam(paramName, value.toString)

  /** Leaves only the new parameter
    *
    * @param paramName
    * @param value
    * @return
    */
  protected def withOnlyParam(paramName: String, value: String): T = {
    construct(params.updated(paramName, value::Nil))
  }

}

//case class CardRequestBuilder(base: String, params: Map[String, List[String]], suffix: String) extends RequestBuilder[CardRequestBuilder](base, params, suffix)
//           with CardAttachmentFieldsBuilder with CardAttachmentsBuilder with CardFieldsBuilder with CardMemberFieldsBuilder with CardsBuilder with CardStickersBuilder {
//  def construct(prefix: String, params: Map[String,List[String]], suffix: String) = CardRequestBuilder(prefix, params, suffix)
//}
//case class ActionRequestBuilder(base: String, params: Map[String, List[String]], suffix: String) extends RequestBuilder[ActionRequestBuilder](base, params, suffix)
//           with FieldBuilder with ActionBuilder with EntitiesBuilder with BeforeBuilder with SinceBuilder with LimitBuilder{
//  def construct(prefix: String, params: Map[String,List[String]], suffix: String) = ActionRequestBuilder(prefix, params, suffix)
//}