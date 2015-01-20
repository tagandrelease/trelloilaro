package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait ActionIdModelsBuilder[T] { this: RequestBuilder[T] =>

  def withActionIdModels(id: ActionIdModels.Id) = withOnlyParam("idModels", id.stringId)
}

object ActionIdModels {

  case class Id(stringId: String)
  
}