package chapter5_basic_type_and_operation


object Literal extends App {

  // 다중 문자열 출력 방법
  // | 문자와 stripMargin 없이 작성하면 공백이 포함됨
  println(
    """
      |Welcome
      |To
      |Scala!
      |""".stripMargin)

  val s = "Hello, world!"
  println(s indexOf ('o', 5))
}
