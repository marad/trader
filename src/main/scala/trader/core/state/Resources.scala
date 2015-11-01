package trader.core.state

trait Resource

case class Wood(amount: Float) extends AnyVal

case class Clay(amount: Float) extends AnyVal

case class Wheat(amount: Float) extends AnyVal

case class Salt(amount: Float) extends AnyVal

case class RawMeat(amount: Float) extends AnyVal

case class Cotton(amount: Float) extends AnyVal

case class Bricks(amount: Float) extends AnyVal

case class Bread(amount: Float) extends AnyVal

case class Meat(amount: Float) extends AnyVal

case class Clothes(amount: Float) extends AnyVal

case class Resources(
                      wood: Wood = Wood(0),
                      bricks: Bricks = Bricks(0)
                      //                      clay: Clay = 0,
                      //                      grain: Grain = 0,
                      //                      wool: Wool = 0,
                      //                      ironOre: IronOre = 0,
                      //                      salt: Salt = 0,
                      //                      tools: Tools = 0,
                      //                      beer: Beer = 0,
                      //                      fish: Fish = 0,
                      //                      milk: Milk = 0,
                      //                      cheese: Cheese = 0,
                      //                      meat: Meat = 0
                      )

