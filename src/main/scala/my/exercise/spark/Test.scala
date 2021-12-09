package my.exercise.spark


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/01/19
  **/
case class L(i: String, j: Int, k: String)

object Test {
  def main(args: Array[String]): Unit = {
    val array: Array[String] = Array("a", "b", "c")
    println(!array.contains("a"))
    println(!array.contains("aa"))
  }
  
  
}
