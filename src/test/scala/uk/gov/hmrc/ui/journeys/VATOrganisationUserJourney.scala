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

import uk.gov.hmrc.ui.helpers.CYAPage.InitialQuestions
import uk.gov.hmrc.ui.helpers.{AffinityGroup, CYAPage}
import uk.gov.hmrc.ui.pages.{AddYourDetailsEmail, AddYourDetailsGuidancePage, AddYourDetailsName, AddYourDetailsPhoneNumber, AuthLoginPage, BeforeYouContinue, CheckYourAnswers, ChooseYourAddress, FindYourAddress, HaveYouBroughtAVehicleIntoTheUKForBusinessUse, IsYourAddressInTheUK, LandingPage, ReviewAndConfirmAddress, VehicleBroughtIntoNIFromEUPage}

object VATOrganisationUserJourney {
  // TODO: Finish this flow once we have more screens
  def acquisitionBringingAVehicleInForBusinessUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectYesAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageDisplayed()
    CheckYourAnswers(CYAPage.InitialQuestions)
      .checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    CheckYourAnswers(CYAPage.InitialQuestions).clickContinue()
    // TODO: TASK LIST
    // TODO: REMOVE URL NAVIGATION ONCE WE HAVE THE REAL FLOW
    AddYourDetailsGuidancePage.navigateToPage(AddYourDetailsGuidancePage.pageUrl)
    AddYourDetailsGuidancePage.verifyPageDisplayed()
    AddYourDetailsGuidancePage.clickContinue()
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputPhoneNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
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
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def acquisitionVehicleForPrivateUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectNoAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageDisplayed()
    CheckYourAnswers(CYAPage.InitialQuestions)
      .checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    CheckYourAnswers(CYAPage.InitialQuestions).clickContinue()
    // TODO: REMOVE URL NAVIGATION ONCE WE HAVE THE REAL FLOW
    AddYourDetailsGuidancePage.navigateToPage(AddYourDetailsGuidancePage.pageUrl)
    AddYourDetailsGuidancePage.verifyPageDisplayed()
    AddYourDetailsGuidancePage.clickContinue()
    AddYourDetailsName.verifyPageDisplayed()
    AddYourDetailsName.inputUserDetails()
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputPhoneNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
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
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def importBringingAVehicleInForBusinessUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectYesAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageDisplayed()
    CheckYourAnswers(CYAPage.InitialQuestions)
      .checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    CheckYourAnswers(InitialQuestions).clickContinue()
    // TODO: TASK LIST
    // TODO: REMOVE URL NAVIGATION ONCE WE HAVE THE REAL FLOW
    AddYourDetailsGuidancePage.navigateToPage(AddYourDetailsGuidancePage.pageUrl)
    AddYourDetailsGuidancePage.verifyPageDisplayed()
    AddYourDetailsGuidancePage.clickContinue()
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputPhoneNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
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
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def importVehicleForPrivateUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectNoAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageDisplayed()
    CheckYourAnswers(CYAPage.InitialQuestions)
      .checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    CheckYourAnswers(CYAPage.InitialQuestions).clickContinue()
    // TODO: TASK LIST PAGE
    // TODO: REMOVE URL NAVIGATION ONCE WE HAVE THE REAL FLOW
    AddYourDetailsGuidancePage.navigateToPage(AddYourDetailsGuidancePage.pageUrl)
    AddYourDetailsGuidancePage.verifyPageDisplayed()
    AddYourDetailsGuidancePage.clickContinue()
    AddYourDetailsName.verifyPageDisplayed()
    AddYourDetailsName.inputUserDetails()
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputPhoneNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
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
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }
}
