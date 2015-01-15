package pl.pej.trelloilaro.api.requestBuilder

sealed abstract class HttpMethod

case object GET extends HttpMethod
case object PUT extends HttpMethod
case object POST extends HttpMethod
case object DELETE extends HttpMethod
