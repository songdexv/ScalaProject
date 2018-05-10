package chapter9

import scala.io.Source

/**
  * Created by songdexv on 2018/5/8.
  */
object Question8 extends App {
  val pattern = """<img[^>]+(src\s*=\s*"[^>^"]+")[^>]*>""".r
  val source = Source.fromURL("http://www.vernonzheng.com", "utf-8").mkString
  for (pattern(src) <- pattern.findAllIn(source)) println(src)
}
