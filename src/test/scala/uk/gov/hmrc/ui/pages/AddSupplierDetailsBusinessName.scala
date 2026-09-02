package uk.gov.hmrc.ui.pages

import uk.gov.hmrc.ui.data.TestData
import uk.gov.hmrc.ui.pages.AddPurchaserDetailsBusinessName.{clickContinue, typeInsideElement}

object AddSupplierDetailsBusinessName extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/1/supplier-business-name"

  def verifyPageDisplayed(): Unit =
    verifyInputPageHeading(
      expectedHeading = "What is the supplier’s business name?"
    )

  // TODO: this code isn't DRY and is already repeated in purchaser business name etc.,
  def inputBusinessName(): Unit = {
    typeInsideElement(
      Locators.inputField,
      TestData.UserDetails.SupplierDetails.businessSupplier.userDetails.businessName
    )
    clickContinue()
  }
}
