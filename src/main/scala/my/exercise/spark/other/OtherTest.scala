package my.exercise.spark.other

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.regex.Pattern

import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.mutable.ListBuffer
import scala.collection.{Map, mutable}

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
    val userSeq: Seq[String] = Seq("cust_id01", "cust_id01", "cust_id01")
    val userDs: Dataset[String] = userSeq.toDF("new_user_id").as[String]
    val eventSeq: Seq[(String, String)] = Seq(("event","cust_id01"), ("event","cust_id01"), ("event1", "aaa"))
    val eventDs: Dataset[(String, String)] = eventSeq.toDF("event", "user_id").as[(String, String)]
    val joinDs: Dataset[(String, String, String)] = eventDs.join(userDs, col("user_id") === col("new_user_id"), "left").as[(String, String, String)]
    
    userDs.show(false)
    eventDs.show(false)
    println("joinDs count: " + joinDs.count())
    println("joinDs: ")
    joinDs.collect().foreach(println)
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