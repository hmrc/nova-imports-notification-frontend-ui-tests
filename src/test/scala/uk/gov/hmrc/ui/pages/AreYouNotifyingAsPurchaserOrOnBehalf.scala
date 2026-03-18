package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object AreYouNotifyingAsPurchaserOrOnBehalf extends BasePage {

  override val pageUrl: String = s"$baseUrl/purchaser-or-on-behalf"

  object PageLocators {
    val purchaser: By = By.id("notifierType")
    val onBehalf: By  = By.id("notifierType-2")
  }

  def verifyPageDisplayed(): Unit =
    validatePage(
      expectedHeading = "Are you notifying as the purchaser, or on behalf of a purchaser?"
    )

  def selectPurchaserAndContinue(): Unit = {
    click(PageLocators.purchaser)
    click(Locators.continueButton)
  }

  def selectOnBehalfAndContinue(): Unit = {
    click(PageLocators.onBehalf)
    click(Locators.continueButton)
  }
}
