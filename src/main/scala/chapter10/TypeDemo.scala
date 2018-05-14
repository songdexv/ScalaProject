package chapter10

import scala.io.{BufferedSource, Source}

/**
  * Created by songdexv on 2018/5/10.
  */
object TypeDemo {

  class S1 {
    def fun(): this.type = this
  }

  class S2 extends S1 {
    def g(): this.type = this
  }

  trait T1 {
    def fun(): Unit
  }

  trait T2 {
    def g(): Unit
  }

  trait T3 {
    type In
    type Out

    def read(arg: In): Out
  }

  class T4 extends T3 {
    override type In = String
    override type Out = BufferedSource

    override def read(arg: String): BufferedSource = Source.fromFile(arg)
  }

  def main(args: Array[String]): Unit = {
    var s2 = new S2()
    s2.fun().g().fun().g()

    type m = T1 with T2 {
      def f(): Unit
    }

    def fun2(arg: m): Unit = {
      println("复合的数据类型" + arg)
    }

    fun2(new T1 with T2 {
      override def fun(): Unit = println("1111")

      override def g(): Unit = println("2222")

      def f() = println("3333")
    })
  }

}
