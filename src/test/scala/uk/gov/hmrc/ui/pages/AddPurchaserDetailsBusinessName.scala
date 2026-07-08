package uk.gov.hmrc.ui.pages

object AddPurchaserDetailsBusinessName extends BasePage {
  override val pageUrl: String = s"$baseUrl/purchaser-business-name"

  def verifyPageDisplayed(): Unit =
    verifyInputPageHeading(
      expectedHeading = "What is the purchaser’s business name?"
    )

  def inputBusinessName(): Unit = {
    typeInsideElement(Locators.inputField, "Temp")
    clickContinue()
  }
}
