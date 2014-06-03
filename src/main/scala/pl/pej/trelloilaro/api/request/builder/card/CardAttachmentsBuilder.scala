package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardAttachmentsBuilder { this: RequestBuilder[_] =>

  def withCardAttachments(attachment: Boolean) = withOnlyParam( "card_attachments", attachment)

  def withCardAttachmentsCoverOnly = withOnlyParam( "card_attachments", "cover")
}