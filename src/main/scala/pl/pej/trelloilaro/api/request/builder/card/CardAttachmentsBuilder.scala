package pl.pej.trelloilaro.api.request.builder.card

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait CardAttachmentsBuilder { this: RequestBuilder =>

  def withCardAttachments(attachment: Boolean) = cp(url, "card_attachments", attachment)

  def withCardAttachmentsCoverOnly = cp(url, "card_attachments", "cover")
}