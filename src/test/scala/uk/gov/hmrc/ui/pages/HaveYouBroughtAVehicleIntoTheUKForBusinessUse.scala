package uk.gov.hmrc.ui.pages

object HaveYouBroughtAVehicleIntoTheUKForBusinessUse extends BasePage {
  override val pageUrl: String = s"$baseUrl/vehicle-business-use"

  def verifyPageDisplayed(): Unit =
    validatePage(
      expectedHeading = "Have you brought a vehicle into the UK for business use?"
    )
}