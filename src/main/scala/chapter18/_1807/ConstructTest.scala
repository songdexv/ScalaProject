package chapter18._1807

/**
  * Created by songdexv on 2017/12/21.
  */
object ConstructTest {
  def tryWithClose[T <: {def close() : Unit}](obj: T, func: T => Unit) = {
    try {
      func(obj)
    } finally {
      obj.close()
    }
  }

  def printValues(f: {def apply(param: Int): Int}, from: Int, to: Int) = {
    for (i <- from to to) {
      print(f.apply(i) + " ")
    }
  }

  def main(args: Array[String]): Unit = {
    printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6) //将打印 3 5 8 13
    println("-----------------")
    printValues((x: Int) => x * x, 3, 6) //将打印 9 16 25 36
  }
}
