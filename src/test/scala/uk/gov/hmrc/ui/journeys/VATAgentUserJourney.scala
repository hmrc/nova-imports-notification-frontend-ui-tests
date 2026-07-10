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
import uk.gov.hmrc.ui.pages.{AddYourDetailsEmail, AddYourDetailsName, AddYourDetailsPhoneNumber, AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, AuthLoginPage, BeforeYouContinue, CheckYourAnswers, LandingPage, VehicleBroughtIntoNIFromEUPage}

object VATAgentUserJourney {
//  private def loginSelectClientAndBeginANotification(): Unit = {
//    AuthLoginPage.login(AffinityGroup.AgentVAT)
//    LandingPage.verifyPageDisplayed()
//    LandingPage.manageYourClients()
//    RetrievingYourClientList.verifyPageDisplayed()
//    // TODO: Remove TestOnlySessionPage once flow is actually implemented
//    TestOnlySessionPage.setSelectedClientInSession()
//    LandingPage.navigateToPage(LandingPage.pageUrl)
//    LandingPage.waitForUrl(LandingPage.pageUrl)
//    // TODO: WOULD BE CLIENT SELECTION
//    LandingPage.verifyPageDisplayed()
//    LandingPage.createANewNotification()
//    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()
//    BeforeYouContinue.clickContinue()
//  }

  // TODO: RE-IMPLEMENT THESE TESTS ONCE WE CAN ACTUALLY SELECT A CLIENT
//  object ActingOnBehalfOfClient {
//    object Acquisition {
//      def clientNotifyingForBusinessUse(): Unit = {
//        loginSelectClientAndBeginANotification()
//        CommonJourney.beginAnAcquisition()
//        CommonJourney.vehicleBroughtInForBusinessUse(AffinityGroup.AgentVAT)
//        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
//        // TODO: TASK LIST
//        CommonJourney.addPhoneAndEmailDetails()
//      }
//
//      def clientNotifyingForPersonalUse(): Unit = {
//        loginSelectClientAndBeginANotification()
//        CommonJourney.beginAnAcquisition()
//        CommonJourney.vehicleBroughtInForPersonalUse(AffinityGroup.AgentVAT)
//        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
//        // TODO: TASK LIST
//        CommonJourney.addPhoneAndEmailDetails()
//      }
//    }
//
//    object Import {
//      // TODO:
//    }
//  }

  object SelfNotifying {
    object Acquisition {
      def agentNotifyingOnBehalfOfThemself(): Unit = {
        CommonJourney.loginAndStartANotification(AffinityGroup.AgentVAT)
        CommonJourney.beginAnAcquisition()
        // TODO: REFACTOR BELOW
        AreYouABusinessOrPrivateIndividual.verifyPageDisplayed()
        AreYouABusinessOrPrivateIndividual.selectOptionTwoAndContinue()
        AreYouNotifyingAsPurchaserOrOnBehalf.verifyPageDisplayed()
        AreYouNotifyingAsPurchaserOrOnBehalf.selectOptionOneAndContinue()
        CheckYourAnswers(CYAPage.InitialQuestions).verifyPageUrl()
        CheckYourAnswers(CYAPage.InitialQuestions)
          .checkContentIsCorrect(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
        CheckYourAnswers(CYAPage.InitialQuestions).clickContinue()
        // TODO: ONCE NAVIGATION IS IN PLACE REMOVE THIS
        AddYourDetailsName.navigateToPage(AddYourDetailsName.pageUrl)
        AddYourDetailsName.verifyPageDisplayed()
        AddYourDetailsName.inputUserDetails()
        AddYourDetailsPhoneNumber.verifyPageDisplayed()
        AddYourDetailsPhoneNumber.inputMobileNumber()
        AddYourDetailsEmail.verifyPageDisplayed()
        AddYourDetailsEmail.inputEmailAddress()
      }
    }

    object Import {
      // TODO: BUG CURRENTLY DOESN'T ALLOW THIS FLOW
    }
  }
}
