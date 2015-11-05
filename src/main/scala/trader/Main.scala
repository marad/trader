package trader

import org.widok._

object Main extends Application {
  override def main(): Unit = {
    val router = Router(Routes.routes, fallback = Some(Routes.notFound))
    router.listen()
  }
}
