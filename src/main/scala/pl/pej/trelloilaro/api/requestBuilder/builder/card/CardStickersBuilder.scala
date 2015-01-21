package pl.pej.trelloilaro.api.requestBuilder.builder.card

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait CardStickersBuilder[T] { this: RequestBuilder[T] =>

  def stickersParamName = "card_stickers"
  def withCardStickers(stickersAllowed: Boolean) = withOnlyParam(stickersParamName, stickersAllowed)
}