package my.bigdata.flink.apitest.transform;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.util.keys.KeySelectorUtil;

/**
 * 转换操作滚动算子案例
 *
 * @author Mr.黄
 * @date 2022/02/16
 **/
public class TransformRollingAggregation {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从文件读取数据
    DataStreamSource<String> dataStreamSource = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 转换成SensorReading类型
    DataStream<SensorReading> mapStream = dataStreamSource.map((MapFunction<String, SensorReading>) line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.parseLong(fields[1]), Double.valueOf(fields[2]));
    });
    
    // 分组
    KeyedStream<SensorReading, String> keyBdStream = mapStream.keyBy(new KeySelector<SensorReading, String>() {
      @Override
      public String
      getKey(SensorReading value) throws Exception {
        return value.getId();
      }
    });
    // 滚动聚合， 取当前最大的温度值
    DataStream<SensorReading> maxStream = keyBdStream.max("temperature");
    SingleOutputStreamOperator<SensorReading> maxByStream = keyBdStream.maxBy("temperature");
  
    // 打印输出
    maxStream.print("max");
    maxByStream.print("maxBy");
    
    // 执行
    env.execute("TransformRollingAggregation");
  }
}