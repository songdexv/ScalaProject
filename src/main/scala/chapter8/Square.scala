package chapter8

import java.awt.{Rectangle, Point}

/**
  * Created by songdexv on 2018/5/8.
  */
class Square(point: java.awt.Point, width: Int) extends Rectangle(point.x, point.y, width, width) {
  def this() {
    this(new java.awt.Point(0, 0), 0)
  }

  def this(width: Int) {
    this(new java.awt.Point(0, 0), width)
  }
}
