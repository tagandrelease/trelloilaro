trelloilaro
===========

Extensions for Trello to be used by Polish Esperanto-Youth 

The goal is to create a type safe interface for which IDE would be able to provide well support.

```scala
  test("/boards/[board_id] with token, key and some actions") {
    val builder = GetBoard(boardId).withToken("1234").withKey("5678").actions(Actions.addAttachmentToCard, Actions.addChecklistToCard).actions(Actions.addAttachmentToCard)
    assert(builder.toString === s"/1/boards/$boardId?actions=addAttachmentToCard,addChecklistToCard&key=5678&token=1234")
  }
```
