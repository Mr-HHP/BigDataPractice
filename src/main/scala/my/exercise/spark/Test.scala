package my.exercise.spark

import java.sql.{DriverManager, ResultSet}

import my.protobuf_test.PresonOuterClass
import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.{JdbcRDD, RDD}
import org.apache.spark.sql.expressions.{UserDefinedFunction, Window, WindowSpec}
import org.apache.spark.sql.{Column, DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructField, StructType}


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
            .master("local[*]")
            .appName("spark_test")
            .getOrCreate()
    import spark.implicits._
    val seq: Seq[(String, Int, String)] = Seq(("a", 1, "a"), ("b", 2, "b"), ("c", 3, "c"), ("d", 1, "d"))
    val df: DataFrame = seq.toDF()
    //    df.show(false)
    //    df.select(expr("*"), lit(1).as("One")).show(false)
    //    df.withColumn("id", expr("_1")).show(false)
    //    df.where(col(""))
    //    df.where("").distinct().sample(9)
    //    df.where($"_1" =!= "a").show(false)
    //    df.where($"_1" === "a").show(false)
    //    df.sort($"_1").show(false)
    //    df.sort(expr("_1 asc")).show(false)
    //    df.sort(desc("_1")).show(false)
    //    df.sort("_1")
    //    df.orderBy(col("_1"))
    //    df.orderBy("_1")
    //    df.orderBy(expr("_1 desc")).show(false)
    //    df.orderBy(desc("_1")).show(false)
    //    df.orderBy(expr("_1 asc")).show(false)
    //    df.sortWithinPartitions("")
    //    df.select(lit(4) === "")
    //    val it = df.toLocalIterator()
    //    df.where("_2 = 1").show(false)
    //    df.where("_2 <> 1").show(false)
    //    df.describe().show(false)
    //    val D = col("") === ""
    //    df.withColumn("", (col("") === "").and(D))
    //    df.select(pow(col(""), 2))
    //    df.stat.corr("", "")
    //    df.select(corr("", ""))
//        df.stat.approxQuantile("", Array[Double](), 7)
    //    df.stat.crosstab("", "")
    //    initcap(col(""))
    //    regexp_replace(col(""), "", "")
    //    translate(col(""), "", "")
    //    instr(col(""), "")
    //    regexp_extract(col(""), "", 9)
    //    lpad(col(""), 9, "")
    //    df.select(initcap(col("")))
    //    df.stat
    //    expr("")
    //    df.select(coalesce(col("_1"), lit(null), lit("hahaah"))).show(false)
    //    df.schema.printTreeString()
    //    df.na.drop("")
    //    df.na.fill("")
    //    df.na.replace("", Map())
    //    df.select(struct())
    //    size(col(""))
    //    explode(col(""))
    //    explode_outer(col(""))
    //    array_contains(col(""), "")
    //
    //    get_json_object(col(""), "")
    //    json_tuple(col(""), "")
    //    to_json(col(""))
    //    from_json(col(""), col(""))
    //
    //    val parseSchema = new StructType(Array(new StructField("i", StringType, true), new StructField("j", StringType, true)))
    //    df.select(expr("(i, j) as myStruct"))
    //            .select(to_json(col("myStruct"))).alias("newJson")
    //            .select(from_json(col("newJson"), parseSchema), col("newJson"))
    //            .show(2)
    //
    //    val power3udf: UserDefinedFunction = udf(power3(_: Double): Double)
    //
    //    df.select(power3udf(col("")))
    //
    //    spark.udf.register("power3", power3(_: Double): Double)
    //
    //    df.groupBy(col(""))
    //    df.rollup(col(""))
    //    df.cube(col(""))
    //
    //    df.count()
    //    df.select(count(col("")))
    //    df.select(countDistinct(col("")))
    //    df.select(approx_count_distinct(col("")))
//        approx_count_distinct(col(""), 0.9)
    //
    //    df.select(first(col("")), last(col("")))
    
    //    df.select(sum(col("_2")), sumDistinct(col("_2"))).show(false)
    
    //    mean(col(""))
    
    //    df.select(var_pop(""), var_samp(col("")), variance(col("")), stddev(col("")))
    
    //    df.agg(collect_list(col("")), collect_set(col("")))
    //    df.groupBy().agg(count(col("")).alias(""), expr("count(_1)").as(""))
    
    //    val map: Map[String, String] = Map("_1" -> "count", "_2" -> "avg")
    //    df.groupBy().agg(map)
    
    // spark streaming流式处理所使用的时间窗口
//    window(col(""), "")
//
//    val windowSpec: WindowSpec = Window.partitionBy(col(""))
//            .orderBy(col(""))
//            .rowsBetween(Window.unboundedPreceding, Window.currentRow)
//
//    val denseRank: Column = dense_rank().over(windowSpec)
//    val rank1: Column = rank().over(windowSpec)
//    val maxNum: Column = max(col("")).over(windowSpec)
//    df.select(
//      col(""),
//      col(""),
//      denseRank.alias("denseRank"),
//      rank1.alias("rank"),
//      maxNum.alias("maxNum")).show()
    
    // 删除列，无参的drop不做任何操作
//    df.drop().show(false)
//    df.drop(col("_1")).show(false)
//    // 删除行
//    df.na.drop().show(false)
//
//    df.cube(col(""))
//                    .agg(sum(col("")))
//                    .select()
//                    .orderBy()
//                    .show(false)
//
//    df.rollup(col(""))
//            .agg(sum(""))
//            .select()
//            .orderBy(col(""))
//            .show(false)
    
    df.cube(col("_1"), col("_3"))
            .agg(grouping_id().alias("grouping_id"), sum("_2"))
            .orderBy(col("grouping_id").asc)
            .show(false)
    
    df.groupBy(col("")).pivot(col("")).sum("")
    df.groupBy(col("")).pivot(col(""), Seq()).sum("")
    
    
    
    
  }
  
  def power3(number: Double): Double = number * number * number
  
  
}
