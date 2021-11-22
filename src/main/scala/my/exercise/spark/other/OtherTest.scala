package my.exercise.spark.other

import java.text.SimpleDateFormat
import java.util.Calendar
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
    val seq1: Seq[(String, String, String)] = Seq(("a", "a", "a"), ("b", "b", "b"), ("c", "c", "c"))
    val seq2: Seq[(String, String, String)] = Seq(("a", "a", "a"), ("b", "b", "b"), ("c", "c", "c"), ("d", "d", "d"))
    val df1: DataFrame = seq1.toDF("i1", "j1", "k1")
    val df2: DataFrame = seq2.toDF("i2", "j2", "k2")
    val c = col("") === col("")
    df1.join(df2, lit(col("i1") === col("i2")).and(col("j1") === col("j2")).and(col("k1") === col("k2")), "full").show(false)
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
  
  def getPreviousDate(time: String): String = time match {
    case amount if amount.contains("-") || "0".equals(amount) =>
      val calendar: Calendar = Calendar.getInstance()
      calendar.add(Calendar.DATE, amount.toInt - 1)
      new SimpleDateFormat("yyyyMMdd").format(calendar.getTime)
    case other => {
      val d = new SimpleDateFormat("yyyyMMdd").parse(time)
      val calendar: Calendar = Calendar.getInstance()
      calendar.setTime(d)
      calendar.add(Calendar.DATE, -1)
      new SimpleDateFormat("yyyyMMdd").format(calendar.getTime)
    }
  }
}

case class A(id: String, name: String, info: Map[String, String], b: B)

case class B(i: String, j: String)