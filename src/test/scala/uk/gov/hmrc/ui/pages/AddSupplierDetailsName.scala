package uk.gov.hmrc.ui.pages

import uk.gov.hmrc.ui.data.TestData

object AddSupplierDetailsName extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/1/supplier-name"

  def verifyPageDisplayed(): Unit =
    verifyStandardPageHeading(
      expectedHeading = "What is the supplier’s name?"
    )

  // TODO: Again code not DRY and also could use different data
  def inputUserDetails(): Unit = {
    typeInsideElement(
      Locators.title,
      TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.title
    )
    typeInsideElement(
      Locators.firstName,
      TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.firstName
    )
    typeInsideElement(
      Locators.lastName,
      TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.lastName
    )
    clickContinue()
  }
}
