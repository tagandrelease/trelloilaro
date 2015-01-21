package pl.pej.trelloilaro.api.requestBuilder.builder.card

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait CardAttachmentsBuilder[T] { this: RequestBuilder[T] =>

  def attachmentsParamName: String = "card_attachments"

  def withCardAttachments(attachment: Boolean) = withOnlyParam( attachmentsParamName, attachment)

  def withCardAttachmentsCoverOnly = withOnlyParam(attachmentsParamName, "cover")
}