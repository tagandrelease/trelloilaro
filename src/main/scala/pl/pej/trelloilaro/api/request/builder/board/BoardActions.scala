package pl.pej.trelloilaro.api.request.builder.board

import pl.pej.trelloilaro.api.request.RequestBuilder
import pl.pej.trelloilaro.api.request.builder.action.ActionParam

trait BoardActionsBuilder { this: RequestBuilder[_] =>

  /** Builder method
    *
    * @param actions the `ActionParam` list from ActionBuilder - it's the same
    * @return
    */
  def withBoardActions(actions: ActionParam *) = withParams("board_actions", actions)

}