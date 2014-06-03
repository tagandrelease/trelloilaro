package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.RequestBuilder

trait ActionsLimitBuilder[T] { this: RequestBuilder[T] =>

  def withLimit(limit: Int) = {
    if(limit < 0 || limit > 1000) throw new IllegalArgumentException("Limit for actions_limit must fit in inclusively between 0 and 1000")

    withOnlyParam( "actions_limit", limit)
  }

}
