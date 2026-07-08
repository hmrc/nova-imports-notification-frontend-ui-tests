package uk.gov.hmrc.ui.models

object FullAddress {
  case class FullAddressDetails(
                               line1: String,
                               line2: String,
                               line3: Option[String],
                               line4: Option[String],
                               postcode: Option[String],
                               country: Option[String]
                               )
}
