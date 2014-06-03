package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardsBuilder[T] { this: RequestBuilder[T] =>

  def withCards(card: Card) = withOnlyParam("cards", card)

}

trait Card extends RequestParam

object Card {
  case object all extends Card
  case object none extends Card
  case object visible extends Card
  case object open extends Card
  case object closed extends Card
}