package chapter7_inner_control_syntax

import java.io.File

object Control extends App {
  val filename =
    if (!args.isEmpty) args(0)
    else "default.txt"
    
  val filesHere = (new File(".")).listFiles
  for (file <- filesHere)
    println(file)
    
  for (i <- 1 to 4)
    println(i)
    
  for (i <- 1 until 4)
    println(i)
    
  for (file <- filesHere if file.getName.endsWith(".sbt"))
    println(file)
    
  def searchFrom(i: Int): Int = {
    if (i >= args.length) -1
    else if (args(i).startsWith("-")) searchFrom(i + 1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(i + 1)
  }
  
  val i = searchFrom(0)
  println(i)
  
  
  // functional code refactoring
  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
    
  def makeRow(row: Int) = makeRowSeq(row).mkString
  
  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }
  
  println(makeRowSeq(10))
  println(makeRow(10))
  println(multiTable)
  
}
