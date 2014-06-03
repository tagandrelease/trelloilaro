package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait BoardStarsBuilder[T] { this: RequestBuilder[T] =>

  def withBoardStars(value: Boolean) = withOnlyParam("board_stars", value)
}