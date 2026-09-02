package uk.gov.hmrc.ui.pages

object UseThePurchaserDetailsAsTheSupplierDetails extends BasePage {
  override val pageUrl: String = s"$baseUrl/use-purchaser-details-as-supplier"

  def verifyPageDisplayed(): Unit =
    verifyStandardPageHeading(
      expectedHeading = "Use the purchaser details as the supplier details"
    )
}
