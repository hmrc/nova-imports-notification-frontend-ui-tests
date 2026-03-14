package uk.gov.hmrc.ui.pages

object VehicleBroughtIntoNIFromEUPage extends BasePage {

  override val pageUrl: String = s"$baseUrl/vehicle-from-eu"

  def verifyPageDisplayed(): Unit =
    validatePage(
      expectedUrl = pageUrl,
      expectedHeading =
        "Are you completing a notification for a vehicle brought into Northern Ireland from an EU country?"
    )

  def selectYesAndContinue(): Unit = {
    selectYes()
    clickContinue()
  }

  def selectNoAndContinue(): Unit = {
    selectNo()
    clickContinue()
  }

  def goBack(): Unit =
    clickBack()
}
