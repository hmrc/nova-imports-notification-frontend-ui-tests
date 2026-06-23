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
import uk.gov.hmrc.ui.pages.{AddYourDetailsEmail, AddYourDetailsName, AddYourDetailsPhoneNumber, AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, AuthLoginPage, BeforeYouContinue, CheckYourAnswers, LandingPage, PurchaserOnBehalfOfABusinessOrIndividual, VehicleBroughtIntoNIFromEUPage, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney {
  def privateIndividualAsPurchaser(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionNotPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    AreYouABusinessOrPrivateIndividual.selectOptionTwoAndContinue()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionOneAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageDisplayed()
    CheckYourAnswers(CYAPage.InitialQuestions).checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.Individual)
    // TODO: UNCOMMENT ONCE NAVIGATION IS IN PLACE
    // CheckYourAnswers(CYAPage.InitialQuestions).clickContinue()
    // TODO: TASK LIST
    // TODO: REMOVE ONCE NAVIGATION IN PLACE
    // UNCOMMENT ONCE DEVS FIX
//    AddYourDetailsName.navigateToPage(AddYourDetailsName.pageUrl)
//    AddYourDetailsName.verifyPageDisplayed()
//    AddYourDetailsName.inputUserDetails()
//    AddYourDetailsPhoneNumber.verifyPageDisplayed()
//    AddYourDetailsPhoneNumber.inputPhoneNumber()
//    AddYourDetailsEmail.verifyPageDisplayed()
//    AddYourDetailsEmail.inputEmailAddress()
  }

  def privateIndividualOnBehalfOfBusiness(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionNotPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    AreYouABusinessOrPrivateIndividual.selectOptionTwoAndContinue()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionTwoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    PurchaserOnBehalfOfABusinessOrIndividual.selectOptionOneAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageDisplayed()
    CheckYourAnswers(CYAPage.InitialQuestions).checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.Individual)
    CheckYourAnswers(CYAPage.InitialQuestions).clickContinue()
    // TODO: TASK LIST
    // TODO: AYD1.4
    // TODO: ONCE NAVIGATION IN PLACE REMOVE
    AddYourDetailsPhoneNumber.goToPage(AddYourDetailsPhoneNumber.pageUrl)
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputPhoneNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
  }

  def privateIndividualOnBehalfOfPrivateIndividual(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionNotPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    AreYouABusinessOrPrivateIndividual.selectOptionTwoAndContinue()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionTwoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    PurchaserOnBehalfOfABusinessOrIndividual.selectOptionTwoAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageDisplayed()
    CheckYourAnswers(CYAPage.InitialQuestions).checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.Individual)
    // TODO: TASK LIST
    // TODO: SUPPLIER DETAILS?
  }

  def userNeedsToImportAVehicleFromOutsideEU(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionNotPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
  }
}
