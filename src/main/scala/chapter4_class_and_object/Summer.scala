package chapter4_class_and_object

import models.CheckSumAccumulator.calculate

object Summer {
  def main(args: Array[String]) = {
    for (arg <- args) println(arg + ": " + calculate(arg))
  }
}
