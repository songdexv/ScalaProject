import random._

object RandomDemo extends App {
  setSeed(100)
  val intList = for (i <- 1 to 10) yield nextInt()
  println(intList)
  (1 to 10).foreach(x => println(nextDouble()))
}


