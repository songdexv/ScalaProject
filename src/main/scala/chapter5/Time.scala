package chapter5

/**
  * Created by songdexv on 2018/5/2.
  */
class Time(val hours: Int, val minutes: Int) {
  if (hours > 23 || hours < 0)
    throw new IllegalArgumentException("hours must between 0 and 23")

  def before(other: Time): Boolean = {
    if (this.hours < other.hours) {
      true
    } else if (this.hours == other.hours) {
      if (this.minutes < other.minutes) {
        true
      } else {
        false
      }
    } else {
      false
    }
  }

  def show(): String ={
    hours + ":" + minutes
  }
}

object Time {
  def main(args: Array[String]): Unit = {
    val time1: Time = new Time(20, 20)
    val time2: Time = new Time(20, 23)
    println(time1.before(time2))
  }
}
