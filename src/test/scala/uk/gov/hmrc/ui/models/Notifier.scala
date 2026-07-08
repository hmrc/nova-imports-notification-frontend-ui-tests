package uk.gov.hmrc.ui.models

object Notifier {
  case class NotifierDetails(
                            userDetails: UserDetails.IndividualUserDetails,
                            phoneNumber: Option[String],
                            mobileNumber: Option[String],
                            email: String
                            )
}
