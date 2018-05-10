package chapter18._1801

/**
  * Created by songdexv on 2017/12/21.
  */
class Bug(var pos: Int = 0) {
  var direction:Int = 1 //正向
  def move(step: Int): this.type = {
    pos += direction*step
    this
  }

  def turn(): this.type = {
    direction = -direction
    this
  }

  def show(): this.type = {
    print(pos + " ")
    this
  }
}

object BugTest extends App {
  val bugsy = new Bug
  bugsy.move(4).show().move(6).show().turn().move(5).show()
}
