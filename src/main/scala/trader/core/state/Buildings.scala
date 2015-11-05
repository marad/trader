package trader.core.state

import org.widok.{ReadChannel, Var}
import trader.core.Game

case class Ingredient(amount: Int, resource: Var[Float])

case class Recipe(consumes: Seq[Ingredient], produces: Ingredient)

trait RecipeDSL {
  val resources: Resources

  val wood = resources.wood
  val bricks = resources.bricks
  val clay = resources.clay
  val wheat = resources.wheat
  val salt = resources.salt
  val rawMeat = resources.rawMeat
  val cotton = resources.cotton
  val bread = resources.bread
  val meat = resources.meat
  val clothes = resources.clothes

  def generate(amount: Int, resource: Var[Float]): Recipe =
    Recipe(Seq(), Ingredient(amount, resource))

  def use(amount: Int, resource: Var[Float]): Use = Use(Seq(Ingredient(amount, resource)))

  protected case class Use(ingredients: Seq[Ingredient]) {
    def and(amount: Int, resource: Var[Float]): Use = Use(ingredients :+ Ingredient(amount, resource))

    def toCreate(amount: Int, resource: Var[Float]): Recipe =
      Recipe(ingredients, Ingredient(amount, resource))
  }
}

sealed trait JobStatus
case object Working extends JobStatus
case object Suspended extends JobStatus
case object NotEnoughResources extends JobStatus

trait Building extends RecipeDSL {
  val resources: Resources
  def recipe: Recipe
  def name: String

  private var clockSubscription: ReadChannel[Unit] = null
  val status = Var[JobStatus](Working)
  val working = status.map(_ == Working)

  status.attach {
    case Working => clockSubscription = Game.clock.attach(_ => work())
    case Suspended => clockSubscription.dispose()
    case _ =>
  }

  def work(): Unit = {
    if (hasResources) {
      consumeResources()
      produceResources()
    }
  }

  private def hasResources: Boolean =
    recipe.consumes.forall(i => i.resource.get >= i.amount)

  private def consumeResources(): Unit =
    recipe.consumes.foreach(i => i.resource.update(_ - i.amount))

  private def produceResources(): Unit =
    recipe.produces.resource.update(_ + recipe.produces.amount)
}

case class LumberMill(resources: Resources) extends Building {
  val name = "Lumber Mill"
  val recipe = generate(1, wood)
}

case class ClayPit(resources: Resources) extends Building {
  val name = "Clay Pit"
  val recipe = generate(1, clay)
}

case class WheatFarm(resources: Resources) extends Building {
  val name = "Wheat Farm"
  val recipe = generate(1, wheat)
}

case class SaltMine(resources: Resources) extends Building {
  val name = "Salt Mine"
  val recipe = generate(1, salt)
}

case class PigFarm(resources: Resources) extends Building {
  val name = "Pig Farm"
  val recipe = generate(1, rawMeat)
}

case class CottonFarm(resources: Resources) extends Building {
  val name = "Cotton Farm"
  val recipe = generate(1, cotton)
}

case class Brickyard(resources: Resources) extends Building {
  val name = "Brickyard"
  val recipe = use(2, clay) toCreate (1, bricks)
}