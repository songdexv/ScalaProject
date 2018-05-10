package package14

/**
  * Created by songdexv on 2017/12/6.
  */
abstract class Item

case class Article(desc: String, price: Double) extends Item

case class Bundle(desc: String, discount: Double, items: Item*) extends Item

case class Multiple(count: Int, item: Item) extends Item

object caseTest extends App {
  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its@_*) => its.map(price(_)).sum - disc
    case Multiple(c, it) => c * price(it)
  }

  val p = price(Multiple(10, Article("Blackwell Toster", 29.95)))
  println(p)
  val p1 = price(Multiple(10, Bundle("bundle", 10.00, Article("Blackwell Toster I", 20.00), Article("Blackwell Toster" +
    "II", 30.00))))
  println(p1)
}

