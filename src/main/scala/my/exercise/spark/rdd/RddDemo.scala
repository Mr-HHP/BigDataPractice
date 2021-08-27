package my.exercise.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/08/27
  **/
object RddDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[*]").getOrCreate()
    val myCollection: Seq[String] = "Spark The Definitive Guide : Big Data Processing Made Simple".split(" ")
    val words: RDD[String] = spark.sparkContext.parallelize(myCollection, 2)
    println(words.distinct().count())
    
    words.filter(s => true)
    
    words.randomSplit(Array(3l))
    
    words.getStorageLevel
    
    spark.sparkContext.setCheckpointDir("")
    words.checkpoint()
    
  }
}
