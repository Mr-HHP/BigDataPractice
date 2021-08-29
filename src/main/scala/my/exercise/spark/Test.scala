package my.exercise.spark


import java.text.SimpleDateFormat
import java.util.Calendar

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
    t("D")
    t("W")
    t("M")
    
    
  }
  
  def power3(number: Double): Double = number * number * number
  
  def t(s: String) = s match {
    case "D" | "daily" | "DAILY" =>
      println("D")
    case "W" | "weekly" | "WEEKLY" | "M" | "monthly" | "MONTHLY" =>
      println("######")
    case "M" | "monthly" | "MONTHLY" =>
      println("######")
    case _ => println("other")
  }
  
}
