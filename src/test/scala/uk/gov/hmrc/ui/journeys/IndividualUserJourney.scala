package uk.gov.hmrc.ui.journeys

import uk.gov.hmrc.ui.helpers.AffinityGroup
import uk.gov.hmrc.ui.pages.{AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, AuthLoginPage, PurchaserOnBehalfOfABusinessOrIndividual, VehicleBroughtIntoNIFromEUPage, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney {
  def privateIndividualAsPurchaser(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM NO TO OPTION TWO / AS PRIVATE INDIVIDUAL
    AreYouABusinessOrPrivateIndividual.selectNoAndContinue()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM YES TO OPTION ONE / AS THE PURCHASER
    AreYouNotifyingAsPurchaserOrOnBehalf.selectYesAndContinue()
    // TODO: NOW ON SUMMARY PAGE
  }

  def privateIndividualOnBehalfOfBusiness(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM NO TO OPTION TWO / AS PRIVATE INDIVIDUAL
    AreYouABusinessOrPrivateIndividual.selectNoAndContinue()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM NO TO OPTION TWO / ON BEHALF OF PURCHASER
    AreYouNotifyingAsPurchaserOrOnBehalf.selectNoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM YES TO OPTION ONE / NON-VAT REGISTERED BUSINESS
    PurchaserOnBehalfOfABusinessOrIndividual.selectYesAndContinue()
    // TODO: NOW ON SUMMARY PAGE
  }

  def privateIndividualOnBehalfOfPrivateIndividual(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM NO TO OPTION TWO / AS PRIVATE INDIVIDUAL
    AreYouABusinessOrPrivateIndividual.selectNoAndContinue()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM NO TO OPTION TWO / ON BEHALF OF PURCHASER
    AreYouNotifyingAsPurchaserOrOnBehalf.selectNoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    // TODO: THIS WILL CHANGE FROM NO TO OPTION TWO / NON-VAT REGISTERED PRIVATE INDIVIDUAL
    PurchaserOnBehalfOfABusinessOrIndividual.selectNoAndContinue()
    // TODO: NOW ON SUMMARY PAGE
  }

  def userNeedsToImportAVehicleFromOutsideEU(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
  }
}
