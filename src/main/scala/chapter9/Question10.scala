package chapter9

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by songdexv on 2018/5/8.
  */
class Person(var name: String) extends Serializable {
  val friends = new ArrayBuffer[Person]()

  def addFriend(friend: Person): Unit = {
    friends += friend
  }

  override def toString() = {
    var str = "My name is " + name + " and my friends name is "
    friends.foreach(str += _.name + ",")
    str
  }
}

object Question10 extends App {
  val p1 = new Person("Ivan")
  val p2 = new Person("F2")
  val p3 = new Person("F3")
  p1.addFriend(p2)
  p1.addFriend(p3)
  println(p1)
  val out = new ObjectOutputStream(new FileOutputStream("person.obj"))
  out.writeObject(p1)
  out.close()
  val in = new ObjectInputStream(new FileInputStream("person.obj"))
  val p = in.readObject().asInstanceOf[Person]
  println(p)
}
