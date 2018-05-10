package chapter10

/**
  * Created by songdexv on 2018/5/8.
  */
trait CaesarLogger {
  def log(str: String, key: Int = 3): String
}

class CryptoLogger extends CaesarLogger {
  override def log(str: String, key: Int): String = {
    for (i <- str) yield if (key >= 0) (97 + ((i - 97 + key) % 26)).toChar else (97 + ((i - 97 + 26 + key) % 26)).toChar
  }
}

object CryptoLogger extends App {
  val plain = "songdexv"

  println("明文为：" + plain)
  println("加密后为：" + new CryptoLogger().log(plain))
  println("加密后为：" + new CryptoLogger().log(plain, -3))
}
