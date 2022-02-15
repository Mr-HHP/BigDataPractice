package my.bigdata.flink.apitest.source;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * flink练习：从集合获取数据源
 *
 * @author Mr.黄
 * @date 2022/02/12
 **/
public class SourceFromCollection {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从集合中读取数据
    DataStream<SensorReading> dataStreamSource = env.fromCollection(Arrays.asList(new SensorReading("sensor_1", 1234567L, 35.8), new SensorReading("sensor_6", 2345678L, 15.4), new SensorReading("sensor_7", 3456789L, 6.7), new SensorReading("sensor_10", 4567890L, 38.1)));
  
    DataStream<Integer> integerDataStreamSource = env.fromElements(1, 2, 4, 67, 189);
    
    // 打印输出
    dataStreamSource.print("data");
    integerDataStreamSource.print("int");
    
    // 执行
    env.execute("SourceFromCollection");
  }
}