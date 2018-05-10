package chapter6

/**
  * Created by songdexv on 2018/5/7.
  */
object InchesToCentimeters extends UnitConversion {
  override def convert(origin: Double): Double = {
    origin * 2.54d
  }
}
