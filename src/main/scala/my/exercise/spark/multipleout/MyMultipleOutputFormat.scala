package my.exercise.spark.multipleOut

import org.apache.hadoop.io.{BytesWritable, Text}
import org.apache.hadoop.mapred.lib.{MultipleSequenceFileOutputFormat, MultipleTextOutputFormat}

/**
  * ${description}
  *
  * @author Mr.黄
  * @date 2021/07/30
  **/
class MyMultipleOutputFormat extends MultipleSequenceFileOutputFormat[Any, Any] {
  override def generateFileNameForKeyValue(key: Any, value: Any, name: String): String = {
    s"${key.asInstanceOf[String].split("\u0001")(0)}/$name"
  }
  
  override def generateActualKey(key: Any, value: Any): BytesWritable = {
    new BytesWritable()
  }
}

object A {
  def main(args: Array[String]): Unit = {
    println(new BytesWritable().toString)
    println(0.toByte)
  }
}