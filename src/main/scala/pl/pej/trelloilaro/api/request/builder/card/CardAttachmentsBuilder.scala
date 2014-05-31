package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardAttachmentsBuilder { this: RequestBuilder[_] =>

  def withCardAttachments(attachment: Boolean) = withParam( "card_attachments", attachment)

  def withCardAttachmentsCoverOnly = withParam( "card_attachments", "cover")
}