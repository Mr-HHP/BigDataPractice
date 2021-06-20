package my.exercise.spark

import java.sql.{DriverManager, ResultSet}

import my.protobuf_test.PresonOuterClass
import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.{JdbcRDD, RDD}
import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._

import scala.collection.mutable.ArrayBuffer

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/01/19
  **/
case class L(_1: String, _2: Int)

object Test {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
            .builder()
            .appName("test")
            .master("local[*]")
            .getOrCreate()
    
    import spark.implicits._
    
    val list1 = List(("a", 1), ("b", 2), ("c", 3), ("a", 4))
    val list2 = List(("a", 1), ("d", 2), ("b", 3), ("e", 4))
    val rdd1 = spark.sparkContext.parallelize(list1)
    val rdd2 = spark.sparkContext.parallelize(list2)
    val ds1 = rdd1.toDF().as[L]
    rdd1.toDF().show(false)
    
    ds1.show(false)
    
    val ds11 = ds1.map(d => d.copy(_1 = "iii"))
    ds11.show(false)
    
    val ds111 = ds11.flatMap(d => {
      val result = new ArrayBuffer[L]
      result.append(d)
      result.append(d.copy(_1 = "jjj"))
      result
    })
    
    ds111.show(false)
    
    val ds1111 = ds11.map(d => {
      val result = new ArrayBuffer[L]
      result.append(d)
      result.append(d.copy(_1 = "jjj"))
      result
    })
    ds1111.show(false)
    
    
    
    //    println("{}".format(rdd1.join(rdd2).collect()))
    //    rdd1.join(rdd2).collect().foreach(print)
    //    println()
    //    rdd1.leftOuterJoin(rdd2).collect().foreach(print)
    //    println()
    //    rdd1.rightOuterJoin(rdd2).collect().foreach(print)
    //    println()
    //    rdd1.fullOuterJoin(rdd2).collect().foreach(print)
    
    //    val rdd1 = spark.sparkContext.parallelize(list1, 1)
    //
    //
    //    val df1 = rdd1.toDF()
    //    //    df1.select("*").sort($"")
    //    df1.show(false)
    //    //    df1.select("*")
    //    //            .groupBy($"_1")
    //    //            .agg(last($"_1"), last($"_2"), collect_list($"_1"))
    //    //            .show(false)
    //    df1.printSchema()
    //    rdd1
    //            .toDF
    //            .map((row: Row) => {
    //              Seq(row.getAs[String]("_1"), row.get(1).toString)
    //            })
    //            .show(false)
    //    rdd1.toDF()
    //            .flatMap(row => {
    //              Seq(row.getAs[String]("_1"), row.get(1).toString)
    //            })
    //            .show(false)
    //
    //
    //    val john: PresonOuterClass.Preson = PresonOuterClass
    //            .Preson
    //            .newBuilder()
    //            .setName("John Doe")
    //            .setId(1234)
    //            .setEmail("jode@example.com")
    //            .addPhone(PresonOuterClass.Preson.PhoneNumber.newBuilder()
    //                    .setNumber("555-4321")
    //                    .setType(PresonOuterClass.Preson.PhoneType.HOME)
    //            )
    //            .build();
    //
    //    println(john)
    //    val toByteArray: Array[Byte] = john.toByteArray
    //    val seq: Seq[Array[Byte]] = Seq(toByteArray, toByteArray)
  }
  
  
}
