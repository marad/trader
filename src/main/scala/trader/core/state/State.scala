package trader.core.state

import scala.collection.mutable

class State {
  val cities: mutable.Map[String, City] = mutable.Map()

  def findCity(cityName: String) = cities.get(cityName)
}
