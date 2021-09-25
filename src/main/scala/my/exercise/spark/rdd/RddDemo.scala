package my.exercise.spark.rdd

import java.util.Random

import org.apache.spark.HashPartitioner
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
    val keyword: RDD[(String, String)] = words.keyBy((word: String) => word.toLowerCase.toSeq.head.toString)
    val chars = words.flatMap(word => word.toLowerCase.toSeq)
    val KVcharcters = chars.map(letter => (letter, 1))
    /*
    keyword.mapValues((word: String) => word.toUpperCase).collect().foreach(println)
    println()
    keyword.flatMapValues((word: String) => word.toUpperCase).collect().foreach(println)
    
    println()
    keyword.lookup("s")
    
    val map = keyword.countByKey()
    println(map)
    println()
    
    val nums = spark.sparkContext.parallelize(1 to 30, 5)
    nums.aggregate(0)(maxFunc, addFunc)
    
    val depth = 3
    nums.treeAggregate(0)(maxFunc, addFunc)
    
//    keyword.foldByKey("0")(addFunc)
    */
    
    // cogroup
    val distinct = words.flatMap(word => word.toLowerCase.toSeq).distinct()
    val charRDD = distinct.map(c => (c, new Random().nextDouble()))
    val charRDD2 = distinct.map(c => (c, new Random().nextDouble()))
    val charRDD3 = distinct.map(c => (c, new Random().nextDouble()))
    val rdd: RDD[(Char, (Iterable[Double], Iterable[Double], Iterable[Double]))] = charRDD.cogroup(charRDD2, charRDD3)
    //    rdd.collect().foreach(println)
    
    println("------------------------------")
    // join
    val keyedChars = distinct.map(c => (c, new Random().nextDouble()))
    val outputPartitions = 10
    //    KVcharcters.join(keyedChars).collect().foreach(println)
    //    KVcharcters.join(keyedChars, outputPartitions).collect().foreach(println)
    
    // zip
    words.collect().foreach(println)
    val numRange: RDD[Int] = spark
            .sparkContext
            .parallelize(0 to 9, 2)
    words.zip(numRange).collect().foreach(println)
    
    // 控制分区
    keyedChars.repartitionAndSortWithinPartitions(new HashPartitioner(9))
  }
  
  def maxFunc(left: Int, right: Int): Int = math.max(left, right)
  
  def addFunc(left: Int, right: Int): Int = left + right
}
