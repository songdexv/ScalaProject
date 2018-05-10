package chapter9

import java.io.PrintWriter

import scala.io.Source

/**
  * Created by songdexv on 2018/5/8.
  */
object Question1 extends App{
  val path = "test.txt"
  val file = Source.fromFile(path,"UTF-8")
  val reversed = file.getLines().toArray.reverse
  val writer = new PrintWriter(path)
  reversed.foreach(line => writer.write(line + "\n"))
  writer.close()
}
