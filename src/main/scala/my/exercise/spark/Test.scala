package my.exercise.spark


import com.alibaba.fastjson.{JSON, JSONObject}
import scala.collection.JavaConverters._


/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/01/19
  **/
case class L(_1: String, _2: Int)

object Test {
  def main(args: Array[String]): Unit = {
    val map = Map("sha1" -> "123", "bucket" -> "test", "dimension_type" -> "aaaa", "send_time" -> "1997", "file_name" -> "a.txt", "report_type" -> "daily", "report_date" -> "2001")
    val jsonObject = new JSONObject()
    map.foreach(kv => jsonObject.put(kv._1, kv._2))
    println(jsonObject.toString)
    println(jsonObject.toJSONString)
  }
  
  def power3(number: Double): Double = number * number * number
  
  def t(s: String) = s match {
    case "D" | "daily" | "DAILY" =>
      println("D")
    case "W" | "weekly" | "WEEKLY" =>
      println("W")
    case "M" | "monthly" | "MONTHLY" =>
      println("M")
  }
  
}
