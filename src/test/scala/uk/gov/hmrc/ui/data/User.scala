package uk.gov.hmrc.ui.data

final case class User(
                     title: String,
                     firstName: String,
                     lastName: String,
                     address: Address,
                     landline: Option[String],
                     telephone: Option[String],
                     email: String
                     )
