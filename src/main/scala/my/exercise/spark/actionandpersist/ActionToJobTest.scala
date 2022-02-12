package my.exercise.spark.actionandpersist

import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.storage.StorageLevel

/**
  * 检验action算子触发多个job的原因
  * 怀疑是persist缓存引起的
  *
  * @author Mr.黄
  * @date 2021/11/14
  **/
object ActionToJobTest {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
      .builder()
      .appName("ActionToJobTest")
      .enableHiveSupport()
      .getOrCreate()
    import spark.implicits._
    val sql: String = "select * from saas_prds_hma_dw.hma_parquet where `date`='20211001'"
    val originalDf: DataFrame = spark.sql(sql).select("session_id", "date", "ua", "type", "geo.IP", "nginx_time").persist(StorageLevel.MEMORY_AND_DISK_SER)
    originalDf.count()
    val df: DataFrame = originalDf
      .filter((row: Row) => row.getAs[Long]("nginx_time").toString.length == 13)
      .select("session_id", "date", "ua", "type", "IP", "nginx_time")
      .persist(StorageLevel.MEMORY_AND_DISK_SER)
    
    df.count()
    
    val df1: DataFrame = df.map((row: Row) => (row.getAs[String]("type"), row.getAs[String]("date"), row.getAs[String]("ua"), row.getAs[String]("session_id"), row.getAs[String]("IP"), row.getAs[Long]("nginx_time")))
      .toDF("session_id", "date", "ua", "type", "IP", "nginx_time")
      .filter(col("session_id").isNotNull)
      .union(df)
      .persist(StorageLevel.MEMORY_AND_DISK_SER)
    
    val sessionIdCount: Long = df.map((row: Row) => (row.getAs[String]("type"), row.getAs[String]("date"), row.getAs[String]("ua"), row.getAs[String]("session_id"), row.getAs[String]("IP"), row.getAs[Long]("nginx_time")))
      .toDF("session_id", "date", "ua", "type", "IP", "nginx_time").groupBy("session_id")
      .count()
      .count()
    
    println("unionCount: " + df1.count())
    df1.show(false)
    //    val dfCount: Long = df.count()
    //    println("dfCount: " + dfCount)
    println("sessionIdCount: " + sessionIdCount)
    
  }
}
