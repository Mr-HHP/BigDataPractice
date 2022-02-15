package my.bigdata.spark.join

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/21
  **/
object Test {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
            .builder()
            .master("local[*]")
            .getOrCreate()
    val seq = Seq(A("a"), A("b"), A("c"), A("d"), A("e"))
    val seq1: Seq[String] = Seq("a", "b", "c")
    import spark.implicits._
    val df = seq.toDS()
    val df1 = seq1.toDF("tmp_ua")
    val df2 = df.join(broadcast(df1), df.col("ua") === df1.col("tmp_ua"), "leftouter")
    df2.show(false)
    df2.withColumn("ua", when(col("tmp_ua").isNull, "other").otherwise(col("ua")))
            .drop("tmp_ua")
            .show(false)
    
  }
}

case class A(ua: String)
