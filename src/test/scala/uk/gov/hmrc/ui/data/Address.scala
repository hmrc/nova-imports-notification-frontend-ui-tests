package uk.gov.hmrc.ui.data

final case class Address(
                        line1: String,
                        line2: String,
                        line3: Option[String],
                        line4: Option[String],
                        postcode: Option[String],
                        country: Option[String]
                        )
