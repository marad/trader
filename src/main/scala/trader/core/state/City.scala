package trader.core.state

import scala.util.Random

object City {
  def generate(name: String): City =
    City(
      name = name,
      population = Random.nextInt(500),
      resources = Resources(
        wood = Wood(Random.nextInt(400)),
        bricks = Bricks(Random.nextInt(400))
      )
    )

  val empty = City("empty", 0, Resources())
}

case class City(
                 name: String,
                 population: Int,
                 resources: Resources,
                 buildings: List[Building] = List()
                 )

