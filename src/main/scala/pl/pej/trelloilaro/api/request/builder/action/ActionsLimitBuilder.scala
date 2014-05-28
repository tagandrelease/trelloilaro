package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.RequestBuilder

trait ActionsLimitBuilder { this: RequestBuilder =>

  def withActionsLimit(limit: Int): RequestBuilder = {
    if(limit < 0 || limit > 1000) throw new IllegalArgumentException("Limit for actions_limit must fit in inclusively between 0 and 1000")

    cp(url, "actions_limit", limit)
  }

}
