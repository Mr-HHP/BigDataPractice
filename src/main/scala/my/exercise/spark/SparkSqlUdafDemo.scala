package my.exercise.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/15
  **/
object SparkSqlUdafDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
            .master("local[*]")
            .appName("spark_sql_udaf_demo")
            .getOrCreate()
    
    spark.udf.register("u_avg", AverageUserDefinedAggregateFunction)
    
    spark.range(1)
            .selectExpr("explode(array(TRUE, TRUE, TRUE)) as t")
            .selectExpr("explode(array(TRUE, FALSE, TRUE)) as f", "t")
            .select(AverageUserDefinedAggregateFunction(col("t")), expr("u_avg(f)"))
            .show(false)
  }
}
