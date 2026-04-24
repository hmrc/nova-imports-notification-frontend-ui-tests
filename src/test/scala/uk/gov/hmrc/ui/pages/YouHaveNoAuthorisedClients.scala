package uk.gov.hmrc.ui.pages

object YouHaveNoAuthorisedClients extends BasePage {
  override val pageUrl: String = s"$baseUrl/view-clients/no-authorised-clients"

  def verifyPageDisplayed(): Unit = {
    validatePage(
      expectedHeading = "You have no authorised clients",
      defaultHeading = false
    )
  }
}
