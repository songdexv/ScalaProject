package chapter7

import scala.io.StdIn

/**
  * Created by songdexv on 2018/5/7.
  */
object Question9 extends App {

  import java.lang.System._

  var password = Console.readLine("请输入密码：")

  if (password equals "secret") {
    println("Hello " + getProperty("user.name"))
  } else {
    println("password error !")
  }
}
