package org.sameersingh.scalaplot

/**
  * A chart consisting of a cloud of labels
  * Created by vpatryshev on 6/5/17.
  */
class LabelChart(chartTitle: Option[String], val data: Iterable[Label],
                 val x: NumericAxis = new NumericAxis, 
                 val y: NumericAxis = new NumericAxis) extends Chart {
  
  def this(title: String, data: Iterable[Label]) = this(Some(title), data)
}

