package chapter6

/**
  * Created by songdexv on 2018/5/7.
  */
object MainApp extends App{
  println(MilesToKilometers.convert(10000d))
  println(InchesToCentimeters.convert(100d))
  println(GallonsToLiters.convert(5d))

  Point(3,4).draw()

  println(Poker.SPADES)
  println(Poker.isRed(Poker.DIAMONDS))
}
