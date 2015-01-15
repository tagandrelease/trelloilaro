package pl.pej.trelloilaro.api.serialization

import org.scalatest.FunSuite

class SerializationSuite extends FunSuite with SerializationBase with BoardTestData {

  test("Deserialize minimal Board") {

    val board = deserializeBoard(BoardTestDataMinimal.json)
    assert(board === BoardTestDataMinimal.example)
  }

  test("Deserialize primitive-fields-only Board") {

    val board = deserializeBoard(BoardTestDataPrimitiveFields.json)
    assert(board === BoardTestDataPrimitiveFields.example)
  }

}
