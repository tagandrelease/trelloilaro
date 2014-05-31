package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{RequestParam, RequestBuilder}
import pl.pej.trelloilaro.api.request.builder.DateParam


trait SinceBuilder { this: RequestBuilder[_] =>

  def since(params: ActionSinceParam*) = withParams("action_since", params)
}

trait ActionSinceParam extends RequestParam

object Since {
  case object `null` extends ActionSinceParam
  case object lastView extends ActionSinceParam
  case class ActionSinceDate(d: String) extends DateParam(d) with ActionSinceParam
}

trait BeforeBuilder { this: RequestBuilder[_] =>

def before(params: ActionBeforeParam*) = withParams("action_before", params)
}

trait ActionBeforeParam extends RequestParam

object Before {
  case object `null` extends ActionBeforeParam
  case class ActionBeforeDate(d: String) extends DateParam(d) with ActionBeforeParam
}