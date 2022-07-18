package chapter3_scala_basic

object UseList extends App {
    val oneTwoThree = List(1,2,3)

    val test = Map("one" -> 1, "one" -> 2)

    val lst: List[Num] = List(Num("a", "b"), Num("a", "C"), Num("b", "c"), Num("a", "k"))

    val tempMap = lst
      .groupBy(_.key)

    tempMap.foreach(k => {
        println("k : " + k._1)
        k._2.foreach(println)
    })

}
