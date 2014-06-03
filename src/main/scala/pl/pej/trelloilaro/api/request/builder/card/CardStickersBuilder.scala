package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardStickersBuilder[T] { this: RequestBuilder[T] =>

  def withCardStickers(stickersAllowed: Boolean) = withOnlyParam("card_stickers", stickersAllowed)
}