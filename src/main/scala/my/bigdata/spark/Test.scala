package my.bigdata.spark


import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._


/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/01/19
  **/
case class L(i: String, j: Int, k: String)

object Test {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[*]").getOrCreate()
    import spark.implicits._
  
    val df: DataFrame = Seq((1, 21), (1, 23), (1, 24), (1, 25), (2, 22), (2, 23)).toDF("device_id", "log_day")
    df.createTempView("user_log")
    spark.sql("select * from user_log").show(true)
    spark.sql("select a.log_day day,count(distinct(a.device_id)) c0,count(distinct(c.device_id)) c3 from user_log a left join user_log c on a.device_id = c.device_id and c.log_day = a.log_day + 3 group by a.log_day").show(true)
  
    spark.sql("select a.log_day day,a.device_id,c.log_day,c.device_id c3 from user_log a left join user_log c on a.device_id = c.device_id and c.log_day = a.log_day + 3").show(true)
  
  
    spark.sql("select *,round(100 * c3/c0, 2) t from (select a.log_day day,count(distinct(a.device_id)) c0,count(distinct(c.device_id)) c3 from user_log a left join user_log c on a.device_id = c.device_id and c.log_day = a.log_day + 3 group by a.log_day) p").show(true)
  }
  
  
}
