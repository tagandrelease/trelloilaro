package pl.pej.trelloilaro.api.request.builder.action

import pl.pej.trelloilaro.api.request.{ActionRequestBuilder, RequestParam, RequestBuilder}

trait ActionsEntitiesRequestBuilder{ this: RequestBuilder =>

  def withActionsEntities(value: Boolean) = cp(url, "entities", value)

}
