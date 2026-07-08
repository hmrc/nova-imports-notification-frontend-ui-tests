package uk.gov.hmrc.ui.data

import uk.gov.hmrc.ui.models.UserDetails.{BusinessDetails, IndividualUserDetails}
import uk.gov.hmrc.ui.models.{Notifier, Supplier}

object TestData {
  object NotifierDetails {
    val notifier = Notifier.NotifierDetails(
      userDetails = IndividualUserDetails(
        title = "Mr",
        firstName = "John",
        lastName = "Smith"
      ),
      phoneNumber = None,
      mobileNumber = Some("07700 900999"),
      email = "john.smith@example.com"
    )
  }

  object SupplierDetails {
    val businessSupplier = Supplier.BusinessSupplier(
      userDetails = BusinessDetails(
        businessName = "Test Company Ltd"
      )
    )

    val individualSupplier = Supplier.IndividualSupplier(
      userDetails = IndividualUserDetails(
        title = "Mrs",
        firstName = "Jane",
        lastName = "Smith"
      )
    )
  }
}
