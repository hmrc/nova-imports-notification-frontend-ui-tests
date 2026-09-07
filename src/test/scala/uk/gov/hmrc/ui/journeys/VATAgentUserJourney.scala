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

import uk.gov.hmrc.ui.helpers.{AffinityGroup, CYAPage, NotificationType}
import uk.gov.hmrc.ui.pages.common.{CheckYourAnswers, NotificationTaskList}

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
//        CommonJourney.beginAnAcquisition(vatUser = true)
//        CommonJourney.vehicleBroughtInForBusinessUse(AffinityGroup.AgentVAT)
//        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
//        // TODO: TASK LIST
//        CommonJourney.addPhoneAndEmailDetails()
//      }
//
//      def clientNotifyingForPersonalUse(): Unit = {
//        loginSelectClientAndBeginANotification()
//        CommonJourney.beginAnAcquisition(vatUser = true)
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
      def notifyingAsABusinessAsANotifier(): Unit = {
        CommonJourney.loginAndStartANotification(AffinityGroup.AgentVAT, NotificationType.Acquisition)
        CommonJourney.notifierIsABusiness()
        CommonJourney.selfNotifying()
        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
        CommonJourney.addYourDetails()
        CommonJourney.addPhoneAndEmailDetails()
        CheckYourAnswers(CYAPage.YourDetails).clickContinue()
        NotificationTaskList.verifyAddYourDetailsStatus("Completed")
        CommonJourney.addPurchaserDetails()
        CommonJourney.addPurchaserName()
        CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
        NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
        CommonJourney.addPurchaserAddress()
        CommonJourney.purchaserHasUkDetails()
        NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
        CommonJourney.addVehicleDetails()
      }

      def notifyingAsAPrivateIndividualAsANotifier(): Unit = {
        CommonJourney.loginAndStartANotification(AffinityGroup.AgentVAT, NotificationType.Acquisition)
        CommonJourney.notifierIsAPrivateIndividual()
        CommonJourney.selfNotifying()
        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
        CommonJourney.addYourDetails()
        CommonJourney.addPhoneAndEmailDetails()
        CheckYourAnswers(CYAPage.YourDetails).clickContinue()
        NotificationTaskList.verifyAddYourDetailsStatus("Completed")
        CommonJourney.addPurchaserDetails()
        CommonJourney.addPurchaserName()
        CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
        NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
        CommonJourney.addPurchaserAddress()
        CommonJourney.purchaserHasUkDetails()
        NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
        CommonJourney.addVehicleDetails()
      }

      def notifyingAsABusinessOnBehalfOfABusiness(): Unit = {
        CommonJourney.loginAndStartANotification(AffinityGroup.AgentVAT, NotificationType.Acquisition)
        CommonJourney.notifierIsABusiness()
        CommonJourney.notifyingForABusiness()
        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
        CommonJourney.addYourDetails()
        CommonJourney.addPhoneAndEmailDetails()
        CheckYourAnswers(CYAPage.YourDetails).clickContinue()
        NotificationTaskList.verifyAddYourDetailsStatus("Completed")
        CommonJourney.addPurchaserDetails()
        CommonJourney.addPurchaserBusinessName()
        CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
        NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
        CommonJourney.addPurchaserAddress()
        CommonJourney.purchaserHasUkDetails()
        NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
        CommonJourney.addVehicleDetails()
      }

      def notifyingAsABusinessOnBehalfOfAIndividual(): Unit = {
        CommonJourney.loginAndStartANotification(AffinityGroup.AgentVAT, NotificationType.Acquisition)
        CommonJourney.notifierIsABusiness()
        CommonJourney.notifyingForAnIndividual()
        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
        CommonJourney.addYourDetails()
        CommonJourney.addPhoneAndEmailDetails()
        CheckYourAnswers(CYAPage.YourDetails).clickContinue()
        NotificationTaskList.verifyAddYourDetailsStatus("Completed")
        CommonJourney.addPurchaserDetails()
        CommonJourney.addPurchaserName()
        CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
        NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
        CommonJourney.addPurchaserAddress()
        CommonJourney.purchaserHasUkDetails()
        NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
        CommonJourney.addVehicleDetails()
      }

      def notifyingAsAIndividualOnBehalfOfABusiness(): Unit = {
        CommonJourney.loginAndStartANotification(AffinityGroup.AgentVAT, NotificationType.Acquisition)
        CommonJourney.notifierIsAPrivateIndividual()
        CommonJourney.notifyingForABusiness()
        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
        CommonJourney.addYourDetails()
        CommonJourney.addPhoneAndEmailDetails()
        CheckYourAnswers(CYAPage.YourDetails).clickContinue()
        NotificationTaskList.verifyAddYourDetailsStatus("Completed")
        CommonJourney.addPurchaserDetails()
        CommonJourney.addPurchaserBusinessName()
        CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
        NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
        CommonJourney.addPurchaserAddress()
        CommonJourney.purchaserHasUkDetails()
        NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
        CommonJourney.addVehicleDetails()
      }

      def notifyingAsAIndividualOnBehalfOfAIndividual(): Unit = {
        CommonJourney.loginAndStartANotification(AffinityGroup.AgentVAT, NotificationType.Acquisition)
        CommonJourney.notifierIsAPrivateIndividual()
        CommonJourney.notifyingForAnIndividual()
        CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.AgentVAT)
        CommonJourney.addYourDetails()
        CommonJourney.addPhoneAndEmailDetails()
        CheckYourAnswers(CYAPage.YourDetails).clickContinue()
        NotificationTaskList.verifyAddYourDetailsStatus("Completed")
        CommonJourney.addPurchaserDetails()
        CommonJourney.addPurchaserName()
        CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
        NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
        CommonJourney.addPurchaserAddress()
        CommonJourney.purchaserHasUkDetails()
        NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
        CommonJourney.addVehicleDetails()
      }
    }

    object Import {
      // TODO:
    }
  }
}
