package trader.view.widgets

import org.scalajs.dom.html.Element
import trader.core.state.Resources
import org.widok._
import org.widok.html._

case class ResourcesView(resources: ReadChannel[Resources]) extends Widget[ResourcesView] {
  private def spacer = span(" | ")

  private def resource(name: String, amount: ReadChannel[Float]): View = span(name, amount)

  override val rendered: Element = DOM.createElement("span", Seq(
    div(
      resource("Wood: ", resources.flatMap(_.wood)), spacer,
      resource("Bricks: ", resources.flatMap(_.bricks)), spacer,
      resource("Clay: ", resources.flatMap(_.clay)), spacer,
      resource("Wheat: ", resources.flatMap(_.wheat)), spacer,
      resource("Salt: ", resources.flatMap(_.salt)), spacer,
      resource("Raw Meat: ", resources.flatMap(_.rawMeat)), spacer,
      resource("Cotton: ", resources.flatMap(_.cotton)), spacer,
      resource("Bread: ", resources.flatMap(_.bread)), spacer,
      resource("Meat: ", resources.flatMap(_.meat)), spacer,
      resource("Clothes: ", resources.flatMap(_.clothes))
    )
  ))
}