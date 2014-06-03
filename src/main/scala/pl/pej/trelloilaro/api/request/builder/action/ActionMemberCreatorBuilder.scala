package pl.pej.trelloilaro.api.request.builder.action
import pl.pej.trelloilaro.api.request.RequestBuilder

trait ActionMemberCreatorBuilder[T] { this: RequestBuilder[T] =>

  def withActionMemberCreator(value: Boolean) = withOnlyParam("action_memberCreator", value)
}