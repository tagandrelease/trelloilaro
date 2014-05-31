package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardStickersBuilder { this: RequestBuilder[_] =>

  def withCardStickers(stickersAllowed: Boolean) = withParam("card_stickers", stickersAllowed)
}