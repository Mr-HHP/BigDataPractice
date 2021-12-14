package my.exercise.spark


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
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
    val spark = SparkSession.builder().master("local[*]").getOrCreate()
    import spark.implicits._
    val seq = Seq(("a", "a"), ("a", "b"), ("c", "c"), ("a", "a"), ("a", "a"), ("c", "c")).toDF("i", "j")
    val window = Window.partitionBy("i").orderBy("i")
    seq.withColumn("id", row_number().over(window))
      .show(false)
  }
  
  
}
