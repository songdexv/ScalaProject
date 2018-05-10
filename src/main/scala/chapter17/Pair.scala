package chapter17

import scala.reflect.ClassTag

/**
  * Created by songdexv on 2017/12/14.
  */
class Pair[T, S](val first: T, val second: S) {
  def swap() = new Pair(second, first)
}

class Pair2[T](val first: T, val second: T) {
  def swap() = new Pair2(second, first)
}

class Pair3[T, S](val first: T, val second: S) {

}


object Pair {
  def swap3[T, S](first: T, second: S) = new Pair3(second, first)

  def middle[T: ClassTag](iter: Iterable[T]): T = {
    val seq = iter.toArray
    seq(seq.length / 2)
  }

  def mkArray[T: Manifest](first: T, second: T): Array[T] = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }

  def mkArray2[T: ClassTag](first: T, second: T): Array[T] = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }

  def main(args: Array[String]): Unit = {
    var p1 = new Pair(1, "2")
    var p11 = p1.swap
    println(p11.first + " " + p11.second)
    var p2 = new Pair2(1, "2")
    var p21 = p2.swap()
    println(p21.first + " " + p21.second)
    var p3 = new Pair3(1, "2")
    var p31 = swap3(1, "2")
    println(p31.first + " " + p31.second)
    println(middle("World"))
    println("------------------------")
    println(mkArray(1, "2").mkString("<",",",">"))
    println(mkArray2("3", 4).mkString("<",",",">"))
  }
}
