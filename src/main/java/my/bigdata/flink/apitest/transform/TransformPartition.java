package my.bigdata.flink.apitest.transform;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink转换算子重分区操作
 *
 * @author Mr.黄
 * @date 2022/02/19
 **/
public class TransformPartition {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    // 从文件获取数据
    DataStreamSource<String> dataStreamSource = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 1. shuffle
    DataStream<String> shuffleStream = dataStreamSource.shuffle();
  
    // 2. keyBy
    SingleOutputStreamOperator<SensorReading> mapStream = dataStreamSource.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
    KeyedStream<SensorReading, String> keyByStream = mapStream.keyBy((KeySelector<SensorReading, String>) SensorReading::getId);
  
    // 打印数据
    dataStreamSource.print("input");
    shuffleStream.print("shuffle");
    keyByStream.print("keyBy");
    
    // global
    dataStreamSource.global().print("global");
    
    // 执行
    env.execute("TransformPartition");
  }
}