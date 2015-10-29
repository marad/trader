package trader

import trader.state.{City, State}

object Game {
  var state: State = null

  resetState()

  def resetState() = {
    state = new State
    state.cities += "Bronheim" -> City.generate("Bronheim")
    state.cities += "Woodland" -> City.generate("Woodland")
  }
}
