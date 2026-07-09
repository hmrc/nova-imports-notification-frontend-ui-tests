package uk.gov.hmrc.ui.pages

import uk.gov.hmrc.ui.data.TestData

object AddPurchaserDetailsBusinessName extends BasePage {
  override val pageUrl: String = s"$baseUrl/purchaser-business-name"

  def verifyPageDisplayed(): Unit =
    verifyInputPageHeading(
      expectedHeading = "What is the purchaser’s business name?"
    )

  def inputBusinessName(): Unit = {
    typeInsideElement(Locators.inputField, TestData.UserDetails.SupplierDetails.businessSupplier.userDetails.businessName)
    clickContinue()
  }
}