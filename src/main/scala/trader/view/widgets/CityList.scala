package trader.view.widgets

import org.scalajs.dom.html.Element
import org.widok._
import org.widok.bindings.Bootstrap._
import trader.Routes
import trader.core.Game

case class CityList() extends Widget[CityList] {
  val cityList = Game.state.cities.values
    .map(_.name)
    .map(toCityButton)

  val modal: ModalBuilder = ModalBuilder(
    Modal.Header(
      Modal.Close(modal.dismiss)
    , Modal.Title("Cities")
    )
  , Modal.Body(Grid.Row(cityList.toSeq:_*))
  )

  override val rendered: Element = DOM.createElement("span", Seq(modal))

  private def toCityButton(name: String) =
    Grid.Column(
      Button(name)
        .onClick(_ => {
          modal.dismiss()
          Routes.city("name", name).go()
        })
        .width(Length.Percentage(1))
    ).column(Size.Medium, 6)
}
