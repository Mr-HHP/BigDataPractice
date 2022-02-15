package my.bigdata.spark.readandwrite

import java.util.Properties

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.{LongType, StructField, StructType}

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/21
  **/
object ReadAndWriteDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
            .master("local[*]")
            .appName("readDemo")
            .getOrCreate()
    
    
    // #####　csv read #####
    val myManualSchema: StructType = new StructType(Array(new StructField("dest_count_name", LongType, true), new StructField("origin_count_name", LongType, true), new StructField("count", LongType, false)))
    val csvFile: DataFrame = spark.read.format("csv")
            .option("header", "true")
            .option("mode", "FAILFAST")
            .schema(myManualSchema)
            .load("path")
    
    // ##### jdbc read #####
    val pushdownQuery: String =
      s"""(select distinct(dest_count_name))
         |from flight_info as flight_info""".stripMargin
    spark.read
            .format("jdbc")
            .option("url", "")
            .option("dbtable", pushdownQuery)
            .option("driver", "")
            .load("")
    
    spark.read.format("jdbc")
            .option("url", "")
            .option("dbtable", "tableName")
            .option("driver", "")
            .option("numPartitions", 10)
    
    val props: Properties = new java.util.Properties()
    props.setProperty("driver", "org.sqlite.JDBC")
    val predicates: Array[String] = Array("dest_country_name = 'Sweden' or origin_country_name = 'Sweden'", "dest_country_name = 'Anguilla' or origin_country_name = 'Anguilla'")
    spark.read.jdbc("url", "tablename", predicates, props).show()
    spark.read.jdbc("url", "tableName", predicates, props).rdd.getNumPartitions
    
    val colName: String = "count"
    val lowerBound: Long = 0l
    val upperBound: Long = 1000l
    val numPartitions: Int = 10
    spark.read.jdbc("url", "tableName", colName, lowerBound, upperBound, numPartitions, props).count()
    
    
    // ##### jdbc write #####
    val newPath: String = "jdbc:sqlite://tmp/my-sqlite.db"
    csvFile.write.mode("overwrite").jdbc(newPath, "tableName", props)
    csvFile.write.mode("append").jdbc(newPath, "tableName", props)
    
    
    // ##### text read and write #####
    spark.read.textFile("")
    spark.read.text("")
    
    
    
  }
}
