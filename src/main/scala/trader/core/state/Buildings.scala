package trader.core.state

import scala.concurrent.duration._

//trait Building {
//  def level: Int
//}
//
//trait Factory[T >: Resource] {
//  def produce(): T
//}
//
//trait LinearFactory[T >: Resource] extends Building {
//  def produce(): T = level.toFloat
//}
//
//case class LumberMill(level: Int) extends Factory[Wood] with LinearFactory[Wood]
//
//case class ClayPit(level: Int) extends Factory[Clay] with LinearFactory[Clay]
//
//case class BrickFactory(level: Int) extends Factory[Bricks] with LinearFactory[Bricks]
//
//case class Farm(level: Int) extends Factory[Grain] with LinearFactory[Grain]

trait Producer[Material >: Resource] {
  def productionTime: Duration
  def produce(resources: Resources): (Resources, Material)
}

trait ResourceGenerator {
  def consumeResources(resources: Resources) = resources
}

abstract class Building[Material >: Resource with AnyVal](materialCreator: Float => Material) extends Producer[Material] {
  def consumeResources(resources: Resources): Resources

  def produce(resources: Resources): (Resources, Material) =
    (consumeResources(resources), materialCreator(1))
}

object LumberMill extends Building[Wood](Wood) with ResourceGenerator {
  val productionTime = 1 second
}

object ClayPit extends Building[Clay](Clay) with ResourceGenerator {
  val productionTime = 1 second
}

object WheatFarm extends Building[Wheat](Wheat) with ResourceGenerator {
  val productionTime = 1 second
}

object SaltMine extends Building[Salt](Salt) with ResourceGenerator {
  val productionTime = 1 second
}

object PigFarm extends Building[RawMeat](RawMeat) with ResourceGenerator {
  val productionTime = 1 second
}

object CottonFarm extends Building[Cotton](Cotton) with ResourceGenerator {
  val productionTime = 1 second
}
