package chapter13

import scala.collection.SortedMap
import scala.collection.mutable.ArrayBuffer

/**
  * Created by songdexv on 2017/12/1.
  */
object CollectionTest {
  def wordCount(str: String): Unit = {
    val map = str.foldLeft(Map[Char, Int]())((m, c) => m + (c -> (m.getOrElse(c, 0) + 1)))
    println(map)
  }

  def index(str: String): Unit = {
    var i = -1
    val map = str.foldLeft(SortedMap[Char, Set[Int]]())((m, c) => {
      i += 1
      m + (c -> (m.getOrElse(c, Set[Int]()) + i))
    })
    println(map.toString())
  }

  def rmElement(list: List[Int]): Unit = {
    println(list.filter(_ != 0))
  }

  def flatMapTest(array: Array[String], map: Map[String, Int]): Unit = {
    val result = array.flatMap(item => map.get(item))
    println(result.mkString(","))
  }

  def reverse(list: List[Int]): Unit = {
    val r = (list :\ List[Int]()) ((e, l) => l :+ e)
    println(r)
    val r1 = (List[Int]() /: list) ((l, e) => e +: l)
    println(r1)
  }

  def groupedTest(list: List[Int]): Unit = {
    list.sliding(4, 2).foreach(println)
    println("----------------------")
    list.sliding(4, 4).foreach(println)
    println("----------------------")
    list.grouped(4).foreach(println)
    println("----------------------")

    val array = Array(1, 2, 3, 4, 5, 6).grouped(3)
    array.foreach(e => println(e.mkString(",")))
  }

  def tupledTest(): Unit = {
    def multiFunc = (a: Double, b: Int) => {
      a * b
    }

    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)
    val func = Function.tupled(multiFunc)
    prices.zip(quantities).map(func(_)).foreach(println)
  }

  def joinTest(): Unit = {
    val a1 = Array(1, 2, 3, 4, 5)
    val a2 = Array(6, 7, 8, 9, 10)
    val m1 = a1.map(x => (x,x * 2))
    val m2 = a2.map(x => (x,x + 1))

  }

  def main(args: Array[String]): Unit = {
    //    wordCount("Mississippi")
    //    index("Mississippi")
    //    rmElement(List(1, 0, 3, 0, 5, 0, 7, 0))
    //    flatMapTest(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5))
    //    reverse(List(1,3,5,7))
    //    groupedTest(List(1, 2, 3, 4, 5, 6, 7, 8, 9))
    //    tupledTest()
    var list = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
    list += (0)
    println(list)
  }
}
