package trader

import org.widok._
import org.widok.html._
import org.widok.bindings.Bootstrap._
import org.scalajs.dom

//object Main extends PageApplication {
//  val name = Var("Mori")
//
//  override def view(): View =
//    div(
//      h1("Hello From Widok"),
//      text()
//        .bind(name),
//      p("Hello ", name, "!"),
//      Button("Test")
//        .onClick(e => dom.alert(name.get)),
//      Image("http://lorempixel.com/500/500/people")
//        .responsive(true)
//        .shape(Shape.Circle)
//    )
//
//  override def ready(): Unit = {
//    log("Page loaded")
//  }
//}

object Routes {
  val city = Route("/city/:name", pages.CityPage)
  val shipyard = Route("/city/:city/shipyard", pages.Shipyard)

  val notFound = Route("/404", pages.NotFound)

  val routes = Set(city, shipyard)
}

object Main extends RoutingApplication(
  Routes.routes,
  Routes.city
)