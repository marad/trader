package trader.view.widgets

import org.scalajs.dom.html.Element
import org.widok._
import org.widok.bindings.Bootstrap._

case class MessageBox() extends Widget[MessageBox] {

  val title = Var("Message")
  val message = Var("Message")


  private val modal: ModalBuilder = ModalBuilder(
    Modal.Header(
      Modal.Close(modal.dismiss),
      Modal.Title(title)
    ),
    Modal.Body(message),
    Modal.Footer(
      Button("OK").onClick(_ => modal.dismiss())
    )
  )

  override val rendered: Element = DOM.createElement("span", Seq(modal))

  def open(title: String, message: String): Unit = {
    this.title := title
    this.message := message
    modal.open()
  }

  def close(): Unit = modal.dismiss()
}
