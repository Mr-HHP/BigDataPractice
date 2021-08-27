package my.exercise.spark.sparkSql

import org.apache.spark.sql.SparkSession

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/08/05
  **/
object SparkSqlDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
            .master("local[*]")
            .appName("spark-sql-demo")
            .getOrCreate()
    import spark.implicits._
        val seq: Seq[(String, String, String)] = Seq(("a", "b", "c"), ("1", "2", "3"))
//    val seq: Seq[String] = Seq("a", "b", "c")
    val df = seq.toDF("col_1", "col_2", "col_3")
//    df.explain(true)
//    println("=========================")

//    df.collect().foreach(println)
    df.foreach(row => println(row.getString(0) + "\t" + row.getString(1)))
    
    val ds = df.map(row => (row.getString(0), row.getString(1), row.getString(2)))
    df.show(false)
    df.collect().foreach(println)
    ds.show(false)
  }
  
}
