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
import uk.gov.hmrc.ui.pages.{AuthLoginPage, BeforeYouContinue, HaveYouBroughtAVehicleIntoTheUKForBusinessUse, LandingPage, VehicleBroughtIntoNIFromEUPage}

object VATOrganisationUserJourney {
  // TODO: Finish this flow once we have more screens
  def acquisitionBringingAVehicleInForBusinessUse(): Unit = {
    acquisitionEntryFlow()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectYesAndContinue()
    CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    // TODO: TASK LIST
    CommonJourney.validateAddYourDetailsGuidancePage()
    CommonJourney.addPhoneAndEmailDetails()
    // TODO: TASK LIST
    CommonJourney.notifierHasUkDetails()
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def acquisitionVehicleForPrivateUse(): Unit = {
    acquisitionEntryFlow()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectNoAndContinue()
    CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    CommonJourney.validateAddYourDetailsGuidancePage()
    CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
    // TASK LIST
    CommonJourney.notifierHasUkDetails()
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def importBringingAVehicleInForBusinessUse(): Unit = {
    importEntryFlow()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectYesAndContinue()
    CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    // TODO: TASK LIST
    CommonJourney.validateAddYourDetailsGuidancePage()
    // TODO: BUSINESS NAME?
    CommonJourney.addPhoneAndEmailDetails()
    // TODO: TASK LIST
    CommonJourney.notifierHasUkDetails()
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  def importVehicleForPrivateUse(): Unit = {
    importEntryFlow()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectNoAndContinue()
    CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
    // TODO: TASK LIST PAGE
    CommonJourney.validateAddYourDetailsGuidancePage()
    CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
    // TODO: TASK LIST
    CommonJourney.notifierHasUkDetails()
    // TODO: SHOULD BE AT TASK LIST AGAIN
  }

  private def loginAndBeginANotification(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
  }
  private def acquisitionEntryFlow(): Unit       = {
    loginAndBeginANotification()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
  }

  private def importEntryFlow(): Unit = {
    loginAndBeginANotification()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
  }
}
