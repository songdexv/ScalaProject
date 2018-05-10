/**
  * Created by songdexv on 2017/11/22.
  */
object Chapter2 {
  def main(args: Array[String]): Unit = {
    println(test1(3))
    val val1 = {}
//    println(val1)
//    forTest(10)
    println(test2("Hello"))
    println(product("Hello"))
  }

  def test1(signum :Int): Int ={
    if (signum > 0) 1 else if(signum == 0) 0 else 1
  }

  def forTest(num :Int): Unit ={
    for (i <- 0 to num)
      println(num - i)
  }

  def test2(str :String): BigInt ={
    var result = BigInt(1)
    for( c <- str)
      result *= c.toInt
    result
  }
  def product(s :String): BigInt = {
    var result = BigInt(1)
    s.map(c => result *= c.toInt)
    result
  }
}
