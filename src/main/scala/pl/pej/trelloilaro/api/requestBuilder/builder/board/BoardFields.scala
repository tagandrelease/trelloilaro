package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait BoardFieldsBuilder[T] { this: RequestBuilder[T] =>

  /** "fields" or "board_fields" depending on method
    */
  def boardFieldsParamName: String = "board_fields"

  def withBoardFields(fields: BoardField *) = withParams(boardFieldsParamName, fields)

}

trait BoardField extends RequestParam

object BoardField {
  case object all extends BoardField with AllRequestParam
  case object name extends BoardField
  case object desc extends BoardField
  case object descData extends BoardField
  case object closed extends BoardField
  case object idOrganization extends BoardField
  case object invited extends BoardField
  case object pinned extends BoardField
  case object starred extends BoardField
  case object url extends BoardField
  case object prefs extends BoardField
  case object invitations extends BoardField
  case object memberships extends BoardField
  case object shortLink extends BoardField
  case object subscribed extends BoardField
  case object labelNames extends BoardField
  case object powerUps extends BoardField
  case object dateLastActivity extends BoardField
  case object dateLastView extends BoardField
  case object shortUrl extends BoardField

}