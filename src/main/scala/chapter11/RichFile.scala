package chapter11

import java.io.File

/**
  * Created by songdexv on 2018/5/11.
  */
class RichFile(val path: String) extends File(path) {

}

object RichFile {
  def unapply(arg: RichFile): Option[(String, String, String)] = {
    val path = arg.path
    val pos = path.lastIndexOf("/")
    if (pos != -1) {
      val fileName = path.substring(pos + 1)
      val pos2 = fileName.lastIndexOf(".")
      if (pos2 != -1) {
        Some((path.substring(0, pos), fileName.substring(0, pos2), fileName.substring(pos2 + 1)))
      } else {
        Some((path.substring(0, pos), fileName, ""))
      }
    } else {
      None
    }
  }
}

object RichFile2{
  def unapplySeq(s: String): Option[Seq[String]] = {
    if (s.trim == "") None else Some(s.trim.split("/"))
  }
}

object RichFileApp extends App {
  val filePath = "D:/GitRepository/ScalaProject/test.txt"
  val RichFile(path, name, extension) = new RichFile(filePath)
  println(path)
  println(name)
  println(extension)

  val RichFile2(driver,repo,project,fileName) = filePath
  println(driver)
  println(repo)
  println(project)
  println(fileName)
}
