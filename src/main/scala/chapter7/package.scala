/**
  * Created by songdexv on 2018/5/7.
  */
package object random {
  var seed: Int = _
  val a = BigDecimal(1664525)
  val b = BigDecimal(1013904223)
  val n: Int = 32

  def setSeed(seed: Int): Unit = {
    this.seed = seed
  }

  def nextInt(): Int = {
    val temp = (seed * a + b) % BigDecimal(2).pow(n)
    seed = temp.toInt
    seed
  }

  def nextDouble(): Double = {
    val temp = (seed * a + b) % BigDecimal(2).pow(n)
    seed = temp.toInt
    temp.toDouble
  }


}
