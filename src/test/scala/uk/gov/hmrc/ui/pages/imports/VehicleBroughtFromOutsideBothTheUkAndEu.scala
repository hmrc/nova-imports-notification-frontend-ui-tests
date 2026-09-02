package uk.gov.hmrc.ui.pages.imports

import uk.gov.hmrc.ui.pages.BasePage

object VehicleBroughtFromOutsideBothTheUkAndEu extends BasePage {
  override val pageUrl: String = s"$baseUrl/vehicles-brought-from-outside-uk-or-eu"

  def verifyPageDisplayed(): Unit =
    verifyStandardPageHeading(
      expectedHeading = "Vehicles brought from outside both the UK and the EU"
    )

  // TODO: ADD SELECT IMPORT / SPREADSHEET RADIO BUTTON
}
