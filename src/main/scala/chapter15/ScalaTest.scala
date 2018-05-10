package chapter15

import java.io.FileNotFoundException

import scala.annotation.{tailrec, varargs}
import scala.io.Source

/**
  * Created by songdexv on 2017/12/11.
  */
class ScalaTest {
  @varargs
  def sum(nums: Int*): Int = {
    nums.sum
  }

  @throws(classOf[FileNotFoundException])
  def getFileContent(filePath: String): String = {
    Source.fromFile(filePath).mkString
  }

  @tailrec
  private[this] def sum2(xs: Seq[Int], partial: BigInt): BigInt = {
    if (xs.isEmpty) partial else sum2(xs.tail, xs.head + partial)
  }

  def sum3(xs: Seq[Int]): BigInt = {
    sum2(xs, 0)
  }
}

object AnnotationTest {
  def main(args: Array[String]): Unit = {
    val test:ScalaTest = new ScalaTest()
    println(test.sum3(1 to 100000))
  }
}
