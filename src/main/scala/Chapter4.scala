import java.io.File
import java.util
import java.util.Scanner

import scala.collection.{JavaConverters, mutable}

/**
  * Created by songdexv on 2017/11/22.
  */
object Chapter4 {
  def main(args: Array[String]): Unit = {
    val prices = Map("apple" -> 6.8d, "orange" -> 2.5d)
//    println(discount(prices))
//    println(wordcount("C:\\Users\\songdexv\\Downloads\\test.txt"))
//    println(wordcount1("C:\\Users\\songdexv\\Downloads\\test.txt"))
//    println(wordcount2("C:\\Users\\songdexv\\Downloads\\test.txt"))
    println(wordcount3("C:\\Users\\songdexv\\Downloads\\test.txt"))
//    println("Hello".zip("World"))
  }

  def discount(map: Map[String, Double]): Map[String, Double] = {
    for ((k, v) <- map) yield (k, v * 0.9)
  }

  def wordcount(filePath: String): mutable.HashMap[String,Int] = {
    val map = new mutable.HashMap[String,Int]
    val in = new Scanner(new File(filePath))
    var word = ""
    while (in.hasNext()){
      word = in.next()
      if (map.contains(word)){
        map(word) = map(word) + 1
      }else{
        map(word) = 1
      }
    }
    map
  }

  def wordcount1(filePath: String): Map[String,Int] = {
    var map = Map[String,Int]()
    val in = new Scanner(new File(filePath))
    var word = ""
    while (in.hasNext()){
      word = in.next()
      if(map.contains(word)){
        map = map + (word -> (map.getOrElse(word,0) + 1))
      }else{
        map = map + (word -> 1)
      }
    }
    map
  }

  def wordcount2(filePath: String): mutable.TreeMap[String,Int] = {
    val map = new mutable.TreeMap[String,Int]()
    val in = new Scanner(new File(filePath))
    var word = ""
    while (in.hasNext()){
      word = in.next()
      if (map.contains(word)){
        map(word) = map(word) + 1
      }else{
        map(word) = 1
      }
    }
    map
  }

  def wordcount3(filePath: String): mutable.Map[String,Int] = {
    val map: mutable.Map[String,Int] = JavaConverters.mapAsScalaMap(new util.TreeMap[String,Int]())
    val in = new Scanner(new File(filePath))
    var word = ""
    while (in.hasNext()){
      word = in.next()
      if (map.contains(word)){
        map(word) = map(word) + 1
      }else{
        map(word) = 1
      }
    }
    map
  }
}
