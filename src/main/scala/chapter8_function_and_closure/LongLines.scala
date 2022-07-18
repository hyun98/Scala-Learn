package chapter8_function_and_closure

import scala.io.Source

class LongLines {
  
  // 중첩 함수
  def processFile(filename: String, width: Int) = {
    
    def processLine(line: String) =
      if (line.length > width) println(filename + ": " + line.trim)
      
    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(line)
  }
  
}
