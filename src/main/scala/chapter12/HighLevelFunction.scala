package chapter12

import scala.collection.mutable.ArrayBuffer

/**
  * Created by songdexv on 2017/11/30.
  */
object HighLevelFunction {
  def values(fun: (Int) => Int, low: Int, high: Int): ArrayBuffer[(Int, Int)] = {
    val array = new ArrayBuffer[(Int, Int)]()
    for (i <- low to high) {
      array.append((i, fun(i)))
    }
    array
  }

  def factor(n: Int): Int = {
    (1 to n).reduceLeft(_ * _)
    //    (1 to n).foldLeft(2)(_ * _)
  }

  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.map(fun(_)).reduceLeft(math.max(_, _))
  }

  def largest2(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    val tuple = inputs.map((x) => (x, fun(x))).reduceLeft((y, z) => if (y._2 >= z._2) y else z)
    tuple._1
  }

  def adjustToPair(fun: (Int, Int) => Int) = (x: (Int, Int)) => fun(x._1, x._2)

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  def main(args: Array[String]): Unit = {
    val result = values(x => x * x, -5, 5)
    println(result.toString)

    val maxValue = Array(3, 10, 2, 5, -1, 0, 4, 6).reduceLeft((x, y) => math.max(x, y))
    println(maxValue)
    println(factor(5))
    println(largest(x => 10 * x - x * x, 1 to 10))
    println(largest2(x => 10 * x - x * x, 1 to 10))
    println(adjustToPair(_ * _)((6, 7)))

    var x = 10
    until(x == 0) {
      x -= 1
      println(x)
    }
  }
}
