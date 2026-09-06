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

import uk.gov.hmrc.ui.helpers.{AddressPages, AffinityGroup, CYAPage}
import uk.gov.hmrc.ui.pages.addresses.{ChooseYourAddress, FindYourAddress, ReviewAndConfirmAddress}
import uk.gov.hmrc.ui.pages.common.{AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, BeforeYouContinue, CheckYourAnswers, HasYourClientBroughtAVehicleIntoTheUkForBusinessUse, HaveYouBroughtAVehicleIntoTheUKForBusinessUse, LandingPage, NotificationTaskList, PurchaserOnBehalfOfABusinessOrIndividual, VehicleBroughtIntoNIFromEUPage}
import uk.gov.hmrc.ui.pages.notifier.{AddYourDetailsBusinessName, AddYourDetailsEmail, AddYourDetailsGuidancePage, AddYourDetailsName, AddYourDetailsPhoneNumber, IsYourAddressInTheUK}
import uk.gov.hmrc.ui.pages.purchaser.{AddPurchaserDetailsBusinessName, AddPurchaserDetailsName, IsPurchaserAddressInTheUK}
import uk.gov.hmrc.ui.pages.supplier.AddVehicleDetails
import uk.gov.hmrc.ui.pages.AuthLoginPage

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

  def beginAnAcquisition(vatUser: Boolean = false): Unit = {
    VehicleBroughtIntoNIFromEUPage(vatUser).verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage(vatUser).selectYesAndContinue()
  }

  def beginAnImport(vatUser: Boolean = false): Unit = {
    VehicleBroughtIntoNIFromEUPage(vatUser).verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage(vatUser).selectNoAndContinue()
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

  // TODO: More details that vary based on user answers

  /** Helper method that will allow us to confirm which CYA page we are on and verify it's correct etc., */
  def validateCheckYourAnswers(page: CYAPage, userType: AffinityGroup): Unit = {
    CheckYourAnswers(page).verifyPageDisplayed()
    CheckYourAnswers(page).checkContentIsCorrect(page, userType)
    CheckYourAnswers(page).clickContinue()
  }

  def addYourDetails(): Unit = {
    NotificationTaskList.verifyPageDisplayed()
    NotificationTaskList.verifyAddYourDetailsStatus("Incomplete")
    NotificationTaskList.clickAddYourDetails()
  }

  def addYourAddress(): Unit = {
    NotificationTaskList.verifyPageDisplayed()
    NotificationTaskList.verifyAddYourAddressStatus("Incomplete")
    NotificationTaskList.clickAddYourAddress()
  }

  def addPurchaserDetails(): Unit = {
    NotificationTaskList.verifyPageDisplayed()
    NotificationTaskList.verifyAddPurchaserDetailsStatus("Incomplete")
    NotificationTaskList.clickAddPurchaserDetails()
  }

  def addPurchaserAddress(): Unit = {
    NotificationTaskList.verifyPageDisplayed()
    NotificationTaskList.verifyAddPurchaserAddressStatus("Incomplete")
    NotificationTaskList.clickAddPurchaserAddress()
  }

  def addVehicleDetails(): Unit = {
    NotificationTaskList.verifyPageDisplayed()
    NotificationTaskList.verifyAddVehicleDetailsStatus("Incomplete")
    NotificationTaskList.clickAddVehicleDetails()
  }

  def validateAddYourDetailsGuidancePage(): Unit = {
    AddYourDetailsGuidancePage.verifyPageDisplayed()
    AddYourDetailsGuidancePage.clickContinue()
  }

  def addUserDetailsNamePhoneNumberEmailAddress(): Unit = {
    AddYourDetailsName.verifyPageDisplayed()
    AddYourDetailsName.inputUserDetails()
    addPhoneAndEmailDetails()
  }

  def addUserDetailsBusinessNamePhoneNumberEmailAddress(): Unit = {
    AddYourDetailsBusinessName.verifyPageDisplayed()
    AddYourDetailsBusinessName.inputBusinessName()
    addPhoneAndEmailDetails()
  }

  def addPhoneAndEmailDetails(): Unit = {
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputMobileNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
  }

  def addPurchaserName(): Unit = {
    AddPurchaserDetailsName.verifyPageDisplayed()
    AddPurchaserDetailsName.inputUserDetails()
  }

  def addPurchaserBusinessName(): Unit = {
    AddPurchaserDetailsBusinessName.verifyPageDisplayed()
    AddPurchaserDetailsBusinessName.inputBusinessName()
  }

  /** Helper methods that will be used by journeys to supply different types of addresses i.e., a UK specific flow or
    * details from an International Flow etc., Notifier -> self submission Purchaser -> notifying on behalf of someone
    * else Supplier -> who we are purchasing the vehicle from
    */
  // TODO: this can become generic and then used for supplier + purchaser
  def notifierHasUkDetails(): Unit = {
    IsYourAddressInTheUK.verifyPageDisplayed()
    IsYourAddressInTheUK.selectYesAndContinue()
    FindYourAddress.verifyPageDisplayed(AddressPages.Notifier)
    FindYourAddress.inputUserAddressForSearch()
    ChooseYourAddress.verifyPageDisplayed(AddressPages.Notifier)
    ChooseYourAddress.selectAnAddress()
    ReviewAndConfirmAddress.verifyPageDisplayed(AddressPages.Notifier)
    ReviewAndConfirmAddress.clickContinue()
  }

  def notifierHasInternationalDetails(): Unit = {}

  def purchaserHasUkDetails(): Unit = {
    IsPurchaserAddressInTheUK.verifyPageDisplayed()
    IsPurchaserAddressInTheUK.selectOptionOneAndContinue()
    FindYourAddress.verifyPageDisplayed(AddressPages.Purchaser)
    FindYourAddress.inputUserAddressForSearch()
    ChooseYourAddress.verifyPageDisplayed(AddressPages.Purchaser)
    ChooseYourAddress.selectAnAddress()
    ReviewAndConfirmAddress.verifyPageDisplayed(AddressPages.Purchaser)
    ReviewAndConfirmAddress.clickContinue()
  }

  def purchaserHasInternationalDetails(): Unit = {}

  def supplierHasUkDetails(): Unit = {}

  def supplierHasInternationalDetails(): Unit = {}

  // TODO:
  /** Helper methods for adding vehicles */
  def addVehicleDetailsUploadAVehicleSpreadsheet(): Unit = {
    AddVehicleDetails.verifyPageDisplayed()
    AddVehicleDetails.selectOptionTwoAndContinue()
  }

  def validateCheckYourAnswersForAddress(page: CYAPage): Unit = {
    CheckYourAnswers(page).verifyPageDisplayed()
    CheckYourAnswers(page).clickContinue()
  }
}
