package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object VehicleBroughtIntoNIFromOutsideEUPage extends BasePage {

  override val pageUrl: String = s"$baseUrl/vehicle-outside-eu"

  def verifyPageDisplayed(): Unit =
    validatePage(
      expectedUrl = pageUrl,
      expectedHeading =
        "You need to make an import declaration if you've brought a vehicle into Northern Ireland from outside the EU"
    )

  def validatePageContent(): Unit =
    verifyPageDisplayed()
}
