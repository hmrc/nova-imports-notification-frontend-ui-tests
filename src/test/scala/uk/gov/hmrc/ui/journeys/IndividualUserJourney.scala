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
import uk.gov.hmrc.ui.pages.common.{AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, CheckYourAnswers, NotificationTaskList, PurchaserOnBehalfOfABusinessOrIndividual, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney {
  // Acquisition flow
  object Acquisition {
    def notifyingAsAPrivateIndividualAsANotifier(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual, NotificationType.Acquisition)
      CommonJourney.notifierIsAPrivateIndividual()
      CommonJourney.selfNotifying()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      CommonJourney.addYourDetails()
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
      CommonJourney.addVehicleDetails()
      // TODO: Vehicle stuff
    }

    def notifyingAsABusinessAsANotifier(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual, NotificationType.Acquisition)
      CommonJourney.notifierIsABusiness()
      CommonJourney.selfNotifying()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      CommonJourney.addYourDetails()
      CommonJourney.addUserDetailsBusinessNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
      CommonJourney.addVehicleDetails()
    }

    def notifyingAsAIndividualOnBehalfOfBusiness(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual, NotificationType.Acquisition)
      CommonJourney.notifierIsAPrivateIndividual()
      CommonJourney.notifyingForABusiness()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      CommonJourney.addYourDetails()
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
      CommonJourney.addPurchaserDetails()
      CommonJourney.addPurchaserBusinessName()
      CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
      NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
      CommonJourney.addPurchaserAddress()
      CommonJourney.purchaserHasUkDetails()
      NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
      CommonJourney.addVehicleDetails()
    }

    def notifyingAsAIndividualOnBehalfOfIndividual(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual, NotificationType.Acquisition)
      CommonJourney.notifierIsAPrivateIndividual()
      CommonJourney.notifyingForAnIndividual()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      CommonJourney.addYourDetails()
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
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
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual, NotificationType.Acquisition)
      CommonJourney.notifierIsABusiness()
      CommonJourney.notifyingForABusiness()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      CommonJourney.addYourDetails()
      CommonJourney.addUserDetailsBusinessNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
      CommonJourney.addPurchaserDetails()
      CommonJourney.addPurchaserBusinessName()
      CheckYourAnswers(CYAPage.PurchaserDetails).clickContinue()
      NotificationTaskList.verifyAddPurchaserDetailsStatus("Completed")
      CommonJourney.addPurchaserAddress()
      CommonJourney.purchaserHasUkDetails()
      NotificationTaskList.verifyAddPurchaserAddressStatus("Completed")
      CommonJourney.addVehicleDetails()
    }

    def notifyingAsABusinessOnBehalfOfIndividual(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual, NotificationType.Acquisition)
      CommonJourney.notifierIsABusiness()
      CommonJourney.notifyingForAnIndividual()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      CommonJourney.addYourDetails()
      CommonJourney.addUserDetailsBusinessNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
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

  // Import flow
  object Import {
    def userNeedsToImportAVehicleFromOutsideEU(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual, NotificationType.Import)
      VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
    }
  }
}
