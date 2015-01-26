package pl.pej.trelloilaro.api.serialization

import org.scalatest.FunSuite
import pl.pej.trelloilaro.api.data.{GetBoardChecklistsTestData, GetBoardCardsTestData, GetBoardActionsTestData, GetBoardTestData}
import pl.pej.trelloilaro.model.{Checklist, Card}

class SerializationSuite extends FunSuite with SerializationBase with GetBoardTestData
  with GetBoardActionsTestData with GetBoardCardsTestData with GetBoardChecklistsTestData {

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
    val cards: List[Card] = deserializeCards(BoardCardsTestDataPrimitiveFields.json)
    assert(cards === BoardCardsTestDataPrimitiveFields.example)
  }

  test("Deserialize checklists without cards") {
    val cards: List[Checklist] = deserializeChecklists(BoardChecklistsTestData.json)
    assert(cards === BoardChecklistsTestData.example)
  }

}
