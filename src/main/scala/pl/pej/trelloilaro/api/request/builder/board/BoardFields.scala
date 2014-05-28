package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait BoardFieldsBuilder { this: RequestBuilder =>

  def withBoardFields(fields: BoardFieldsParam *) = cp(url, "board_fields", fields)

}

trait BoardFieldsParam extends RequestParam

object BoardFieldsRequestBuilder {
  case object all extends BoardFieldsParam with AllRequestParam
  case object name extends BoardFieldsParam
  case object desc extends BoardFieldsParam
  case object descData extends BoardFieldsParam
  case object closed extends BoardFieldsParam
  case object idOrganization extends BoardFieldsParam
  case object invited extends BoardFieldsParam
  case object pinned extends BoardFieldsParam
  case object starred extends BoardFieldsParam
  case object url extends BoardFieldsParam
  case object prefs extends BoardFieldsParam
  case object invitations extends BoardFieldsParam
  case object memberships extends BoardFieldsParam
  case object shortLink extends BoardFieldsParam
  case object subscribed extends BoardFieldsParam
  case object labelNames extends BoardFieldsParam
  case object powerUps extends BoardFieldsParam
  case object dateLastActivity extends BoardFieldsParam
  case object dateLastView extends BoardFieldsParam
  case object shortUrl extends BoardFieldsParam

}