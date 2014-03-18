package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{RequestParam, RequestBuilder}

trait ActionsEntitiesRequestBuilder{ this: RequestBuilder =>

  def withActionsEntities(value: Boolean) = RequestBuilder(url, "action", value)

}
