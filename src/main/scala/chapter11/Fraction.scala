package chapter11

/**
  * Created by songdexv on 2017/11/29.
  */
class Fraction(n: BigInt, d: BigInt) {
  val num = n
  val den = d


  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  override def toString: String = {
    num + "/" + den
  }
}

object Fraction {
  def apply(n: BigInt, d: BigInt): Fraction = new Fraction(n, d)

  def unapply(arg: Fraction): Option[(BigInt, BigInt)] = if (arg.den == 0) None else Some((arg.num, arg.den))

  def main(args: Array[String]): Unit = {
    val f1 = Fraction(1, 2)
    val f2 = Fraction(3, 4)
    println(f1 * f2)
    val f3 = f1 * f2
    val Fraction(num, den) = f3
    println(num + "/" + den)

    println(3 + 4 -> 5)
    println(3 -> (4 + 5))
  }
}

