package uk.gov.hmrc.ui.journeys

import uk.gov.hmrc.ui.helpers.AffinityGroup
import uk.gov.hmrc.ui.pages.{AuthLoginPage, BasePage, VehicleBroughtIntoNIFromEUPage, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney extends BasePage {
  override val pageUrl: String = ""

  def completeIndividualJourneyFlow(): Unit = {
    // TODO: This would eventually go page to page
  }

  def userNeedsToImportAVehicle(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    selectNoAndContinue()
    VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
  }
}
