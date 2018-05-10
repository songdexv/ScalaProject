/**
  * <p>
  * 变量匹配，匹的是case语句后面接的是scala变量，如case x if(x == 5) => x等，在使用时一般会加守卫条件，当然也可以像case x => x这样使用，它会匹配任何输入的合法变量
  * </p>
  * Created by songdexv on 2017/11/21.
  */
object VariablePattern {
  def main(args: Array[String]): Unit = {
    def patternShow(x: Any) = x match {
      case x if (x == 5) => x
      case x if (x == "Scala") => x
      case _ =>
    }

    println(patternShow(5));
    println(patternShow("Scala"))
  }
}
