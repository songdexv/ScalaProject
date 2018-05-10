package chapter6

/**
  * Created by songdexv on 2018/5/7.
  */
object MilesToKilometers extends UnitConversion {
  override def convert(origin: Double): Double = {
    origin * 0.001d
  }
}
