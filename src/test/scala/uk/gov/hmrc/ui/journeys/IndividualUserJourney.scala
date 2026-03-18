package uk.gov.hmrc.ui.journeys

import uk.gov.hmrc.ui.helpers.AffinityGroup
import uk.gov.hmrc.ui.pages.{AuthLoginPage, VehicleBroughtIntoNIFromEUPage, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney {
  def userCompletesFlowWithManualEntryOfAVehicle(): Unit = {
    // TODO: This would eventually go page to page
  }

  def userCompletesFlowUpToSpreadsheetUpload(): Unit = {
    // TODO:
  }

  def userCompletesFlowAfterSpreadsheetUpload(): Unit = {
    // TODO:
  }

  def userNeedsToImportAVehicleFromOutsideEU(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
  }
}
