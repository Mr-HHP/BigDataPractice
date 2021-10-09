package my.exercise.spark.graphx

import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._
import org.graphframes._

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/09/26
  **/
object GraphXDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession
            .builder()
            .master("local[*]")
            .getOrCreate()
    
    // 读取数据构建顶点df和边df
    val bikeStations: DataFrame = spark
            .read
            .option("header", "true")
            .csv("D:\\BigDataProject\\MySpark\\src\\main\\data\\bike-data\\201508_station_data.csv")
    val tripData: DataFrame = spark
            .read
            .option("header", "true")
            .csv("D:\\BigDataProject\\MySpark\\src\\main\\data\\bike-data\\201508_trip_data.csv")
    
    // 格式化列名
    // 顶点df
    val stationVertices: Dataset[Row] = bikeStations
            .withColumnRenamed("name", "id")
            .distinct()
    // 边df
    val tripEdges: Dataset[Row] = tripData
            .withColumnRenamed("Start Station", "src")
            .withColumnRenamed("End Station", "dst")
    
    //    stationVertices.collect().foreach(println(_: Row))
    //    tripEdges.show(false)
    
    // 通过顶点df和边df构建图df
    val stationGraph: GraphFrame = GraphFrame(stationVertices, tripEdges)
    stationGraph.cache()
    //    println(s"Total Number of Stations: ${stationGraph.vertices.count()}")
    //    println(s"Total Number of Trips in Graph: ${stationGraph.edges.count()}")
    //    println(s"Total Number of Trips in Original Data: ${tripData.count()}")
    
    val edges: DataFrame = stationGraph.edges
    val vertices: DataFrame = stationGraph.vertices
    //    edges.show(false)
    //    vertices.show(false)
    
    edges
            .groupBy("src", "dst")
            .count()
            .orderBy(desc("count"))
    //            .show(false)
    
    // 构建子图
    val townAnd7thEdges: Dataset[Row] = stationGraph
            .edges
            .where("src = 'Townsend at 7th' OR dst = 'Townsend at 7th'")
    val subgraph: GraphFrame = GraphFrame(stationGraph.vertices, townAnd7thEdges)
    
    // 模式发现
    val motif: DataFrame = stationGraph.find("(a)-[ab]->(b); (b)-[bc]->(c); (c)-[ca]->(a)")
    val triplets: DataFrame = stationGraph.triplets
    //    println(triplets.schema)
    //    stationGraph.find("(a)-[ab]->(b)").show(false)
    //    triplets.show(false)
    //    motif.show(false)
    
    // 查询a->b->c->a的最短行程
    motif.selectExpr("*",
      "to_timestamp(ab.`Start Date`, 'MM/dd/yyyy HH:mm') as abStart",
      "to_timestamp(bc.`Start Date`, 'MM/dd/yyyy HH:mm') as bcStart",
      "to_timestamp(ca.`Start Date`, 'MM/dd/yyyy HH:mm') as caStart")
            .where("ca.`Bike #` = bc.`Bike #`")
            .where("ab.`Bike #` = bc.`Bike #`")
            .where("a.id != b.id")
            .where("b.id != c.id")
            .where("abStart < bcStart")
            .where("bcStart < caStart")
            .orderBy(expr("cast(caStart as long) - cast(abStart as long)"))
            .selectExpr("a.id", "b.id", "c.id", "ab.`Start Date`", "ca.`End Date`")
            .limit(1)
    //            .show(false)
    
    // 获取重要的单车站 PageRank算法
    val ranks: GraphFrame = stationGraph.pageRank.resetProbability(0.15).maxIter(10).run()
    
    // 入度、出度
    val inDeg: DataFrame = stationGraph.inDegrees
    println(inDeg.schema)
    //    inDeg.orderBy(desc("inDegree")).show(false)
    val outDegrees: DataFrame = stationGraph.outDegrees
    //    outDegrees.orderBy(desc("outDegree")).show(false)
    
    val degreeRatio: DataFrame = inDeg.join(outDegrees, Seq("id"))
            .selectExpr("id", "double(inDegree)/double(outDegree) as degreeRatio")
    degreeRatio.orderBy(desc("degreeRatio")).show(false)
    degreeRatio.orderBy("degreeRatio").show(false)
    
    // 广度优先搜索 BFS
    stationGraph
            .bfs
            .fromExpr("id = 'Townsend at 7th'")
            .toExpr("id = 'Spear at Folsom'")
            .maxPathLength(2)
            .run()
            .show(false)
    
    // 连通分量
    spark.sparkContext.setCheckpointDir("D:\\tmp\\checkpoints")
    val minGraph: GraphFrame = GraphFrame(stationVertices, tripEdges.sample(withReplacement = false, 0.1))
    val cc: DataFrame = minGraph.connectedComponents.run()
    cc.where("component != 0").show(false)
    
    
  }
  
}
