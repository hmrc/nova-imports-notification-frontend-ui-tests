package uk.gov.hmrc.ui.models

object UserDetails {
  sealed trait Details

  case class BusinessDetails(
                            businessName: String
                            ) extends Details

  case class IndividualUserDetails(
                                  title: String,
                                  firstName: String,
                                  lastName: String
                                  ) extends Details
}
