package my.exercise.spark

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StructField, StructType}

/**
  * 计算平均值的UDAF样例
  *
  * @author Mr.黄
  * @date 2021/07/15
  **/
object AverageUserDefinedAggregateFunction extends UserDefinedAggregateFunction{
  // 指定聚合函数的输入参数，输入类型为StructType类型
  override def inputSchema: StructType = StructType(StructField("input", LongType) :: Nil)
  
  // 用于指定UDAF中间结果，缓存区的数据结构
  override def bufferSchema: StructType = StructType(StructField("sum", LongType) :: Nil)
  
  // UDAF函数返回值的数据类型
  override def dataType: DataType = DoubleType
  
  // 聚合函数是否是幂等，即相同输入是否总能得到相同输出
  override def deterministic: Boolean = true
  
  // 初始化聚合函数缓存区的初始值
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = 0L
  }
  
  // 给聚合函数传入一条新数据进行处理
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    if (input.isNullAt(0)) {
      return
    }
    buffer(0) = buffer.getLong(0) + input.getLong(0)
    buffer(1) = buffer.getLong(1) + 1
  }
  
  // 合并聚合函数缓冲区
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }
  
  // 计算最终结果
  override def evaluate(buffer: Row): Any = {
    buffer.getLong(0).toDouble / buffer.getLong(1)
  }
}
