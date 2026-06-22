package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object FindYourAddress extends BasePage {
  override val pageUrl: String = s"$addressLookupBaseUrl/"
  val endOfUrl: String = "/lookup"

  object ALFPageLocators {
    val postcode: By = By.id("postcode")
    val houseNameOrNumber: By = By.id("filter")
  }

  def verifyPartialUrl(): Unit = {
    verifyEndOfUrl(endOfUrl)
  }

  def verifyPageDisplayed(): Unit = {
    verifyInputPageHeading(
      expectedHeading = "Find your address"
    )
  }

  def inputUserAddressForSearch(): Unit = {
    val postcode = waitForVisibilityOfElement(ALFPageLocators.postcode)
    postcode.sendKeys("NW8 9AY")
  }
}
