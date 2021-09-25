package my.exercise.spark.broadcast

import org.apache.spark.sql.SparkSession

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/09/02
  **/
object BroadcastDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
            .builder()
            .master("local[*]")
            .appName("broadcastDemo")
            .getOrCreate()
    
  }
}
