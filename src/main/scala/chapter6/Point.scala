package chapter6

/**
  * Created by songdexv on 2018/5/7.
  */
class Point(x: Int, y: Int) {
  def draw(): Unit = {
    println(s"($x, $y)")
  }
}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

