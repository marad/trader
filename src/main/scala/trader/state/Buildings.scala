package trader.state

import Resources._

trait Building {
  def level: Int
}

trait Factory[T >: Resource] {
  def produce(): T
}

trait LinearFactory[T >: Resource] extends Building {
  def produce(): T = level.toFloat
}

case class LumberMill(level: Int) extends Factory[Wood] with LinearFactory[Wood]

case class ClayPit(level: Int) extends Factory[Clay] with LinearFactory[Clay]

case class BrickFactory(level: Int) extends Factory[Bricks] with LinearFactory[Bricks]

case class Farm(level: Int) extends Factory[Grain] with LinearFactory[Grain]


