package chapter18._1804

import scala.collection.mutable.ArrayBuffer

/**
  * Created by songdexv on 2017/12/21.
  */
object InterClassTest {

  class Network {

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]()

      def canEqual(other: Any): Boolean = other.isInstanceOf[Member]

      override def equals(other: Any): Boolean = other match {
        case that: Member => (this canEqual that) && name == that.name
        case _ => false
      }

    }

    private val members = new ArrayBuffer[Member]()

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }

  def main(args: Array[String]): Unit = {
    val m1 = new Network().join("1")
    val m2 = new Network().join("1")
    val network = new Network
    println(m1.equals(m2))
    val m3 = network.join("1")
    val m4 = network.join("1")
    println(m3.equals(m4))
  }
}
