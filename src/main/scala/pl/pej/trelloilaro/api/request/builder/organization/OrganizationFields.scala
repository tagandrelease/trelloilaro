package pl.pej.trelloilaro.api.request.builder.organization

import pl.pej.trelloilaro.api.request.{AllRequestParam, RequestParam, RequestBuilder}

trait OrganizationFieldsBuilder[T] { this: RequestBuilder[T] =>
  def withOrganizationFields(fields: OrganizationField *) = withParams("organization_fields", fields)
}

trait OrganizationField extends RequestParam

object OrganizationField {
  case object name extends OrganizationField
  case object displayName extends OrganizationField
  case object desc extends OrganizationField
  case object descData extends OrganizationField
  case object idBoards extends OrganizationField
  case object invited extends OrganizationField
  case object invitations extends OrganizationField
  case object memberships extends OrganizationField
  case object prefs extends OrganizationField
  case object powerUps extends OrganizationField
  case object products extends OrganizationField
  case object billableMemberCount extends OrganizationField
  case object url extends OrganizationField
  case object website extends OrganizationField
  case object logoHash extends OrganizationField
  case object premiumFeatures extends OrganizationField
}