package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait ActionsLimitBuilder[T] { this: RequestBuilder[T] =>

  protected def actionsLimitParamName: String = "actions_limit"

  def withActionsLimit(limit: Int) = {
    if(limit < 0 || limit > 1000) throw new IllegalArgumentException("Limit for actions_limit must fit in inclusively between 0 and 1000")

    withOnlyParam(actionsLimitParamName, limit)
  }

}
