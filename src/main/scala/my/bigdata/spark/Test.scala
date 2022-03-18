package my.bigdata.spark


import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
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
    val df1 = Seq(("i", "a", "1"), ("a", "b", "1"), ("c", "c", "1"), ("a", "a", "1"), ("a", "a", "1"), ("c", "c", "1"), ("d", "c", "1")).toDF("i", "j", "k1")
    val df2 = Seq(("a", "a", "1"), ("a", "b", "1"), ("c", "c", "1"), ("a", "a", "1"), ("a", "a", "1"), ("c", "c", "1"), ("c", "e", "1")).toDF("i", "j", "k2")
    val df3 = df1.join(df2, (df1.col("i") === df2.col("i")).and(df1.col("j") === df2.col("j")), "left")
    
    println(df1.rdd.getNumPartitions)
    val sortDf = df1.sort(col("i"))
    println(sortDf.rdd.getNumPartitions)
    val rddDf = df1.repartition(3, col("i"))
    println(rddDf.rdd.getNumPartitions)
    val sortDf2 = rddDf.sort("i")
    println(sortDf2.rdd.getNumPartitions)
    println("=============================")
    val rdd1 = rddDf.rdd.sortBy(row => row.getAs[String]("i"))
    println(rdd1.getNumPartitions)
    spark.createDataFrame(rdd1, df1.schema).show(false)
  }
  
  
}
