package my.exercise.spark.other

import java.util

import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}
import org.apache.spark.sql.{Dataset, SparkSession}
import org.slf4j.{Logger, LoggerFactory}

import scala.collection.Map
import scala.collection.JavaConverters._

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
    val seq: Seq[A] = Seq(A("i", "j", Map("a" -> "a"), B("i", "j")), A("i", "j", Map("a" -> "a"), B("i", "j")))
    import spark.implicits._
    val ds: Dataset[A] = seq.toDS()
    val df1 = ds
    val df2 = df1.filter(a => "100".equals(a.id)).map(a => A(a.id, a.name, a.info, a.b))
    val df3 = df2.filter(a => "100".equals(a.id)).map(a => A(a.id, a.name, a.info, a.b))
    
    val list = new util.ArrayList[String]()
    val map = spark.sparkContext.broadcast(Map("i" -> list.asScala.toSeq, "j" -> list.asScala.toSeq))
    println("map: \t" + map.value)
    df1.show(false)
    val df4 = df1.map((a: A) => {
      val seq: Seq[String] = map.value.getOrElse(a.id, Seq(a.id))
      println(seq + "\t" + seq.size)
      seq.map((s: String) => A(s, a.name, a.info, a.b))
    }).flatMap((seq: Seq[A]) => seq)
    
    df4.schema.printTreeString()
    df4.show(false)
    
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