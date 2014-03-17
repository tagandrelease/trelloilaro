package pl.pej.trelloilaro.api.request

/** One possible value for an argument.
  *
  * eg: https://api.(...)list_fields=name&fields=name,desc&key=(...)
  * the RequestParams are name and desc
  *
  */
trait RequestParam

/** Builder for the requests. Accumulates the request string.
  * @param url currently stored formated arguments
  *
  * TODO: store unformatted args and format on final call
  */
case class RequestBuilder(url: String) {
  override def toString: String = url
}



object RequestBuilder {
  def apply(url: String, argument: String, params: Seq[RequestParam]): RequestBuilder = RequestBuilder(s"$url&$argument=${params.distinct.mkString(",")}")
}
