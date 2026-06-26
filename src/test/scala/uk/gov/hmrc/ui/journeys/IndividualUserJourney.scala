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
import uk.gov.hmrc.ui.pages.{AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, AuthLoginPage, BeforeYouContinue, LandingPage, PurchaserOnBehalfOfABusinessOrIndividual, VehicleBroughtIntoNIFromEUPage, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney {
  // TODO: Break these into sections that will allow for address for notifier / supplier to be
  // UK and International... for now just UK implemented...
  def privateIndividualAsPurchaser(): Unit = {
    privateIndividualAsANotifier()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionOneAndContinue()
    CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
    // TODO: TASK LIST
    CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
    // TODO: SHOULD BE AT TASK LIST AGAIN
    CommonJourney.notifierHasUkDetails()
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def privateIndividualOnBehalfOfBusiness(): Unit = {
    privateIndividualAsANotifier()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionTwoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    PurchaserOnBehalfOfABusinessOrIndividual.selectOptionOneAndContinue()
    CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
    // TODO: TASK LIST
    CommonJourney.addUserDetailsBusinessNamePhoneNumberEmailAddress()
    // TODO: SHOULD BE AT TASK LIST AGAIN
    CommonJourney.notifierHasUkDetails()
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def privateIndividualOnBehalfOfPrivateIndividual(): Unit = {
    privateIndividualAsANotifier()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
    AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionTwoAndContinue()
    PurchaserOnBehalfOfABusinessOrIndividual.verifyPageDisplayed()
    PurchaserOnBehalfOfABusinessOrIndividual.selectOptionTwoAndContinue()
    CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
    // TODO: TASK LIST
    CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
    // TODO: TASK LIST
    CommonJourney.notifierHasUkDetails()
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def userNeedsToImportAVehicleFromOutsideEU(): Unit = {
    loginAndStartANotification()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
  }

  /** Common repeated flows reducing them into one method to cut down on code duplication */
  private def loginAndStartANotification(): Unit   = {
    AuthLoginPage.login(AffinityGroup.Individual)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionNotPresent()
    BeforeYouContinue.clickContinue()
  }
  private def privateIndividualAsANotifier(): Unit = {
    loginAndStartANotification()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
    AreYouABusinessOrPrivateIndividual.selectOptionTwoAndContinue()
    AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
  }
}
