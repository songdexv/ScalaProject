/**
  * Created by songdexv on 2018/1/30.
  */
object IpConverter {
  def main(args: Array[String]): Unit = {
    println(ipStrToNum("10.0.3.193"))
    println(numToIpStr(167969729L))
  }

  def ipStrToNum(ip: String): Long = {
    val segs: Array[String] = ip.split("\\.")
    var num = segs(0).toLong
    for (i <- 1 until segs.length) {
      num = num << 8
      num = num + segs(i).toLong
    }
    num
  }

  def numToIpStr(num: Long): String = {
    val binaryStr = num.toBinaryString
    val sb: StringBuffer = new StringBuffer()
    if (binaryStr.length() < 32) {
      for (i <- 0 until 32 - binaryStr.length()) {
        sb.append("0")
      }
      sb.append(binaryStr)
    } else if (binaryStr.length == 32) {
      sb.append(binaryStr)
    }
    val result: StringBuffer = new StringBuffer()
    for (i <- 0 until(sb.length(), 8)) {
      result.append(Integer.parseInt(sb.substring(i, i + 8), 2) + ".")
    }
    result.deleteCharAt(result.length()-1)
    result.toString
  }
}
