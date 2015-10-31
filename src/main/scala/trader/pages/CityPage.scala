package trader.pages

import org.widok._
import org.widok.bindings.Bootstrap._
import org.widok.html._
import trader.{Game, Routes}
import trader.Utils.OptionNavigationExtensions
import trader.fragments.{ActionList, CityList, ResourcesView}
import trader.state.City

case class CityPage() extends Page {
  val city = Var(City.empty)

  val possibleActions = List(
    ("Shipyard"       , () => Routes.shipyard("city", city.get.name).go()),
    ("Counting House" , () => org.scalajs.dom.alert("Load counting house")),
    ("Market"         , () => org.scalajs.dom.alert("Load market"))
  )

  val cityList = CityList()

  val cityNameView = h1(city.map(_.name))
  val mapView = h1(
    Button(i().css("fa", "fa-map"))
      .onClick(_ => cityList.modal.open()),
    cityList
  )
  val fleetsView = div("floty")

  val buildingsView = ActionList(possibleActions, columns = 3)

  override def view(): View = div(
    Grid.Row(
      Grid.Column(cityNameView)
        .column(Size.Medium, 11),
      Grid.Column(mapView)
        .column(Size.Medium, 1)
    ),
    Grid.Row(
      Grid.Column(ResourcesView.view(city.map(_.resources)))
        .column(Size.Medium, 12)
    ),
    Grid.Row(
      Grid.Column(fleetsView).column(Size.Medium, 6),
      Grid.Column(buildingsView).column(Size.Medium, 6)
    )
  )

  override def ready(route: InstantiatedRoute): Unit = {
    val cityName = route.args("name")
    city := Game.state.findCity(cityName).getOrNavigate(Routes.notFound)
  }

  override def destroy(): Unit = {
  }
}
