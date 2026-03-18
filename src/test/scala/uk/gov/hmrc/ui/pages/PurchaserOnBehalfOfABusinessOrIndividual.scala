package uk.gov.hmrc.ui.pages

object PurchaserOnBehalfOfABusinessOrIndividual extends BasePage {
  override val pageUrl: String = s"$baseUrl/purchaser-business-or-private-individual"

  def verifyPageDisplayed(): Unit =
    validatePage(
      expectedHeading =
        "Is the purchaser you are notifying on behalf of a business or private individual?"
    )
}