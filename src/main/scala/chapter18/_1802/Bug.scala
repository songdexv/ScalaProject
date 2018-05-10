package chapter18._1802

/**
  * Created by songdexv on 2017/12/21.
  */
object FluentTest {

  object then

  object show

  object around

  class Bug(var pos: Int = 0) {
    var direction: Int = 1

    def move(step: Int): this.type = {
      pos += direction * step
      this
    }

    def and(obj: then.type): this.type = this

    def and(obj: show.type): this.type = {
      print(pos + " ")
      this
    }

    def turn(obj: around.type): this.type = {
      direction = -direction
      this
    }

  }

  def main(args: Array[String]): Unit = {
    val bugsy = new Bug
    bugsy move 4 and show and then move 6 and show turn around move 5 and show
  }

}


