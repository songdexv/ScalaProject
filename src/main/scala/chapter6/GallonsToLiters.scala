package chapter6

/**
  * Created by songdexv on 2018/5/7.
  */
object GallonsToLiters extends UnitConversion {
  override def convert(origin: Double): Double = {
    origin * 3.7854d
  }
}
