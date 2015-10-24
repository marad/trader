package example.fragments

import scalatags.Text.all._

object Fleet {

  def create() =
      div(
        h1("Hello World"),
        div(
          p("This is first paragraph"),
          p("This is second paragraph")
        )
      )

  def test = div(
    h1("Kolejny"),
    p("Jakiś tam paragraf"),
    p("Zażółć gęślą jaźń")
  )
}
