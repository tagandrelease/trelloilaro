package pl.pej.trelloilaro.api.requestBuilder.builder.action

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait ActionPageBuilder[T] { this: RequestBuilder[T] =>

  def withPage(page: Int) = {
    if(page < 0 || page > 1000) throw new IllegalArgumentException("Page for page must fit in inclusively between 0 and 1000")

    withOnlyParam("page", page)
  }

}
