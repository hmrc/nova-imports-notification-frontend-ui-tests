package uk.gov.hmrc.ui.pages

object WeCouldNotRetrieveYourClientList extends BasePage {
  override val pageUrl: String = s"$baseUrl/view-clients/failed"

  def verifyPageDisplayed(): Unit =
    validateStandardPage(
      expectedHeading = "We could not retrieve your client list"
    )
}
