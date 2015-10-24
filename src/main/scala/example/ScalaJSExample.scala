package example

import example.fragments.Fleet

import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom

@JSExport
object ScalaJSExample {

  @JSExport
  def main(): Unit = {
    val holder = dom.document.getElementById("holder")
    val first = dom.document.createElement("div")
    first.innerHTML = Fleet.create().render
    holder.appendChild(first)

    val second = dom.document.createElement("div")
    second.innerHTML = Fleet.test.render
    holder.appendChild(second)
  }

}
