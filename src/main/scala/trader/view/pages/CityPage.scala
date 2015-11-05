package trader.view.pages

import org.widok._
import org.widok.bindings.Bootstrap._
import org.widok.html._
import trader.Routes
import Utils.OptionNavigationExtensions
import trader.core.Game
import trader.view.widgets.ActionList.Action
import trader.view.widgets.{MessageBox, ActionList, CityList, ResourcesView}
import trader.core.state._

case class CityPage() extends Page {
  val cityOpt = Opt[City]()

  val messageBox = MessageBox()

  def buildLumberMill(): Unit = {
    cityOpt.partialMap { case city => city.buildings += new LumberMill(city.resources) }
  }

  def createBuildingAction(buildingCreator: Resources => Building): Action = () => {
    println("Building...")
    cityOpt.partialMap { case city => city.buildings += buildingCreator(city.resources) }
  }

  val possibleActions = List(
    ("Shipyard"       , () => cityOpt.partialMap({ case city => Routes.shipyard("city", city.name).go()})),
    ("Counting House" , () => org.scalajs.dom.alert("Load counting house")),
    ("Market"         , () => org.scalajs.dom.alert("Load market")),
    ("Build Lumber Mill", createBuildingAction(LumberMill)),
    ("Build Brickyard", createBuildingAction(Brickyard)),
    ("Build ClayPit", createBuildingAction(ClayPit)),
    ("Open MessageBox", () => messageBox.open("My Title", "My message"))
  )

  val cityList = CityList()

  val cityNameView = h1(cityOpt.map(_.name))
  val mapView = h1(
    Button(i().css("fa", "fa-map"))
      .onClick(_ => cityList.modal.open()),
    cityList
  )
  val fleetsView = div("floty")

  val actionsView = ActionList(possibleActions, columns = 3)
  val buildingsView = div(
    cityOpt.flatMapBuf(_.buildings).map { case building =>
      div(
        building.name,
        Button("Go").onClick(_ => building.status := Working).hide(building.working),
        Button("Pause").onClick(_ => building.status := Suspended).show(building.working)
      )
    }
  )

  override def view(): View = div(
    Grid.Row(
      Grid.Column(cityNameView)
        .column(Size.Medium, 11),
      Grid.Column(mapView)
        .column(Size.Medium, 1)
    ),
    Grid.Row(
      Grid.Column(ResourcesView(cityOpt.map(_.resources)))
        .column(Size.Medium, 12)
    ),
    Grid.Row(
      Grid.Column(fleetsView).column(Size.Medium, 6),
      Grid.Column(actionsView).column(Size.Medium, 6),
      Grid.Column(buildingsView).column(Size.Medium, 6)
    ),
    messageBox
  )

  override def ready(route: InstantiatedRoute): Unit = {
    val cityName = route.args("name")
    cityOpt := Game.state.findCity(cityName).getOrNavigate(Routes.notFound)
  }

  override def destroy(): Unit = {
  }
}
