package chapter8

import scala.collection.mutable.ArrayBuffer

/**
  * Created by songdexv on 2018/5/7.
  */
class Bundle extends Item {
  val items = new ArrayBuffer[Item]()

  def addItem(item: Item): Unit = {
    items += item
  }

  override def price(): Double = {
    var total = 0d
    items.foreach(it => total += it.price())
    total
  }

  override def description(): String = {
    items.mkString(" ")
  }
}
