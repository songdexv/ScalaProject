package chapter8

/**
  * Created by songdexv on 2018/5/7.
  */
abstract class Item {
  def price(): Double

  def description(): String

  override def toString(): String = {
    "description:" + description() + "  price:" + price()
  }
}
