package my.exercise.spark.other

import java.util.regex.Pattern

import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}
import org.apache.spark.sql.SparkSession
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
//    val spark: SparkSession = SparkSession.builder().master("local[*]").getOrCreate()
//    import spark.implicits._
//    val seq = Seq(("a", "A", "i"), ("a", "A", "i"), ("b", "b", "i"))
//    seq.toDF("i", "j", "k").groupBy(col("i"), col("j")).count().show(false)
    val pattern = s".*file.*NetworkUitlity\\.java.*"
    val s = "fileNetworkUitlity.java"
    val s1 = "123dffileasdfNetworkUitlity.javaeer"
    val s2 = "adffile%3A+NetworkUitlity.java%3A"
    val s3 = "fdddfile%3A+NetworkUitlity.java%3A"
    val map = Map("s" -> s, "s1" -> s1, "s2" -> s2, "s3" -> s3)
    println(Pattern.matches(pattern, map.getOrElse("s", "other")))
    println(Pattern.matches(pattern, map.getOrElse("s1", "other")))
    println(Pattern.matches(pattern, map.getOrElse("s2", "other")))
    println(Pattern.matches(pattern, map.getOrElse("s3", "other")))
    println(Pattern.matches(pattern, map.getOrElse("a", "other")))
    
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