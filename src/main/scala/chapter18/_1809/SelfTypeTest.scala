package chapter18._1809

/**
  * Created by songdexv on 2017/12/22.
  */
object SelfTypeTest {

  abstract class Dim[T](val value: Double, val name: String) {
    this: T => //自身类型
    protected def create(v: Double): T

    def +(other: Dim[T]) = create(other.value + value)

    override def toString() = value + " " + name
  }


  class Seconds(v: Double) extends Dim[Seconds](v, "s") {
    override def create(v: Double): Seconds = new Seconds(v)
  }

  //  class Meters(v: Double) extends Dim[Seconds](v, "m") {
  //    override def create(v: Double): Seconds = new Seconds(v)
  //  }

  trait A {
    println("in A contructor")

    def sing() = "from a"
  }

  trait C {
    this: A =>
    println("in C contructor")
    val w = sing() + " from c"
  }

  class B {
    this: C =>
    println("in B contructor")
    val k = w
  }

  def main(args: Array[String]): Unit = {
    val b = new B with C with A
    println(b.k)
  }
}
