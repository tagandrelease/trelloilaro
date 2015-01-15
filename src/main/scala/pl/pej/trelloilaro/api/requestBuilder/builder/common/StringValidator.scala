package pl.pej.trelloilaro.api.requestBuilder.builder.common

import pl.pej.trelloilaro.api.requestBuilder.RequestBuilder


case class ValueTooShortException(min: Int) extends IllegalArgumentException(s"Value too short. Minimal length: $min.")
case class ValueTooLongException(max: Int) extends IllegalArgumentException(s"Value too long. Max length: $max.")

trait StringValidator[T] { this: RequestBuilder[T] =>

  def withOnlyParamValidated(paramName: String, value: String, minLength: Int = 0, maxLength: Int = 16384) = {
    if(value.length < minLength) throw ValueTooShortException(minLength)

    if(value.length > maxLength) throw ValueTooLongException(maxLength)

    withOnlyParam(paramName, value)
  }

}