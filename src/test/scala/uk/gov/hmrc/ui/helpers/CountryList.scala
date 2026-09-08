package uk.gov.hmrc.ui.helpers

object CountryList {
  // All current EU member state countries NOVA allows for a supplier
  enum EuCountries:
    case Austria, Belgium, Bulgaria, Croatia, Cyprus, Czechia, Denmark, Estonia, Finland, France, Germany, Greece,
      Hungary,
      Ireland, Italy, Latvia, Lithuania, Luxembourg, Malta, Netherlands, Holland, Poland, Portugal, Romania, Slovakia,
      Slovenia,
      Spain, Sweden

  // Including only a handful of the 249 countries, territories, geographical locations currently listed ISO 3166-1.
  enum NonEuCountries:
    case Afghanistan, Albania, Algeria, Argentina, Australia, Bangladesh, Barbados, Belarus, Canada, Chad, Chile,
      Djibouti,
      Dominica, Ethiopia, Vanuatu, Yemen, Zambia, Zimbabwe
}
