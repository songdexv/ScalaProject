import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Created by songdexv on 2017/11/22.
  */
object Chapter3 {
  def main(args: Array[String]): Unit = {
    //    arrayBufferTest()
    //    println(random(10).mkString(","))
    //    println(swap(Array(1,2,3,4,5,6)).mkString(","))
    //    println(swap2(Array(1,2,3,4,5,6)).mkString(","))
    println(swap2(Array(1, 2, 3, 4, 5)))
    println(swap2(Array(1, 2, 3, 4, 5, 6)))
    println(swap3(Array(1, -2, 3, 4, -5, -6, 0)))
    println(avg(Array(1.0d, 2.0d, 3.0d, 4.0d): _*))
  }

  def arrayBufferTest(): Unit = {
    val b = ArrayBuffer[Int]()
    b += 1
    println(b)
    b += (1, 2, 3, 4, 5)
    println(b)
    b ++= Array(8, 13, 21)
    println(b)
    b.trimEnd(5)
    println(b)
    b.insert(2, 6)
    println(b)
    b.insert(2, 7, 8, 9)
    println(b)
    b.remove(2)
    println(b)
    b.remove(2, 3)
    println(b)
  }

  def random(n: Int): Array[Int] = {
    val a = new Array[Int](n)
    for (i <- 0 until n)
      a(i) = Random.nextInt(n)
    a
  }

  def swap(a: Array[Int]): Array[Int] = {
    for (i <- 0 until(a.length, 2)) {
      if (i < a.length - 1) {
        val t = a(i)
        a(i) = a(i + 1)
        a(i + 1) = t
      }
    }
    a
  }

  def swap2(a: Array[Int]): IndexedSeq[Int] = {
    var first = true
    var t = a(0)
    val b = for (i <- 0 until a.length) yield {
      if (i < a.length - 1) {
        if (first) {
          t = a(i)
          first = false
          a(i + 1)
        } else {
          first = true
          t
        }
      } else {
        if (first)
          a(i)
        else
          t
      }
    }
    b
  }

  def swap3(a: Array[Int]): ArrayBuffer[Int] = {
    val index = for (i <- 0 until a.length if a(i) > 0) yield {
      i
    }
    val b = new ArrayBuffer[Int]()
    val c = new ArrayBuffer[Int]()
    for (i <- 0 until a.length) {
      if (index.contains(i)) {
        c += a(i)
      } else {
        b += a(i)
      }
    }
    c ++= b
    c
  }

  def avg(nums: Double*): Double = {
    var sum = 0d
    for (num <- nums) sum += num
    sum / nums.length
  }
}
