package chapter11

/**
  * Created by songdexv on 2017/11/29.
  */
class Money(dollar: Int, cent: Int) {
  private val d = dollar
  private val c = cent

  def +(that: Money): Money = {
    var cents = this.c + that.c
    var dollars = this.d + that.d
    if (cents >= 100) {
      cents -= 100
      dollars += 1
    }
    new Money(dollars, cents)
  }

  def -(that: Money): Money = {
    var cents = this.c - that.c
    var dollars = this.d - that.d
    if (cents < 0) {
      cents += 100
      dollars -= 1
    }
    new Money(dollars, cents)
  }

  def ==(that: Money): Boolean = {
    this.d == that.d && this.c == that.c
  }

  def <(that: Money): Boolean = {
    if (this.d < that.d) true
    else if (this.d == that.d && this.c < that.c) true
    else false
  }

}

object Money {
  def apply(dollar: Int, cent: Int): Money = new Money(dollar, cent)

  def main(args: Array[String]): Unit = {
    println(Money(1, 75) + Money(0, 50) == Money(2, 25))
  }
}
