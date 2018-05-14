package chapter11

/**
  * Created by songdexv on 2018/5/10.
  */
class Matrix(val h: Int, val v: Int) {
  private val matrix = Array.ofDim[Double](h, v)

  def apply(h: Int, v: Int) = matrix(h)(v)

  def update(h: Int, v: Int, value: Double) = matrix(h)(v) = value

  def +(other: Matrix) = {
    require(h == other.h)
    require(v == other.v)

    var res = new Matrix(h, v)
    for (i <- 0 until h; j <- 0 until v) {
      res(i, j) = this.matrix(i)(j) + other.matrix(i)(j)
    }
    res
  }

  def *(factor: Double) = {
    var res = new Matrix(h, v)
    for (i <- 0 until h; j <- 0 until v) {
      res(i, j) = this.matrix(i)(j) * factor
    }
    res
  }

  def -(other: Matrix) = this + other * -1

  private def prod(other: Matrix, i: Int, j: Int) = {
    (for (k <- 0 until v) yield matrix(i)(k) * other.matrix(k)(j)).sum
  }

  def *(other: Matrix) = {
    require(v == other.h)
    require(h == other.v)
    var res = new Matrix(h, other.v)
    for (i <- 0 until h; j <- 0 until other.v) {
      res(i, j) = prod(other, i, j)
    }
    res
  }

  override def toString = matrix.map(_.mkString(" ")).mkString("\n")
}

object MatrixApp extends App {
  val x = new Matrix(2, 3)
  x(0, 0) = 1
  x(0, 1) = 2
  x(0, 2) = 3
  x(1, 0) = 1
  x(1, 1) = 2
  x(1, 2) = 3
  val y = new Matrix(3, 2)
  y(0, 0) = 1
  y(0, 1) = 2
  y(1, 0) = 1
  y(1, 1) = 2
  y(2, 0) = 1
  y(2, 1) = 2
  println(y(1,1))
  println(x * y)

}
