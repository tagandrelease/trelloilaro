package pl.pej.trelloilaro.api.serialization

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.data.{GetBoardActionsTestData, GetBoardTestData}

class SerializationSuite extends FunSuite with SerializationBase with GetBoardTestData with GetBoardActionsTestData {

  test("Deserialize minimal Board") {

    val board = deserializeBoard(BoardTestDataMinimal.json)
    assert(board === BoardTestDataMinimal.example)
  }

  test("Deserialize primitive-fields-only Board") {

    val board = deserializeBoard(BoardTestDataPrimitiveFields.json)
    assert(board === BoardTestDataPrimitiveFields.example)
  }

  test("Deserialize minimal Board Actions") {
    val actions = deserializeActions(BoardActionsTestDataMinimal.json)
    assert(actions === BoardActionsTestDataMinimal.example)
  }

}
