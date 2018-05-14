package chapter21

import chapter11.Fraction

/**
  * Created by songdexv on 2017/12/25.
  */
case class Person(name: String, age: Int) {
  override def toString: String = {
    "name: " + name + ", age: " + age
  }
}


object ImplicitTest {
  implicit def fractionToOrdered(fraction: Fraction): Ordered[Fraction] = {
    new Ordered[Fraction] {
      override def compare(that: Fraction): Int = {
        val lcm: Int = (fraction.den * that.den).abs / fraction.gcd(fraction.den,that.den)
        val n1 = fraction.num * (lcm / fraction.den)
        val n2 = that.num * (lcm / that.den)
        n1.compare(n2)
      }
    }
  }

  implicit object PersonOrdering extends Ordering[Person] {
    override def compare(p1: Person, p2: Person): Int = {
      p1.name == p2.name match {
        case false => -p1.name.compareTo(p2.name)
        case _ => p1.age - p2.age
      }
    }
  }

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if (a < b) a else b

  def main(args: Array[String]): Unit = {
    val f1 = new Fraction(1, 3)
    val f2 = new Fraction(2, 5)
    println(smaller(f1, f2))

    val p1 = new Person("rain", 21)
    val p2 = new Person("raim", 21)
    import Ordered._
    println(p1 < p2)
  }
}
