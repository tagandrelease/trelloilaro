package pl.pej.trelloilaro.api.requestBuilder.builder.action
import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder

trait ActionMemberCreatorBuilder[T] { this: RequestBuilder[T] =>

  def withActionMemberCreator(value: Boolean) = withOnlyParam("action_memberCreator", value)
}