package my.exercise.spark.other

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, DataInputStream, DataOutputStream}

import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}
import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.BinaryType
import org.roaringbitmap.RoaringBitmap

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/29
  **/
object OtherTest {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
            .builder()
            .appName("test")
            .master("local[*]")
            .getOrCreate()
    import spark.implicits._
    println("202108*".substring(0, "202108*".length - 1))
    
    val seq = Seq(
      ("a", "a", "a"),
      ("a", "a", "b"),
      ("a", "a", "d"),
      ("a", "a", "a"),
      ("c", "c", "c,c"),
      ("b", "b", "b"),
      ("b", "b", "b"),
      ("b", "b", "b123"),
      ("b", "b", "b")
    )
    val seq1 = Seq(("b", "1", "2"))
//    val df = seq.toDF("col_1", "col_2", "col_3")
//    val dff = df.join(seq1.toDF("col_a", "col_2", "col_3"), col("col_1") === col("col_a"))
//    dff.show(false)
//    dff.map(row => {
//      (row.getAs[String](2), row.getAs[String](5))
//    }).show(false)
    
//    df.groupBy(col("col_1"), col("col_2")).count().show(false)
    
//    val pairDf = df.map(row => ((row.getAs[String]("col_1"), row.getAs[String]("col_2")), row.getAs[String]("col_3")))
    
//    df.dropDuplicates().groupBy(col("col_2"), col("col_1")).count().withColumnRenamed("count", "active_users").show(false)
    
//    val ds = df.as[(String, String, String)]
//    val dss = ds.joinWith(spark.emptyDataset[(String, String, String)], col(""))
    
//    df.groupBy(col("col_2"), col("col_1")).agg(countDistinct("col_3").alias("new_3")).show(false)
//    val fs = FileSystem.get(spark.sparkContext.hadoopConfiguration)
//    csvDownloadLocal(fs, "file:///D:\\BigDataProject\\MySpark\\src\\main\\t", "file:///D:\\BigDataProject\\MySpark\\src\\main\\test\\test\\test")
//    df.write.mode(SaveMode.Overwrite).csv("file:///D:\\BigDataProject\\MySpark\\src\\main\\a\\b\\c")
  }
  
  def csvDownloadLocal(fs: FileSystem, hdfsPath: String, localPath: String): Unit = {
    val fileList: Array[FileStatus] = fs.listStatus(new Path(hdfsPath))
    fileList.foreach(_ match {
      case fileStatus if (fileStatus.getPath.getName.endsWith(".csv")) =>
        val fileName: String = fileStatus.getPath.getName
        fs.copyToLocalFile(fileStatus.getPath, new Path(s"$localPath/$fileName"))
      case _ =>
    })
  }
}