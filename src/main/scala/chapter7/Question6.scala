package chapter7

/**
  * Created by songdexv on 2018/5/7.
  */
object Question6 extends App{
  import java.util.{HashMap => JavaHashMap}


  val javaMap = new JavaHashMap[Int, String]()
  javaMap.put(1, "One")
  javaMap.put(2, "Two")
  javaMap.put(3, "Three")
  javaMap.put(4, "Four")

  import collection.mutable.{HashMap => ScalaHashMap, Map => ScalaMap}
  val scalaMap = new ScalaHashMap[Int,String]()
  for (key <- javaMap.keySet().toArray()){
    scalaMap += (key.asInstanceOf[Int] -> javaMap.get(key))
  }
  println(scalaMap.mkString(" "))
}
