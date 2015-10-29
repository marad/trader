import org.widok.Route

package object trader {

  implicit class OptionNavigationExtensions[A](opt: Option[A]) {
    def getOrNavigate(route: Route): A = opt match {
      case Some(value) => value
      case None => route().go(); null.asInstanceOf[A]
    }
  }

}
