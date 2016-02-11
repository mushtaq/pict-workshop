package top

trait Day
case object Weekday extends Day
case object Weekend extends Day

trait Customer
case object Regular extends Customer
case object Rewards extends Customer

case class Category(customer: Customer, day: Day)

case class Hotel(name: String, rating: Int, tariff: Map[Category, Int]) {
  def costOf(bookingRequest: BookingRequest): Int =
    bookingRequest.categories.map(tariff).sum
}

case class BookingService(hotels: Hotel*) {
  def findBestHotel(bookingRequest: BookingRequest): String =
    hotels.minBy(h => (h.costOf(bookingRequest), -h.rating)).name
}

case class BookingRequest(customer: Customer, days: List[Day]) {
  def categories: List[Category] = days.map(day => Category(customer, day))
}
