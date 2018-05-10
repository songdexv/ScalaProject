package chapter5

/**
  * Created by songdexv on 2017/11/24.
  */
object Chapter5 {
  class Car(val producer:String, val model:String, val year:Int = -1, var license:String = ""){
    println(license)
  }

  def main(args: Array[String]): Unit = {
    var car = new Car("GM","Buick",2016)
    println(car.license)
    car =  new Car("GM","Buick")
    println(car.year)

    val c : Char = 97.asInstanceOf[Char]
    "hello".asInstanceOf[String]
    1.asInstanceOf[Long]
    val it: Seq[String] = List("a", "b")
    it.asInstanceOf[List[String]]

    "hello".isInstanceOf[String]

    classOf[String]
  }
}
