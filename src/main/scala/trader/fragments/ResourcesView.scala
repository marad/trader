package trader.fragments

import trader.core.state.Resources
import org.widok._
import org.widok.html._

object ResourcesView {
  val spacer = span(" ")
  def resource(name: String, amount: ReadChannel[Float]): View = span(name, amount)

  def view(resources: ReadChannel[Resources]): View = div(
    resource("Wood: ", resources.map(_.wood)), spacer,
    resource("Bricks: ", resources.map(_.bricks))
  )
}
