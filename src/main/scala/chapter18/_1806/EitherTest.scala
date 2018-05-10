package chapter18._1806

/**
  * Created by songdexv on 2017/12/21.
  */
object EitherTest {
  def getIndex(arr: Seq[Int], v: Int): Int Either Int = {
    if (arr.contains(v)) {
      Left(arr.indexOf(v))
    } else {
      Right(arr.indexOf(arr.reduce((a, b) => if (math.abs(v - a) > math.abs(v - b)) b else a)))
    }
  }

  def main(args: Array[String]): Unit = {
    println(getIndex(Seq(2, 3, 4, 5, -2, -3), 6))
  }
}
