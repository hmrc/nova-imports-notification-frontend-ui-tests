package uk.gov.hmrc.ui.models

object PostcodeAddress {
  case class PostcodeAddressDetails(
                                   postcode: String,
                                   houseNameOrNumber: Option[String]
                                   )
}
