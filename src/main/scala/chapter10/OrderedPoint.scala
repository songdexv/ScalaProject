package chapter10

import java.awt.Point

/**
  * Created by songdexv on 2017/11/29.
  */
class OrderedPoint extends Point with Ordered[Point] {
  def this(x: Int, y: Int) {
    this()
    this.x = x
    this.y = y
  }

  override def compare(that: Point): Int = {
    if (this.x < that.x) -1
    else if (this.x == that.x && this.y == that.y) 0
    else 1
  }
}

object OrderedPoint {
  def main(args: Array[String]): Unit = {
    val p1 = new OrderedPoint(2, 2)
    val p2 = new OrderedPoint(1, 3)
    println(p1 < p2)
    println(p1.isInstanceOf[Point])

  }
}
