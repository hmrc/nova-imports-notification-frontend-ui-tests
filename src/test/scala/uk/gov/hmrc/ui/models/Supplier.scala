package uk.gov.hmrc.ui.models

object Supplier {
  sealed trait Details

  case class BusinessSupplier(
                             businessName: String
                             ) extends Details

  case class IndividualSupplier(
                               title: String,
                               firstName: String,
                               lastName: String
                               ) extends Details
}