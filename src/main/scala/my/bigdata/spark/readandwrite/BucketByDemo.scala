package my.bigdata.spark.readandwrite

import org.apache.spark.sql.catalyst.expressions.SortOrder
import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.functions._

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/28
  **/
object BucketByDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
            .master("local[*]")
            .appName("BucketByDemo")
            .getOrCreate()
    
    // ##### 数据分桶 #####
    val seq: Seq[(String, String, String)] = Seq(("a", "A", "1"), ("b", "A", "258"), ("a", "C", "3"), ("a", "C", "1"), ("a", "A", "1"), ("d", "D", "4"), ("a", "A", "1"), ("e", "C", "5"), ("a", "A", "1"), ("f", "F", "6"), ("g", "A", "7"), ("h", "H", "8"), ("a", "C", "1"), ("i", "D", "9"), ("a", "A", "1"), ("j", "D", "10"))
    import spark.implicits._
    val df = seq.toDF("col1", "col2", "col3")
    
    println("df:\t" + df.rdd.getNumPartitions)
    //    val df1 = df.repartition(200, col("col2"))
    val df1 = df.repartitionByRange(40, col("col3"))
    
    println(df1.rdd.getNumPartitions)
    
    val arrRdd = df.rdd.glom().map(arr => arr.map(row => row.getString(0) + "\t" + row.getString(1) + "\t" + row.getString(2)).mkString(","))
    arrRdd.foreach(println)
    
    println("================================")
    
    val arrRdd1 = df1.rdd.glom().map(arr => arr.map(row => row.getString(0) + "\t" + row.getString(1) + "\t" + row.getString(2)).mkString(","))
    arrRdd1.foreach(println)
    
    df1.write.mode(SaveMode.Overwrite)
            .format("csv")
//            .sortBy("col3")
            //                .partitionBy("col2")
            .bucketBy(100, "col3")
            .option("path", "D:\\BigDataProject\\MySpark\\src\\main\\t")
            .saveAsTable("table")
    
    //    val col1 = df1.col("col1")
    //    val col2 = df1.col("col2")
    //    val col3 = df1.col("col3")
    //    val expr1 = col1.expr
    //    val expr2 = col2.expr
    //    val expr3 = col3.expr
    //    val s = Seq(expr1, expr2, expr3)
    //    val (l, r) = s.partition(_.isInstanceOf[SortOrder])
    //    println(l)
    //    println(r)
    //    println("l\t" + l.nonEmpty)
    //    println("r\t" + r.nonEmpty)
    
    //    df1.map(row => s"${row.getString(0)},${row.getString(1)},${row.getString(2)}")
    //            .map(line => (Array.emptyByteArray, line))
    //            .rdd
    //            .partitionBy()
    
  }
}
