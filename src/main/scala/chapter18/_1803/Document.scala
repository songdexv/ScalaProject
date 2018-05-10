package chapter18._1803

/**
  * Created by songdexv on 2017/12/21.
  */
class Document {
  var title: String = ""
  var author: String = ""

  def setTitle(title: String): this.type = {
    this.title = title;
    this
  }

  def setAuthor(author: String): this.type = {
    this.author = author;
    this
  }
}

object Title

object Author

class Book extends Document {
  private var useNextArgAs: Any = null

  def set(obj: Any): this.type = {
    useNextArgAs = obj
    this
  }

  def to(obj: String): this.type = {
    useNextArgAs match {
      case Title => setTitle(obj)
      case Author => setAuthor(obj)
      case _ =>
    }
    this
  }
}

object Main extends App {
  val book = new Book
  book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
  println(book.title)
  println(book.author)
}
