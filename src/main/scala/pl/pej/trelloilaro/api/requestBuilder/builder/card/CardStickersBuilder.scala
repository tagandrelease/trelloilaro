package pl.pej.trelloilaro.api.requestBuilder.builder.card

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait CardStickersBuilder[T] { this: RequestBuilder[T] =>

  def withCardStickers(stickersAllowed: Boolean) = withOnlyParam("card_stickers", stickersAllowed)
}