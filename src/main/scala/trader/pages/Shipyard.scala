package trader.pages

import org.widok._
import org.widok.html._

case class Shipyard() extends Page {
  val cityName = Var("")

  override def view(): View = h1(cityName, " > Shipyard")

  override def ready(route: InstantiatedRoute): Unit = {
    cityName := route.args("city")
    log("Shipyard loaded")
  }

  override def destroy(): Unit = {
    log("Shipyard unloaded")
  }
}
