package trader.view.widgets

import org.scalajs.dom.html.Element
import org.widok._
import org.widok.bindings.Bootstrap._
import trader.view.widgets.ActionList.ActionDesc

case class ActionList(actions: List[ActionDesc], columns: Int = 2) extends Widget[ActionList] {

  override val rendered: Element = DOM.createElement("span", Seq(Grid.Row(
    actions.map(action => {
      Grid.Column(
        Button(action._1)
          .onClick(_ => action._2())
          .width(Length.Percentage(1))
      ).column(Size.Medium, 12 / columns)
    }):_*
  )))

}

object ActionList {
  type Action = () => Any
  type ActionDesc = (String, Action)
}

