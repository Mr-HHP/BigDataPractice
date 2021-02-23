package my.exercise.spark

import java.sql.{DriverManager, ResultSet}

import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.{JdbcRDD, RDD}
import org.apache.spark.sql.SparkSession

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/01/19
  **/
object Test {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
                    .builder()
                    .appName("test")
                    .master("local[*]")
                    .getOrCreate()
    
    import spark.implicits._
    
    val list1 = List(("a", 1), ("b", 2), ("c", 3))
    
    val rdd1 = spark.sparkContext.parallelize(list1, 1)
    val rdd2 = spark.sparkContext.parallelize(list1, 2)
    
//    println(rdd2.partitionBy(new HashPartitioner(2)).partitioner)
    
//    println(rdd1.partitioner)
//    println(rdd2.partitioner)
    
    
    val rdd3 = spark.sparkContext.parallelize(List(1, 2, 3))
    
    val df1 = rdd1.toDF()
    
    df1.map(row => {
      row.getString(1)
    })
    
    val ds1 = rdd1.toDS()
    ds1.map(data => {
      data._1
      data._2
    })
    
    df1.registerTempTable("")
    df1.createOrReplaceTempView("")
    df1.createTempView("")
    df1.createGlobalTempView("")
    
    val stats = rdd3.stats()
    println(stats.count)
    println(stats.max)
    println(stats.mean)
    println(stats.min)
    
//    rdd1.mapPartitions()
//    rdd1.mapPartitionsWithIndex()
//    rdd1.map()
    
    def createConnection() = {
      Class.forName("").newInstance()
      DriverManager.getConnection("")
    }
  
    def extractValues(r: ResultSet) = {
      (r.getInt(1), r.getString(2))
    }
    
    val data = new JdbcRDD(spark.sparkContext, createConnection, "", lowerBound = 1, upperBound = 3, numPartitions = 2, mapRow = extractValues)
    
//    println(data.collect().toList)
    
  }
  
  
  
}
