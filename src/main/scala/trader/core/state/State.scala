package trader.core.state

import scala.collection.mutable
import org.widok.Var

import scala.util.Random

case class City(
            name: String,
            population: Int,
            resources: Resources,
            buildings: List[Building] = List()
            )

object City {
  def generate(name: String): City =
    City(
      name = name,
      population = Random.nextInt(500),
      resources = Resources(wood = Random.nextInt(400), bricks = Random.nextInt(400))
    )

  val empty = City("empty", 0, Resources())
}

class State {
  val cities: mutable.Map[String, City] = mutable.Map()

  def findCity(cityName: String) = cities.get(cityName)
}
