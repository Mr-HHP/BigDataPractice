package my.exercise.spark.join

import org.apache.spark.sql.{Column, DataFrame, SparkSession}
import org.apache.spark.sql.functions._

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/16
  **/
object JoinDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
            .appName("join_demo")
            .master("local[*]")
            .getOrCreate()
    import spark.implicits._
    val person: DataFrame = Seq(
      (0, "Bill Chambers", 0, Seq(100)),
      (1, "Matei Zaharia", 1, Seq(500, 250, 100)),
      (2, "Michael Armbrust", 1, Seq(250, 100))
    ).toDF("id", "name", "graduate_program", "spark_status")
    
    val graduateProgram: DataFrame = Seq(
      (0, "Masters", "School of Information", "UC Berkeley"),
      (2, "Master,", "EECS", "UC Berkeley"),
      (1, "Ph.D.", "EECS", "UC Berkeley")
    ).toDF("i d", "degree", "department", "school")
    
    val sparkStaus: DataFrame = Seq(
      (500, "Vice President"),
      (250, "PMC Member"),
      (100, "Contributor")
    ).toDF("id", "status")
  
    // join需要用“===”进行等值join
    val joinExpression: Column = person.col("graduate_program") === graduateProgram.col("id")
    
    // 默认inner join，以下都是等价的
    person.join(graduateProgram, joinExpression).show(false)
    person.join(graduateProgram).where(person.col("graduate_program") === graduateProgram.col("id")).show(false)
    person.join(graduateProgram, person.col("graduate_program") === graduateProgram.col("id")).show(false)
    
    // Seq()必须是左右表都存在的字段
    person.join(graduateProgram, Seq("graduate_program", "id")).show(false)
    
    // 对复杂类型的连接操作
    person.withColumnRenamed("id", "personId")
            .join(sparkStaus, expr("array_contains(spark_status, id)"))
            .show(false)
    
    // 显示指定broadcast join
    val joinExpr = person.col("graduate_program") === graduateProgram.col("id")
    person.join(broadcast(graduateProgram), joinExpr).explain(true)
    
  }
}
