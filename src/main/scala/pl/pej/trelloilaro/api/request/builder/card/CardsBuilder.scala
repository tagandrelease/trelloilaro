package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardsBuilder {
  this: RequestBuilder[_] =>

  def withCards(card: CardsParam) = withParams("cards", card::Nil)

}

trait CardsParam extends RequestParam

object CardsRequestBuilder {
  case object all extends CardsParam
  case object none extends CardsParam
  case object visible extends CardsParam
  case object open extends CardsParam
  case object closed extends CardsParam
}