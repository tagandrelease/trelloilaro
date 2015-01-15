package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder


trait BoardClosedBuilder[T] { this: RequestBuilder[T] =>

  def withBoardClosed(closed: Boolean) = withOnlyParam("closed", closed)
}
