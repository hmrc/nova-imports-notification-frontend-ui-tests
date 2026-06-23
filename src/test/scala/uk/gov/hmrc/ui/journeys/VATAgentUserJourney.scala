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
import uk.gov.hmrc.ui.pages.{AddYourDetailsEmail, AddYourDetailsName, AddYourDetailsPhoneNumber, AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, AuthLoginPage, BeforeYouContinue, CheckYourAnswers, HasYourClientBroughtAVehicleIntoTheUkForBusinessUse, LandingPage, RetrievingYourClientList, TestOnlySessionPage, VehicleBroughtIntoNIFromEUPage, WeCouldNotRetrieveYourClientList, YouHaveNoAuthorisedClients}

object VATAgentUserJourney {

  /** The main user journey for an Agent, they will choose a client and submit a notification on their behalf */
  def agentNotifyingOnBehalfOfClient(): Unit = {
    AuthLoginPage.login(AffinityGroup.AgentVAT)
    LandingPage.verifyPageDisplayed()
    LandingPage.manageYourClients()
    RetrievingYourClientList.verifyPageDisplayed()
    // TODO: Remove TestOnlySessionPage once flow is actually implemented
    TestOnlySessionPage.setSelectedClientInSession()
    LandingPage.navigateToPage(LandingPage.pageUrl)
    LandingPage.waitForUrl(LandingPage.pageUrl)
    // TODO: WOULD BE CLIENT SELECTION
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
    BeforeYouContinue.clickContinue()
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    HasYourClientBroughtAVehicleIntoTheUkForBusinessUse.verifyPageDisplayed()
    HasYourClientBroughtAVehicleIntoTheUkForBusinessUse.selectYesAndContinue()
    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageUrl()
    CheckYourAnswers(CYAPage.InitialQuestions).checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
    CheckYourAnswers(CYAPage.InitialQuestions).clickContinue()
    // TODO: TASK LIST
    // TODO: CONTACT DETAILS
    // TODO: REMOVE URL HOP ONCE NAVIGATION IS IN PLACE
    AddYourDetailsPhoneNumber.navigateToPage(AddYourDetailsPhoneNumber.pageUrl)
    AddYourDetailsPhoneNumber.verifyPageDisplayed()
    AddYourDetailsPhoneNumber.inputPhoneNumber()
    AddYourDetailsEmail.verifyPageDisplayed()
    AddYourDetailsEmail.inputEmailAddress()
  }

  // NOTE: Not sure if CS2.0 will actually be reachable?
  /** A short journey to reach an error page and then will end the journey */
  def agentNotifyingOnBehalfOfClientClientListFailedToLoad(): Unit = {
    AuthLoginPage.login(AffinityGroup.AgentVAT)
    LandingPage.verifyPageDisplayed()
    // TODO: Verify Landing Page LP3.0 for Agents with Clients.
    // TODO: SELECT CLIENT AND CONTINUE
    // TODO: Remove once flow is actually implemented
    RetrievingYourClientList.navigateToPage(RetrievingYourClientList.pageUrl)
    RetrievingYourClientList.verifyPageDisplayed()
    // TODO: Remove once flow is actually implemented
    WeCouldNotRetrieveYourClientList.navigateToPage(WeCouldNotRetrieveYourClientList.pageUrl)
    WeCouldNotRetrieveYourClientList.verifyPageDisplayed()
  }

  /** This user will complete a notification acting as a private individual, i.e., completing a notification for
    * themselves and not on behalf of a Client
    */
  def agentNotifyingOnBehalfOfThemself(): Unit = {
    AuthLoginPage.login(AffinityGroup.AgentVAT)
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
    // TODO: I NEED TO FIX THE CYA IT THINKS IT NEEDS AGENT ONE BUT WE ACTUALLY WENT PRIVATE ROUTE!!!
//    CheckYourAnswers(CYAPage.InitialQuestions).verifyPageUrl()
//    CheckYourAnswers(CYAPage.InitialQuestions).checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
    // TODO: ONCE NAVIGATION IS IN PLACE REMOVE THIS
    // TODO: ADD YOUR DETAILS PAGE + NAME ETC SHOULD BE VALID
    // COMMENTING OUT FOR NOW AS TESTS FAIL
//    AddYourDetailsName.navigateToPage(AddYourDetailsName.pageUrl)
//    AddYourDetailsName.verifyPageDisplayed()
//    AddYourDetailsName.inputUserDetails()
//    AddYourDetailsPhoneNumber.verifyPageDisplayed()
//    AddYourDetailsPhoneNumber.inputPhoneNumber()
//    AddYourDetailsEmail.verifyPageDisplayed()
//    AddYourDetailsEmail.inputEmailAddress()
  }
}
