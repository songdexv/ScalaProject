import `match`.Person

/**
  * <p>
  *   构造器模式指的是，直接在case语句后面接类构造器，匹配的内容放置在构造器参数中
  *  </p
  * Created by songdexv on 2017/11/21.
  */
object ConstructorPattern {
  def main(args: Array[String]): Unit = {
    val p = new Person("test",27)
    def constructorPattern(p :Person) = p match {
      //构造器模式必须将Person类定义为case class,否则需要自己定义伴生对象并实现unapply方法。
      case Person(_,age) => "age =" + age
      case Person(name,age) => "name =" + name + ",age =" + age
      case _ => "Other"
    }
    println(constructorPattern(p))
  }
}
