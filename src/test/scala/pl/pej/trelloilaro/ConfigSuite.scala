package pl.pej.trelloilaro

import com.typesafe.config.ConfigFactory
import java.io.File
import net.ceedubs.ficus.FicusConfig._
import pl.pej.trelloilaro.config.TrelloConfig
import org.scalatest.FunSuite


class ConfigSuite extends FunSuite {

  test("Trello config as object") {

    val config = TrelloConfig.load

    println(config)
    assert(config.keys.appKey.size > 0)
  }
}
