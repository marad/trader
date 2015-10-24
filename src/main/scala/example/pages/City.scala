package example.pages

import example.Routes
import org.widok._
import org.widok.html._
import org.widok.bindings.Bootstrap._

case class City() extends Page {
  val cityName = Var("")

  override def view(): View = div(
    h1(cityName),
    Button("Go to shipyard")
      .onClick(_ => Routes.shipyard("city", cityName.get).go())
  )

  override def ready(route: InstantiatedRoute): Unit = {
    cityName := route.args("name")
    log("City page loaded")
  }

  override def destroy(): Unit = {
    log("City page unloaded")
  }
}
