package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{RequestParam, RequestBuilder}
import pl.pej.trelloilaro.api.request.builder.DateParam


trait ActionSinceBuilder { this: RequestBuilder =>

  def withActionSince(params: ActionSinceParam*) = cp(url, "action_since", params)
}

trait ActionSinceParam extends RequestParam

object ActionSinceBuilder {
  case object `null` extends ActionSinceParam
  case object lastView extends ActionSinceParam
  case class ActionSinceDate(d: String) extends DateParam(d) with ActionSinceParam
}

trait ActionBeforeBuilder { this: RequestBuilder =>

def withActionBefore(params: ActionBeforeParam*) = cp(url, "action_since", params)
}

trait ActionBeforeParam extends RequestParam

object ActionBeforeBuilder {
  case object `null` extends ActionBeforeParam
  case class ActionBeforeDate(d: String) extends DateParam(d) with ActionBeforeParam
}