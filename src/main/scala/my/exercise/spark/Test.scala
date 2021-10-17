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
    val spark: SparkSession = SparkSession.builder().master("local[*]").getOrCreate()
    import spark.implicits._
    val seq: Seq[(String, String, String)] = Seq(("a", "a", "a"), ("b", "b", "b"))
    val df = seq.toDF("name", "id", "age")
    //    df.cube(col("name"), col("id"), col("age")).count().show(false)
    
    df
            .cube(col("name"), col("id"), col("age"))
            .count()
            .na
            .drop("any", Seq("name"))
            .withColumn("id", when(col("id").isNull, lit("ALL")).otherwise(col("id")))
            .withColumn("age", when(col("age").isNull, lit("ALL")).otherwise(col("age")))
            .show(false)
    
  
//    df
//            .rollup(col("name"), col("id"), col("age"))
//            .count()
//            .show(false)
  }
  
  
}
