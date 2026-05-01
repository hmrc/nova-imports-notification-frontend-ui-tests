package uk.gov.hmrc.ui.pages

object LandingPage extends BasePage {
  override val pageUrl: String = s"$baseUrl/notification-of-vehicle-arrivals"

  def verifyPageDisplayed(): Unit =
    validateStandardPage(expectedHeading = "Notification of Vehicle Arrivals (NOVA)")
}
