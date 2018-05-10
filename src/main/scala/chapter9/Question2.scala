package chapter9

import java.io.PrintWriter

import scala.io.Source

/**
  * Created by songdexv on 2018/5/8.
  */
object Question2 extends App {
  val path = "test.txt"
  val to = "result.txt"
  val fileContent = Source.fromFile(path, "UTF-8").getLines()
  val result = for (line <- fileContent) yield line.replaceAll("\t", "    ")
  val writer = new PrintWriter(to)
  result.foreach(line => writer.write(line + "\n"))
  writer.close()
}
