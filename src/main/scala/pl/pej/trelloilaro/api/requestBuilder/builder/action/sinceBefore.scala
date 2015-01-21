package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.{RequestParam, RequestBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.DateParam


trait SinceBuilder[T] { this: RequestBuilder[T] =>

  protected def sinceParamName: String = "since"
  
  def since(params: Since) = withOnlyParam(sinceParamName, params)
}

trait Since extends RequestParam

object Since {
  case object `null` extends Since

  /** Supported in board/id
    * Not supported in board/id/cards */
//  case object lastView extends Since
  case class SinceDate(d: String) extends DateParam(d) with Since
}

trait BeforeBuilder[T] { this: RequestBuilder[T] =>
  
  protected def beforeParamName: String = "before"
  
  
  def before(params: Before) = withOnlyParam(beforeParamName, params)
}

trait Before extends RequestParam

object Before {
  case object `null` extends Before
  case class BeforeDate(d: String) extends DateParam(d) with Before
}