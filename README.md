trelloilaro
===========

Trello API Scala interface. Type safe & IDE support.

Example test:

```scala
  test("/boards/[board_id] with token, key and some actions") {
    val builder = GetBoard(boardId).withToken("1234").withKey("5678").actions(Actions.addAttachmentToCard, Actions.addChecklistToCard).actions(Actions.addAttachmentToCard)
    assert(builder.toString === s"/1/boards/$boardId?actions=addAttachmentToCard,addChecklistToCard&key=5678&token=1234")
  }
```
