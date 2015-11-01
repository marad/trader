package trader.view.pages

import org.widok.Route

object Utils {
  implicit class OptionNavigationExtensions[A](opt: Option[A]) {
    def getOrNavigate(route: Route): A = opt match {
      case Some(value) => value
      case None => route().go(); null.asInstanceOf[A]
    }
  }
}
