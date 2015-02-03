package pl.pej.trelloilaro.api.serialization

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.data._
import pl.pej.trelloilaro.api.model.{ChecklistJson, CardJson}

class SerializationSuite extends FunSuite with SerializationBase with GetBoardTestData
  with GetBoardActionsTestData with GetBoardCardsTestData with GetBoardChecklistsTestData
  with GetBoardListsTestData {

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
  test("Deserialize primitive fields + badges Board Cards") {
    val cards: List[CardJson] = deserializeCards(BoardCardsTestDataPrimitiveFields.json)
    assert(cards === BoardCardsTestDataPrimitiveFields.example)
  }

  test("Deserialize checklists without cards") {
    val cards: List[ChecklistJson] = deserializeChecklists(BoardChecklistsTestData.json)
    assert(cards === BoardChecklistsTestData.example)
  }

  test("Deserialize Board Lists id only") {
    val lists = deserializeLists(BoardListsTestDataMinimal.json)
    assert(lists === BoardListsTestDataMinimal.example)
  }
  test("Deserialize full Board Lists") {
    val lists = deserializeLists(BoardListsTestData.json)
    assert(lists === BoardListsTestData.example)
  }
}
