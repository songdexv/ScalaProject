/**
  * Created by songdexv on 2017/11/21.
  */
object SequencePattern {
  def main(args: Array[String]): Unit = {
    val list = List("spark", "Hive", "SparkSQL")
    val arr = Array("SparkR", "Spark Streaming", "Spark MLib")

    def sequencePattern(p: Any) = p match {
      //序列模式匹配，_*表示匹配剩余内容，first、second匹配数组p中的第一、二个元素
      case Array(first, second, _*) => first + "," + second
      //_匹配数组p的第二个元素，但不赋给任何变量
      case List(_, second, _*) => second
      case _ => "Other"
    }

    println(sequencePattern(list))
    println(sequencePattern(arr))
    print(1.toString)
  }
}
