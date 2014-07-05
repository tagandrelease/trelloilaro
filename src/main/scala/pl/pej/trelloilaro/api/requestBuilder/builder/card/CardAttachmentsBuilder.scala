package pl.pej.trelloilaro.api.requestBuilder.builder.card

import pl.pej.trelloilaro.api.requestBuilder.{AllRequestParam, RequestParam, RequestBuilder}

trait CardAttachmentsBuilder[T] { this: RequestBuilder[T] =>

  def withCardAttachments(attachment: Boolean) = withOnlyParam( "card_attachments", attachment)

  def withCardAttachmentsCoverOnly = withOnlyParam( "card_attachments", "cover")
}