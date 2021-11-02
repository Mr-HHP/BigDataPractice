package my.exercise.spark.other

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
    val spark: SparkSession = SparkSession.builder().master("local[*]").getOrCreate()
    import spark.implicits._
    val seq = Seq(("a", "A", "i"), ("a", "A", "i"), ("b", "b", "i"))
    seq.toDF("i", "j", "k").groupBy(col("i"), col("j")).count().show(false)
    
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