
import top._

val bookingService = BookingService(
  Hotel("Lakewood", 3, Map(
    Category(Regular, Weekday) -> 110,
    Category(Rewards, Weekday) -> 80,
    Category(Regular, Weekend) -> 90,
    Category(Rewards, Weekend) -> 80
  )),
  Hotel("Bridgewood", 4, Map(
    Category(Regular, Weekday) -> 160,
    Category(Rewards, Weekday) -> 110,
    Category(Regular, Weekend) -> 60,
    Category(Rewards, Weekend) -> 50
  )),
  Hotel("Ridgewood", 5, Map(
    Category(Regular, Weekday) -> 220,
    Category(Rewards, Weekday) -> 100,
    Category(Regular, Weekend) -> 150,
    Category(Rewards, Weekend) -> 40
  ))
)

val bookingRequests = Seq(
  BookingRequest(Regular, Seq(Weekday, Weekday, Weekday)),
  BookingRequest(Regular, Seq(Weekday, Weekend, Weekend)),
  BookingRequest(Rewards, Seq(Weekday, Weekday, Weekend))
)

bookingRequests.map(bookingService.findBestHotel)
