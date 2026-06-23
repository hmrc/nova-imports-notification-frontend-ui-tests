package uk.gov.hmrc.ui.data

object TestData {
  val manualUkAddress: Address = Address(
    line1 = "",
    line2 = "",
    line3 = None,
    line4 = None,
    postcode = None,
    country = Some("GB")
  )

  object UkUser {
    val user: User = User(
      title = "Mr",
      firstName = "John",
      lastName = "Smith",
      address = manualUkAddress,
      landline = None,
      telephone = Some("07700 900999"),
      email = "john.smith@example.com"
    )
  }
}
