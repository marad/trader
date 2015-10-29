package trader.state

import Resources._

object Resources {
  type Resource = Float
  type Wood = Resource
  type Clay = Resource
  type Bricks = Resource
  type Grain = Resource
  type Wool = Resource
  type IronOre = Resource
  type Salt = Resource
  type Tools = Resource
  type Beer = Resource
  type Fish = Resource
  type Milk = Resource
  type Cheese = Resource
  type Meat = Resource
}

case class Resources(
                      wood: Wood = 0,
                      bricks: Bricks = 0
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

