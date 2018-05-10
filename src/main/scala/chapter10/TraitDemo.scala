package chapter10


/**
  * Created by songdexv on 2017/11/29.
  */
trait Fly {
  def fly(): Unit = {
    println("flying")
  }

  def flyWithSinging()
}

trait Walk {
  val speed: String

  def walk(): Unit = {
    println("walking " + speed)
  }
}

class Bird {
  var name: String = "Polly"
}

class BlueBird extends Bird with Walk with Fly {
  override val speed: String = "slowly"

  override def flyWithSinging(): Unit = {
    println("BlueBird flyWithSinging")
  }
}

object TraitDemo {
  def main(args: Array[String]): Unit = {
    val b = new BlueBird()
    b.walk()
    b.flyWithSinging()
    b.fly()
  }
}

