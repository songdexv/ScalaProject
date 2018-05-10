/**
  * 常量模式匹配，就是在模式匹配中匹配常量
  * Created by songdexv on 2017/11/21.
  */
object ConstantPattern {
  def main(args: Array[String]): Unit = {
    def patternShow(x: Any) = x match {
      case 5 => "五"
      case true => "真"
      case "test" => "字符串"
      case null => "null值"
      case Nil => "空列表"
      case _ => "其他常量"
    }

    println(patternShow(5))
    println(patternShow(true))
    println(patternShow(List()))
    println(patternShow(6))
  }
}
