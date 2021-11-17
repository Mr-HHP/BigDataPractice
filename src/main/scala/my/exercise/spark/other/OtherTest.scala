package my.exercise.spark.other

import java.util.regex.Pattern

import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.Map

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/29
  **/
object OtherTest {
  private val logger: Logger = LoggerFactory.getLogger(this.getClass)
  
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[*]").getOrCreate()
    import spark.implicits._
    val seq = Seq(("a", "a", "a"), ("a", "a", "a"), ("b", "b", "b"), ("a", "a", "c"), ("c", "c", "c"), ("b", "b", "b"), ("b", "b", "b"), ("d", "d", "d"))
    val df: DataFrame = seq.toDF("i", "j", "k")
//    df.cube("i", "j", "k").count().show(false)
//    df.cube("i", "j", "k").agg(grouping("i")).show(false)
    df.cube("i", "j", "k")
      .agg(count("i"), countDistinct("i", "j", "k"), sum("i"))
      .show(false)
    
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

case class A(id: String, name: String, info: Map[String, String], b: B)

case class B(i: String, j: String)