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

enum AddressPages:
  case Notifier, Purchaser, Supplier

  // Address Lookup Flow screens variations
  def getFindYourAddressPageTitle: String = this match {
    case AddressPages.Notifier  => "Find your address"
    case AddressPages.Purchaser => "Find the purchaser’s address"
    case AddressPages.Supplier  => "Find the supplier’s address"
  }

  def getChooseYourAddressPageTitle: String = this match {
    case AddressPages.Notifier  => "Choose your address"
    case AddressPages.Purchaser => "Choose the purchaser’s address"
    case AddressPages.Supplier  => "Choose the supplier’s address"
  }

  def getManualEntryOfAddressPageTitle: String = this match {
    case AddressPages.Notifier  => "Enter your address"
    case AddressPages.Purchaser => "Enter the purchaser’s address"
    case AddressPages.Supplier  => "Enter the supplier’s address"
  }

  def getSelectYourCountryOrTerritoryPageTitle: String = this match {
    case AddressPages.Notifier  => "Enter the country or territory of your address"
    case AddressPages.Purchaser => "Enter the country or territory of the purchaser’s address"
    case AddressPages.Supplier  => "Enter the country or territory of the supplier’s address"
  }

  def getReviewAndConfirmAddressPageTitle: String = this match {
    case AddressPages.Notifier  => "Review and confirm your address"
    case AddressPages.Purchaser => "Review and confirm the purchaser’s address"
    case AddressPages.Supplier  => "Review and confirm the supplier’s address"
  }

  // NOVA's address screens
  /** As we can have many supplier's we need to decide what number we want returned in the URL for supplier this is
    * decided in "WeHaveChangedYourAddress" page and is defaulted to 1 unless overridden
    */
  def getWeHaveChangedYourAddressUrl(supplierNumber: Int): String = this match {
    case AddressPages.Notifier  => "address-changed"
    case AddressPages.Purchaser => "purchaser-address-changed"
    case AddressPages.Supplier  => s"supplier/$supplierNumber/supplier-address-changed"
  }

  def getWeHaveChangedYourAddressTitle: String = this match {
    case AddressPages.Notifier  => "We’ve changed your address"
    case AddressPages.Purchaser => "We’ve changed the purchaser’s address"
    case AddressPages.Supplier  => "We’ve changed the supplier’s address"
  }
