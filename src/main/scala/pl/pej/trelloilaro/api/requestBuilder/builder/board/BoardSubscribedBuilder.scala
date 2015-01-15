package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder


trait BoardSubscribedBuilder[T] { this: RequestBuilder[T] =>

  def withBoardSubscribed(subscribed: Boolean) = withOnlyParam("subscribed", subscribed)
}
