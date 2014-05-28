package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardStickersBuilder { this: RequestBuilder =>

  def withCardStickers(stickersAllowed: Boolean) = cp(url, "card_stickers", stickersAllowed)
}