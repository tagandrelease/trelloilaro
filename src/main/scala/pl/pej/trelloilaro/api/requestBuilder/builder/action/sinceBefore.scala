package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.{RequestParam, RequestBuilder}
import pl.pej.trelloilaro.api.requestBuilder.builder.DateParam


trait ActionsSinceBuilder[T] { this: RequestBuilder[T] =>

  protected def actionsSinceParamName: String = "actions_since"
  
  def withActionsSince(params: ActionsSince) = withOnlyParam(actionsSinceParamName, params)
}

trait ActionsSince extends RequestParam

object ActionsSince {
  case object `null` extends ActionsSince
  case object lastView extends ActionsSince
  case class ActionsSinceDate(d: String) extends DateParam(d) with ActionsSince
}

trait ActionsBeforeBuilder[T] { this: RequestBuilder[T] =>
  
  protected def actionsBeforeParamName: String = "actions_before"
  
  
  def withActionsBefore(params: ActionBeforeParam) = withOnlyParam(actionsBeforeParamName, params)
}

trait ActionBeforeParam extends RequestParam

object ActionsBefore {
  case object `null` extends ActionBeforeParam
  case class ActionBeforeDate(d: String) extends DateParam(d) with ActionBeforeParam
}