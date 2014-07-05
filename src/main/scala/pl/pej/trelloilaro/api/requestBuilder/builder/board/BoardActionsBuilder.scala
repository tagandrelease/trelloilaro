package pl.pej.trelloilaro.api.requestBuilder.builder.board

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder
import pl.pej.trelloilaro.api.requestBuilder.builder.action.Actions

trait BoardActionsBuilder { this: RequestBuilder[_] =>

  /** Builder method
    *
    * @param actions the `ActionParam` list from ActionBuilder - it's the same
    * @return
    */
  def withBoardActions(actions: Actions *) = withParams("board_actions", actions)

}