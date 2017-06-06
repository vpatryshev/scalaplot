package org.sameersingh.scalaplot

import java.io.File

import org.junit._
import org.sameersingh.scalaplot.Implicits.{output, xyChart}
import org.sameersingh.scalaplot.Style._
import org.sameersingh.scalaplot.gnuplot.GnuplotPlotter

import scala.io.Source
import scala.language.postfixOps

/**
 * Examples that demonstrate how to use the library. Not really tests.
 * @author sameer
 */
@Test
class ExampleLabelTest {

  @Test
  def testLabelsSimple(): Unit = {
    val cities: Iterable[Label] = readCities

    val chart = new LabelChart("France", cities)

    val folder = java.io.File.createTempFile("labelsample", "pdf")
    folder.delete()
    folder.mkdir()
    val folderpath = folder.getCanonicalPath
    println(folderpath)

    val gpl = new GnuplotPlotter(chart)
    println(gpl.string(folderpath, "plot_string"))
    gpl.js(folderpath, "plot_js")
    gpl.svg(folderpath, "plot_svg")
    gpl.html(folderpath, "plot_html")
    gpl.pdf(folderpath, "plot_pdf")
    gpl.png(folderpath, "plot_png")

/*

 */
  }
  
  @Test
  def testLabelsPNG(): Unit = {
    import org.sameersingh.scalaplot.Implicits._

    val cities: Iterable[Label] = readCities

    val chart = new LabelChart("France", cities)

    val folder = java.io.File.createTempFile("labelsample", "pdf")
    folder.delete()
    folder.mkdir()
    val folderpath = folder.getCanonicalPath
    println(folderpath)

    println(output(PNG(folder.getPath, "cities"), chart))
  }

  private def readCities: Iterable[Label] = {
    val Format = "(.+)\\t(\\w+)\\t(\\w+)\\t([^°]+)°\\t([^°]+)°".r

    Source.fromResource("cities.dat").getLines collect {
      case Format(name, _, size, lat, lon) => Label(name, lat.toDouble, lon.toDouble)
    } toList
  }
}
