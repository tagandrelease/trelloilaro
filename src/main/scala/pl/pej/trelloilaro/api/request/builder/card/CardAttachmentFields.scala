package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardAttachmentFieldsBuilder[T] { this: RequestBuilder[T] =>

  def withCardAttachmentFields(fields: CardAttachmentField *) = withParams("card_attachment_fields", fields)

}

trait CardAttachmentField  extends RequestParam

object CardAttachmentField {
  case object all extends CardAttachmentField with AllRequestParam
  case object bytes extends CardAttachmentField
  case object date extends CardAttachmentField
  case object edgeColor extends CardAttachmentField
  case object idMember extends CardAttachmentField
  case object isUpload extends CardAttachmentField
  case object mimeType extends CardAttachmentField
  case object name extends CardAttachmentField
  case object previews extends CardAttachmentField
  case object url extends CardAttachmentField
}