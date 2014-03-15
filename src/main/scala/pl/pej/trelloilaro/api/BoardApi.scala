package pl.pej.trelloilaro.api

import pl.pej.trelloilaro.httpclient.TrelloHttpClient

trait BoardApi { this: TrelloHttpClient =>

  def getBoard = get("board")

}
