package chapter10

/**
  * Created by songdexv on 2018/5/9.
  */
class IterableInputStream extends java.io.InputStream with Iterable[Byte] {
  class InputStreamIterator(outer:IterableInputStream) extends Iterator[Byte]{
    override def hasNext: Boolean = outer.available() > 0

    override def next(): Byte = outer.read().toByte
  }
  override def read(): Int = {
    0
  }

  override def iterator: Iterator[Byte] = {
    new InputStreamIterator(this)
  }
}
