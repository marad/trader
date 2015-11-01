package trader.view.pages

import org.widok._
import org.widok.html._

case class NotFound() extends Page {
  override def ready(route: InstantiatedRoute): Unit = {
  }

  override def view(): View = div("Page Not Found")
}
