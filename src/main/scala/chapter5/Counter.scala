package chapter5

/**
  * Created by songdexv on 2018/5/2.
  */
class Counter {
  private var value = 0

  def increment(): Unit = {
    if (value >= Int.MaxValue)
      value = 0
    value += 1
  }

  def decrement(): Unit = {
    value -= 1
  }
}
