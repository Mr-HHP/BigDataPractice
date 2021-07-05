package my.exercise.spark

import java.sql.{DriverManager, ResultSet}

import my.protobuf_test.PresonOuterClass
import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.{JdbcRDD, RDD}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._

import scala.collection.mutable.ArrayBuffer

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/01/19
  **/
case class L(_1: String, _2: Int)

object Test {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
            .builder()
            .master("local[*]")
            .appName("spark_test")
            .getOrCreate()
    import spark.implicits._
    val seq: Seq[(String, Int, String)] = Seq(("a", 1, "小明"), ("b", 2, "小张"), (null, 3, "小红"))
    val df: DataFrame = seq.toDF()
//    df.show(false)
//    df.select(expr("*"), lit(1).as("One")).show(false)
//    df.withColumn("id", expr("_1")).show(false)
//    df.where(col(""))
//    df.where("").distinct().sample(9)
//    df.where($"_1" =!= "a").show(false)
//    df.where($"_1" === "a").show(false)
//    df.sort($"_1").show(false)
//    df.sort(expr("_1 asc")).show(false)
//    df.sort(desc("_1")).show(false)
//    df.sort("_1")
//    df.orderBy(col("_1"))
//    df.orderBy("_1")
//    df.orderBy(expr("_1 desc")).show(false)
//    df.orderBy(desc("_1")).show(false)
//    df.orderBy(expr("_1 asc")).show(false)
//    df.sortWithinPartitions("")
//    df.select(lit(4) === "")
//    val it = df.toLocalIterator()
//    df.where("_2 = 1").show(false)
//    df.where("_2 <> 1").show(false)
//    df.describe().show(false)
//    val D = col("") === ""
//    df.withColumn("", (col("") === "").and(D))
//    df.select(pow(col(""), 2))
//    df.stat.corr("", "")
//    df.select(corr("", ""))
//    df.stat.approxQuantile("", )
//    df.stat.crosstab("", "")
//    initcap(col(""))
//    regexp_replace(col(""), "", "")
//    translate(col(""), "", "")
//    instr(col(""), "")
//    regexp_extract(col(""), "", 9)
//    lpad(col(""), 9, "")
//    df.select(initcap(col("")))
//    df.stat
//    expr("")
    df.select(coalesce(col("_1"), lit(null), lit("hahaah"))).show(false)
    df.schema.printTreeString()
    df.na.drop("")
    df.na.fill("")
    df.na.replace("", Map())
    df.select(struct())
    size(col(""))
    explode(col(""))
    explode_outer(col(""))
    array_contains(col(""), "")
  }
  
  
}
