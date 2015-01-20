package pl.pej.trelloilaro.api.requestBuilder.builder.action
import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait ActionMemberCreatorBuilder[T] { this: RequestBuilder[T] =>

  protected def actionMemberCreatorParamName: String = "action_memberCreator"

  def withActionMemberCreator(value: Boolean) = withOnlyParam(actionMemberCreatorParamName, value)
}