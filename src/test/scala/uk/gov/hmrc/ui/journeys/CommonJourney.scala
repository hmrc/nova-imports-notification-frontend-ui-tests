/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.journeys

import uk.gov.hmrc.ui.helpers.{AffinityGroup, CYAPage}
import uk.gov.hmrc.ui.pages.{AddPurchaserDetailsBusinessName, AddPurchaserDetailsName, AddYourDetailsEmail, AddYourDetailsGuidancePage, AddYourDetailsName, AddYourDetailsPhoneNumber, AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, AuthLoginPage, BeforeYouContinue, CheckYourAnswers, ChooseYourAddress, FindYourAddress, HasYourClientBroughtAVehicleIntoTheUkForBusinessUse, HaveYouBroughtAVehicleIntoTheUKForBusinessUse, IsYourAddressInTheUK, LandingPage, PurchaserOnBehalfOfABusinessOrIndividual, ReviewAndConfirmAddress, VehicleBroughtIntoNIFromEUPage}

/** Base methods that are used to answer repetitive scenarios within journeys to make code more readable */
object CommonJourney {
  // TODO: EVENTUALLY BREAK THESE UP INTO, IND -> ORG -> AGENT SPECIFIC METHODS
  // ACQUISITION SPECIFIC
  // IMPORT SPECIFIC
  def loginAndStartANotification(affinityGroup: AffinityGroup): Unit = {
    AuthLoginPage.login(affinityGroup)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()

    if (
      affinityGroup == AffinityGroup.OrganisationVAT ||
      affinityGroup == AffinityGroup.OrganisationVRN ||
      affinityGroup == AffinityGroup.AgentVAT
    ) {
      BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
    } else {
      BeforeYouContinue.verifyMultipleVehiclesSectionNotPresent()
    }
    BeforeYouContinue.clickContinue()
  }

  def beginAnAcquisition(): Unit = {
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
  }

  def beginAnImport(): Unit = {
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
  }

  def selfNotifying(): Unit = {
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionOneAndContinue()
  }

  def notifierIsABusiness(): Unit = {
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    AreYouABusinessOrPrivateIndividual.selectOptionOneAndContinue()
  }

  def notifierIsAPrivateIndividual(): Unit = {
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    AreYouABusinessOrPrivateIndividual.selectOptionTwoAndContinue()
  }

  def notifyingForABusiness(): Unit = {
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionTwoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    PurchaserOnBehalfOfABusinessOrIndividual.selectOptionOneAndContinue()
  }

  def notifyingForAnIndividual(): Unit = {
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionTwoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    PurchaserOnBehalfOfABusinessOrIndividual.selectOptionTwoAndContinue()
  }

  def vehicleBroughtInForBusinessUse(affinityGroup: AffinityGroup): Unit =
    if (affinityGroup == AffinityGroup.OrganisationVAT || affinityGroup == AffinityGroup.OrganisationVRN) {
      HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
      HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectYesAndContinue()
    } else if (affinityGroup == AffinityGroup.AgentVAT) {
      HasYourClientBroughtAVehicleIntoTheUkForBusinessUse.verifyPageDisplayed()
      HasYourClientBroughtAVehicleIntoTheUkForBusinessUse.selectYesAndContinue()
    }

  def vehicleBroughtInForPersonalUse(affinityGroup: AffinityGroup): Unit =
    if (affinityGroup == AffinityGroup.OrganisationVAT || affinityGroup == AffinityGroup.OrganisationVRN) {
      HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
      HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectNoAndContinue()
    } else if (affinityGroup == AffinityGroup.AgentVAT) {
      HasYourClientBroughtAVehicleIntoTheUkForBusinessUse.verifyPageDisplayed()
      HasYourClientBroughtAVehicleIntoTheUkForBusinessUse.selectNoAndContinue()
    }

  def validateAddYourDetailsGuidancePage(): Unit = {
    AddYourDetailsGuidancePage.navigateToPage(AddYourDetailsGuidancePage.pageUrl)
    AddYourDetailsGuidancePage.verifyPageDisplayed()
    AddYourDetailsGuidancePage.clickContinue()
  }

  def addUserDetailsNamePhoneNumberEmailAddress(): Unit = {
    // TODO: REMOVE ONCE NAVIGATION IN PLACE
    AddYourDetailsName.navigateToPage(AddYourDetailsName.pageUrl)
    AddYourDetailsName.verifyPageDisplayed()
    AddYourDetailsName.inputUserDetails()
    addPhoneAndEmailDetails()
  }

  def addUserDetailsBusinessNamePhoneNumberEmailAddress(): Unit =
    // TODO: AYD1.4
    addPhoneAndEmailDetails()

  def addPhoneAndEmailDetails(): Unit = {
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputMobileNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
  }

  def addPurchaserName(): Unit = {
    // TODO: REMOVE ONCE NAVIGATION IN PLACE
    AddPurchaserDetailsName.navigateToPage(AddPurchaserDetailsName.pageUrl)
    AddPurchaserDetailsName.verifyPageDisplayed()
    AddPurchaserDetailsName.inputUserDetails()
  }

  def addPurchaserBusinessName(): Unit = {
    // TODO: REMOVE ONCE NAVIGATION IN PLACE
    AddPurchaserDetailsBusinessName.navigateToPage(AddPurchaserDetailsBusinessName.pageUrl)
    AddPurchaserDetailsBusinessName.verifyPageDisplayed()
    AddPurchaserDetailsBusinessName.inputBusinessName()
  }

  // TODO: More details that vary based on user answers

  /** Helper method that will allow us to confirm which CYA page we are on and verify it's correct etc., */
  def validateCheckYourAnswers(page: CYAPage, userType: AffinityGroup): Unit = {
    CheckYourAnswers(page).verifyPageDisplayed()
    CheckYourAnswers(page).checkContentIsCorrect(page, userType)
    CheckYourAnswers(page).clickContinue()
  }

  /** Helper methods that will be used by journeys to supply different types of addresses i.e., a UK specific flow or
    * details from an International Flow etc., Notifier -> self submission Purchaser -> notifying on behalf of someone
    * else Supplier -> who we are purchasing the vehicle from
    */
  def notifierHasUkDetails(): Unit = {
    // TODO: UNCOMMENT ONCE NAVIGATION IS IN PLACE
    IsYourAddressInTheUK.navigateToPage(IsYourAddressInTheUK.pageUrl)
    IsYourAddressInTheUK.verifyPageDisplayed()
    IsYourAddressInTheUK.selectOptionOneAndContinue()
    FindYourAddress.verifyPageDisplayed()
    FindYourAddress.inputUserAddressForSearch()
    ChooseYourAddress.verifyPageDisplayed()
    ChooseYourAddress.selectAnAddress()
    ReviewAndConfirmAddress.verifyPageDisplayed()
    ReviewAndConfirmAddress.clickContinue()
  }

  def notifierHasInternationalDetails(): Unit = {}

  def purchaserHasUkDetails(): Unit = {}

  def purchaserHasInternationalDetails(): Unit = {}

  def supplierHasUkDetails(): Unit = {}

  def supplierHasInternationalDetails(): Unit = {}

  // TODO:
  /** Helper methods for adding vehicles */
}
