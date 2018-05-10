import scala.beans.BeanProperty

/**
  * Created by songdexv on 2017/11/23.
  */
class People {
  private var privateAge = 0
  @BeanProperty var name: String = _
  def age = privateAge
  def age_= (newValue:Int){
    if(newValue > privateAge) privateAge = newValue
  }
}

object PersonMain{
  def main(args: Array[String]): Unit = {
    var fred = new People
    fred.age = 21
    fred.age = 30
    println(fred.age)
    fred.setName("fred")
    println(fred.getName)
    fred.name = "fred2"
    println(fred.name)
  }
}
