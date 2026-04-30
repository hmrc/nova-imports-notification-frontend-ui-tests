package uk.gov.hmrc.ui.pages

object HasYourClientBroughtAVehicleIntoTheUkForBusinessUse extends BasePage {
  override val pageUrl: String = s"$baseUrl/client-vehicle-business-use"

  def verifyPageDisplayed(): Unit =
    validateQuestionPage(
      expectedHeading =
        "Has your client brought a vehicle into the UK for business use? - Notification of Vehicle Arrivals"
    )
}
