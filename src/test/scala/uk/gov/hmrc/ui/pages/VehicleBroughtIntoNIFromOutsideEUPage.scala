package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object VehicleBroughtIntoNIFromOutsideEUPage extends BasePage {

  override val pageUrl: String = s"$baseUrl/vehicle-outside-eu"

  object PageLocators {
    val listText1: By = By.id("TO-BE-DECIDED")
    val listText2: By = By.id("TO-BE-DECIDED")
  }

  val listText1: String =
    "More information on how to notify HMRC can be found at Importing vehicles into the UK: Telling HMRC - UK GOV.UK (www.gov.uk)"

  val listText2: String = "Check which countries are in the EU"

  def verifyPageDisplayed(): Unit =
    validatePage(
      expectedUrl = pageUrl,
      expectedHeading =
        "You need to make an import declaration if you've brought a vehicle into Northern Ireland from outside the EU"
    )

  def validatePageContent(): Unit = {
    verifyPageDisplayed()
    verifyText(listText1, PageLocators.listText1)
    verifyText(listText2, PageLocators.listText2)
  }
}
