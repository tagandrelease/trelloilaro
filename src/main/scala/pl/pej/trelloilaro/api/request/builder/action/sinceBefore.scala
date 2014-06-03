package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{RequestParam, RequestBuilder}
import pl.pej.trelloilaro.api.request.builder.DateParam


trait ActionSinceBuilder[T] { this: RequestBuilder[T] =>

  def withActionsSince(params: ActionSinceParam) = withOnlyParam("actions_since", params)
}

trait ActionSinceParam extends RequestParam

object ActionSince {
  case object `null` extends ActionSinceParam
  case object lastView extends ActionSinceParam
  case class ActionSinceDate(d: String) extends DateParam(d) with ActionSinceParam
}

//trait ActionBeforeBuilder[T] { this: RequestBuilder[T] =>
//
//def withActionBefore(params: ActionBeforeParam) = withOnlyParam("action_before", params)
//}
//
//trait ActionBeforeParam extends RequestParam
//
//object ActionBefore {
//  case object `null` extends ActionBeforeParam
//  case class ActionBeforeDate(d: String) extends DateParam(d) with ActionBeforeParam
//}