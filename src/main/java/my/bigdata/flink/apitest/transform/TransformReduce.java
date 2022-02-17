package my.bigdata.flink.apitest.transform;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink转换算子reduce案例
 *
 * @author Mr.黄
 * @date 2022/02/16
 **/
public class TransformReduce {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 文件读取数据
    DataStreamSource<String> dataStreamSource = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 转换成SensorReading类型
    SingleOutputStreamOperator<SensorReading> mapStream = dataStreamSource.map((MapFunction<String, SensorReading>) line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
    // 分组
    KeyedStream<SensorReading, String> keyByStream = mapStream.keyBy((KeySelector<SensorReading, String>) SensorReading::getId);
    
    // reduce聚合，取最大的温度值，以及当前最新的时间戳
    SingleOutputStreamOperator<SensorReading> reduceStream = keyByStream.reduce((ReduceFunction<SensorReading>) (value1, value2) -> new SensorReading(value1.getId(), value2.getTimestamp(), Math.max(value1.getTemperature(), value2.getTemperature())));
  
    // 打印输出
    reduceStream.print();
    // 执行
    env.execute("TransformReduce");
  }
}