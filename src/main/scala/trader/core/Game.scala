package trader.core

import trader.core.state.{City, State}
import org.widok.Channel
import org.scalajs.dom

object Game {
  var state: State = null

  val clock = Channel[Tick]()

  resetState()

  dom.setInterval(() => clock := Tick, 1000)

  def resetState() = {
    state = new State
    state.cities += "Bronheim" -> City.generate("Bronheim")
    state.cities += "Woodland" -> City.generate("Woodland")
    state.cities += "Hello" -> City.generate("Hello")
  }

  trait Tick
  case object Tick extends Tick
}
