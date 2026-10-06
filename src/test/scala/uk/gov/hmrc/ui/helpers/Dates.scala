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

package uk.gov.hmrc.ui.helpers

import uk.gov.hmrc.ui.pages.supplier.IfYouDoNotHaveAnyOfTheseDatesForTheVehicle
import uk.gov.hmrc.ui.pages.vehicles.{DateOfAvailability, DateOfFirstRegistration, EnterTheCountryWhereTheVehicleWasFirstRegistered, ProvideAReasonWhyAPurchaseInvoiceIsNotAvailable, WhatIsThePurchaseInvoiceDate, WhatIsThePurchaseInvoiceNumber}

object Dates {
  enum SelectedDates:
    case FirstRegistration, MadeAvailable, PurchaseInvoice, ImportEntry, NoDatesProvided
  enum Combinations:
    case One, Two, Three, Four, Five

  /* Based on dates selected we can have five different variations of flows, these methods should allow
  an easy way to validate the pages based on the combinations of checkboxes selected from WhichDatesDoYouHaveForTheVehicle
   */
  val combinations = Map(
    Combinations.One   -> Set(SelectedDates.MadeAvailable, SelectedDates.PurchaseInvoice),
    Combinations.Two   -> Set(SelectedDates.PurchaseInvoice),
    Combinations.Three -> Set(SelectedDates.FirstRegistration, SelectedDates.MadeAvailable),
    Combinations.Four  -> Set(
      SelectedDates.FirstRegistration,
      SelectedDates.MadeAvailable,
      SelectedDates.PurchaseInvoice
    ),
    Combinations.Five  -> Set(SelectedDates.NoDatesProvided)
  )

  def verifyPagesDisplayed(datesSelected: Seq[SelectedDates], notificationType: NotificationType): Unit =
    combinations.collectFirst {
      case (combination, expected) if expected == datesSelected.toSet => combination
    } match
      case Some(Combinations.One)   => dateMadeAvailableAndPurchaseInvoiceDate()
      case Some(Combinations.Two)   => purchaseInvoiceDate()
      case Some(Combinations.Three) => dateOfFirstRegistrationAndDateOfAvailability(notificationType)
      case Some(Combinations.Four)  => allDatesProvided(notificationType)
      case Some(Combinations.Five)  => noDatesProvided()
      case None                     => ???

  private def dateMadeAvailableAndPurchaseInvoiceDate(): Unit = {
    DateOfAvailability().verifyPageDisplayed()
    DateOfAvailability().inputDateOfArrival()
    WhatIsThePurchaseInvoiceDate().verifyPageDisplayed()
    WhatIsThePurchaseInvoiceDate().inputDateOfPurchase()
    WhatIsThePurchaseInvoiceNumber().verifyPageDisplayed()
    WhatIsThePurchaseInvoiceNumber().inputPurchaseInvoiceNumber()
    // TOTAL... ECT TODO
  }

  private def purchaseInvoiceDate(): Unit = {
    WhatIsThePurchaseInvoiceDate().verifyPageDisplayed()
    WhatIsThePurchaseInvoiceDate().inputDateOfPurchase()
    WhatIsThePurchaseInvoiceNumber().verifyPageDisplayed()
    WhatIsThePurchaseInvoiceNumber().inputPurchaseInvoiceNumber()
    // TOTAL... ECT TODO
  }

  private def dateOfFirstRegistrationAndDateOfAvailability(notificationType: NotificationType): Unit = {
    DateOfFirstRegistration(notificationType).verifyPageDisplayed()
    DateOfFirstRegistration(notificationType).inputDateOfRegistration()
    EnterTheCountryWhereTheVehicleWasFirstRegistered(notificationType).verifyPageDisplayed()
    EnterTheCountryWhereTheVehicleWasFirstRegistered(notificationType).enterCountryOfRegistration()
    DateOfAvailability().verifyPageDisplayed()
    DateOfAvailability().inputDateOfArrival()
    ProvideAReasonWhyAPurchaseInvoiceIsNotAvailable().verifyPageDisplayed()
    ProvideAReasonWhyAPurchaseInvoiceIsNotAvailable().inputReasonForNoInvoice()
    // TOTAL... ECT TODO
  }

  private def allDatesProvided(notificationType: NotificationType): Unit = {
    DateOfFirstRegistration(notificationType).verifyPageDisplayed()
    DateOfFirstRegistration(notificationType).inputDateOfRegistration()
    EnterTheCountryWhereTheVehicleWasFirstRegistered(notificationType).verifyPageDisplayed()
    EnterTheCountryWhereTheVehicleWasFirstRegistered(notificationType).enterCountryOfRegistration()
    DateOfAvailability().verifyPageDisplayed()
    DateOfAvailability().inputDateOfArrival()
    WhatIsThePurchaseInvoiceDate().verifyPageDisplayed()
    WhatIsThePurchaseInvoiceDate().inputDateOfPurchase()
    WhatIsThePurchaseInvoiceNumber().verifyPageDisplayed()
    WhatIsThePurchaseInvoiceNumber().inputPurchaseInvoiceNumber()
    // TOTAL... ECT TODO
  }

  private def noDatesProvided(): Unit =
    IfYouDoNotHaveAnyOfTheseDatesForTheVehicle().verifyPageDisplayed()
}
