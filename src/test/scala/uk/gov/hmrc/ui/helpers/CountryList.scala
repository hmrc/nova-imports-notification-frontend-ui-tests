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

import scala.util.Random

object CountryList {
  // Get a random country from a combined list of EU countries & Non-EU countries
  sealed trait Countries
  private val allCountries: Seq[Countries] = EuCountries.values.toSeq ++ NonEuCountries.values.toSeq
  def randomCountry(): Countries           = allCountries(Random.nextInt(allCountries.size))

  // All current EU member state countries NOVA allows for a supplier
  enum EuCountries extends Countries:
    case Austria, Belgium, Bulgaria, Croatia, Cyprus, Czechia, Denmark, Estonia, Finland, France, Germany, Greece,
      Hungary,
      Ireland, Italy, Latvia, Lithuania, Luxembourg, Malta, Netherlands, Holland, Poland, Portugal, Romania, Slovakia,
      Slovenia,
      Spain, Sweden

  // Including only a handful of the 249 countries, territories, geographical locations currently listed ISO 3166-1.
  enum NonEuCountries extends Countries:
    case Afghanistan, Albania, Algeria, Argentina, Australia, Bangladesh

  // Get currency used for purchase of vehicle
  def getEuCurrency(country: EuCountries): String = country match {
    case EuCountries.Bulgaria  => "Bulgarian lev (BGN)"
    case EuCountries.Croatia   => "Czech koruna (CZK)"
    case EuCountries.Denmark   => "Danish krone (DKK)"
    case EuCountries.Lithuania => "Lithuanian litas (LTL)"
    case EuCountries.Poland    => "Polish złoty (PLN)"
    case EuCountries.Romania   => "Romanian leu (RON)"
    case EuCountries.Sweden    => "Swedish krona (SEK)"
    case _                     => "Euro (EUR)"
  }

  def getNonEuCurrency(country: NonEuCountries): String = country match {
    case NonEuCountries.Afghanistan => "Afghani (AFN)"
    case NonEuCountries.Albania     => "Albanian lek (ALL)"
    case NonEuCountries.Algeria     => "Algerian dinar (DZD)"
    case NonEuCountries.Argentina   => "Argentine peso (ARS)"
    case NonEuCountries.Australia   => "Australian dollar (AUD)"
    case NonEuCountries.Bangladesh  => "Bangladeshi taka (BDT)"
  }
}
