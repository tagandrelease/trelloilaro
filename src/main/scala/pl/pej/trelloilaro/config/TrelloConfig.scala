package pl.pej.trelloilaro.config

import com.typesafe.config.ConfigFactory
import net.ceedubs.ficus.FicusConfig._

case class Keys(appKey: String)
case class TrelloConfig(keys: Keys)

object TrelloConfig {
  def load = ConfigFactory.load("trello.conf").as[TrelloConfig]("trello")
}

