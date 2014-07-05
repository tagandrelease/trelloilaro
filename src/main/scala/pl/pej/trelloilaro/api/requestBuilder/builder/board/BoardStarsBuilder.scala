package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait BoardStarsBuilder[T] { this: RequestBuilder[T] =>

  def withBoardStars(value: Boolean) = withOnlyParam("board_stars", value)
}