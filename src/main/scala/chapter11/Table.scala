package chapter11

/**
  * Created by songdexv on 2018/5/10.
  */
class Table {
  var html = ""

  def |(str: String): Table = {
    val t = new Table()
    t.html = this.html + "<td>" + str + "</td>"
    t
  }

  def ||(str: String): Table = {
    val t = new Table()
    t.html = this.html + "</tr><tr><td>" + str + "</td>"
    t
  }

  override def toString: String = {
    "<table><tr>" + this.html + "</tr></table>"
  }
}

object Table {
  def apply(): Table = new Table()

  def main(args: Array[String]): Unit = {
    println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM,.NET")
  }
}