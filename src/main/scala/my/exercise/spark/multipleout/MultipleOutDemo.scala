package my.exercise.spark.multipleOut

import org.apache.hadoop.io.compress.SnappyCodec
import org.apache.hadoop.io.{BytesWritable, NullWritable, Text}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SaveMode, SparkSession}
import org.apache.spark.sql.functions.col

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/30
  **/
object MultipleOutDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
            .master("local[*]")
            .appName("multipleOutDemo")
            .getOrCreate()
    
    // ##### spark多输出 #####
    val seq: Seq[(String, String, String)] = Seq(("a", "A", "1"), ("b", "A", "258"), ("a", "C", "3"), ("a", "C", "1"), ("a", "A", "1"), ("d", "D", "4"), ("a", "A", "1"), ("e", "C", "5"), ("a", "A", "1"), ("f", "F", "6"), ("g", "A", "7"), ("h", "H", "8"), ("a", "C", "1"), ("i", "D", "9"), ("a", "A", "1"), ("j", "A", "10"))
    import spark.implicits._
    val df: DataFrame = seq.toDF("col1", "col2", "col3")
    
    println("df:\t" + df.rdd.getNumPartitions)
    println("==================")
    val df1: Dataset[Row] = df.repartition(3, col("col1"))
    println(df1.rdd.getNumPartitions)
    println("===================")
    println(df.repartition(col("col1")).rdd.getNumPartitions)
    
//    val arrRdd = df.rdd.glom().map(arr => arr.map(row => row.getString(0) + "\t" + row.getString(1) + "\t" + row.getString(2)).mkString(","))
//    arrRdd.foreach(println)
    
    println("================================")
    
    val arrRdd1 = df1.rdd.glom().map(arr => arr.map(row => row.getString(0) + "\t" + row.getString(1) + "\t" + row.getString(2)).mkString(","))
    arrRdd1.foreach(println)
    
    val path: String =  s"D:\\BigDataProject\\MySpark\\src\\main\\path1\\"
    
//    arrRdd1.map(line => (s"2021\u0001aaa", new Text(line)))
//            .saveAsHadoopFile(path, classOf[BytesWritable], classOf[Text], classOf[MyMultipleOutputFormat])
    
//    df1.write.mode(SaveMode.Overwrite)
//            .partitionBy("col2")
//            .option("path", "D:\\BigDataProject\\MySpark\\src\\main\\t")
//            .format("csv")
//            .saveAsTable("table")
    
    
  }
}
