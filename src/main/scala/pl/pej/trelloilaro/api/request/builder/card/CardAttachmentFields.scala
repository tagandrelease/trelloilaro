package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardAttachmentFieldsBuilder { this: RequestBuilder[_] =>

  def withCardAttachmentFields(fields: CardAttachmentFieldsParam *) = withParams("card_attachment_fields", fields)

}

trait CardAttachmentFieldsParam extends RequestParam

object CardAttachmentFieldsRequestBuilder {
  case object all extends CardAttachmentFieldsParam with AllRequestParam
  case object bytes extends CardAttachmentFieldsParam
  case object date extends CardAttachmentFieldsParam
  case object edgeColor extends CardAttachmentFieldsParam
  case object idMember extends CardAttachmentFieldsParam
  case object isUpload extends CardAttachmentFieldsParam
  case object mimeType extends CardAttachmentFieldsParam
  case object name extends CardAttachmentFieldsParam
  case object previews extends CardAttachmentFieldsParam
  case object url extends CardAttachmentFieldsParam
}