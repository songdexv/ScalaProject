package chapter8

/**
  * Created by songdexv on 2018/5/8.
  */
class Person(val name: String) {
  override def toString: String = getClass.getName + "[name=" + name + "]"
}

class SecretAgent(codeName: String) extends Person(codeName) {
  override val name = "secret"

  override val toString = "secret"
}
