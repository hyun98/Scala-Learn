package chapter9_flow_control_abstract

import java.io.File

object FileMatcher {

  private def filesHere = (new File(".")).listFiles
  
//  def filesEnding(query: String) =
//    for (file <- filesHere; if file.getName.endsWith(query))
//      yield file
//      
//  def filesContaining(query: String) =
//    for (file <- filesHere; if file.getName.contains(query))
//      yield file
//      
//  def filesRegex(query: String) =
//    for(file <- filesHere; if file.getName.matches(query))
//      yield file
      
  def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file
      
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
      
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
    
  def filesReges(query: String) =
    filesMatching(_.matches(query))
    
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums)
      if (num < 0) exists = true
    exists
  }
  
  
  
}
