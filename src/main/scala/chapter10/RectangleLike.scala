package chapter10

import java.awt.Rectangle
import java.awt.geom.Ellipse2D

/**
  * Created by songdexv on 2017/11/29.
  */
trait RectangleLike {
  this: Ellipse2D.Double =>
  def translate(dx: Int, dy: Int): Unit = {
    println("translate dx=%d, dy=%d".format(dx, dy))
    this.x = dx
    this.y = dy
  }

  def grow(h: Int, v: Int): Unit = {
    println("grow h=%d, v=%d".format(h, v))
    this.x += h
    this.y += v
  }
}

object RectangleLike {
  def main(args: Array[String]): Unit = {
    val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    egg.translate(10, -10)
    egg.grow(10, 20)
  }
}
