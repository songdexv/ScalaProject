package package14

import scala.reflect.ClassTag

/**
  * Created by songdexv on 2017/12/6.
  */
object Exercise {
  def swap(pair: (Int, Int)) = {
    var r = pair match {
      case (x, y) => (y, x)
      case _ => None
    }
    println(r)
  }

  def swap[T:ClassTag](array: Array[T]) = {
    val r = array match {
      case Array(x, y, rest@_*) if array.length >= 2 => Array(y, x) ++ rest
      case _ => array
    }
    println(r.mkString(","))
  }

  def main(args: Array[String]): Unit = {
//    swap((1, 2))
    swap(Array[Int](1, 2, 3, 4, 5))
  }
}
