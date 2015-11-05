package trader.core.state

import scala.util.Random
import org.widok.{Var, Buffer}

object City {
  def generate(name: String): City =
    City(
      name = name,
      population = Var(Random.nextInt(500)),
      resources = Resources(
        wood = Var(Random.nextInt(400)),
        bricks = Var(Random.nextInt(400))
      )
    )
}

case class City(
                 name: String,
                 population: Var[Int],
                 resources: Resources,
                 buildings: Buffer[Building] = Buffer()
                 )
