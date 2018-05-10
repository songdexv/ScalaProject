package chapter9

import java.io.File

/**
  * Created by songdexv on 2018/5/8.
  */
object Question9 extends App {
  def countClass(dir: File): Int = {
    var num:Int = 0
    val files = dir.listFiles();
    num += files.filter(_.isFile).count(_.getName.endsWith(".class"))
    files.filter(_.isDirectory).foreach(num += countClass(_))
    num
  }

  val path:String = """D:\GitRepository\ScalaProject\target\scala-2.12\classes""";
  println(countClass(new File(path)))
}
