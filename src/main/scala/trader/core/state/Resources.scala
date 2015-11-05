package trader.core.state

import org.widok.Var

case class Resources(
                      wood    : Var[Float] = Var(0),
                      bricks  : Var[Float] = Var(0),
                      clay    : Var[Float] = Var(0),
                      wheat   : Var[Float] = Var(0),
                      salt    : Var[Float] = Var(0),
                      rawMeat : Var[Float] = Var(0),
                      cotton  : Var[Float] = Var(0),
                      bread   : Var[Float] = Var(0),
                      meat    : Var[Float] = Var(0),
                      clothes : Var[Float] = Var(0)
                      )

