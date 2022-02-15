package my.bigdata.spark.window

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/08/22
  **/
object WindowDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
            .builder()
            .master("local[*]")
            .appName("WindowDemo")
            .getOrCreate()
    
    val windowSpec = Window
            .partitionBy(col("CustomerId"), col("date"))
            .orderBy(col("Quantity").desc)
            .rowsBetween(Window.unboundedPreceding, Window.currentRow)
    val mapPurchaseQuantity = max(col("Quantity").over(windowSpec))
  }
}
