package trader

import org.widok.Route
import view.pages._

object Routes {
  val city = Route("/city/:name", CityPage)
  val shipyard = Route("/city/:city/shipyard", Shipyard)

  val notFound = Route("/404", NotFound)

  val routes = Set(city, shipyard)
}
