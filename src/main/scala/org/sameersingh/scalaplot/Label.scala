package org.sameersingh.scalaplot

/**
  * Label class - consists of text and coordinates
  * 
  * Created by vpatryshev on 6/5/17.
  */
case class Label(text: String, x: Double, y: Double) {
  def gpl = s"$text,$x,$y"
}
