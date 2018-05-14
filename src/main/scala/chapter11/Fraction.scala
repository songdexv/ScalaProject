package chapter11

/**
  * Created by songdexv on 2017/11/29.
  */
class Fraction(n: Int, d: Int) {
  val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) Math.abs(a) else gcd(b, a % b)

  def +(other: Fraction) = new Fraction(this.num * other.den + other.num * this.den, this.den * other.den)

  def -(other: Fraction) = new Fraction(this.num * other.den - other.num * this.den, this.den * other.den)

  def *(other: Fraction) = new Fraction(this.num * other.num, this.den * other.den)

  def /(other: Fraction) = new Fraction(this.num * other.den, this.den * other.num)

  override def toString: String = {
    num + "/" + den
  }
}

object Fraction {
  def apply(n: Int, d: Int): Fraction = new Fraction(n, d)

  def unapply(arg: Fraction): Option[(Int, Int)] = if (arg.den == 0) None else Some((arg.num, arg.den))

  def main(args: Array[String]): Unit = {
    val f = Fraction(15,-6)
    val p = Fraction(20,60)
    println(f)
    println(p)
    println(f + p)
    println(f - p)
    println(f * p)
    println(f / p)
  }
}

