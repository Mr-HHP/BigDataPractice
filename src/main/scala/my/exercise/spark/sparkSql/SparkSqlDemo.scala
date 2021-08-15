package my.exercise.spark.sparkSql

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalog.Catalog

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/08/05
  **/
object SparkSqlDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
            .master("local[*]")
            .appName("spark-sql-demo")
            .getOrCreate()
    spark.emptyDataFrame.col("")
  }
  
}
