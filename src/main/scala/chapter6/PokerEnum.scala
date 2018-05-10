package chapter6

/**
  * Created by songdexv on 2018/5/7.
  */
object Poker extends Enumeration {
  val CLUBS = Value("♣")
  val DIAMONDS = Value("◆")
  val HEARTS = Value("♥")
  val SPADES = Value("♠")
  type Poker = Value

  override def toString(): String = {
    Poker.toString()
  }

  def isRed(card: Poker): Boolean = {
    card == HEARTS || card == DIAMONDS
  }
}
