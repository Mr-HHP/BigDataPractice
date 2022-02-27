package my.bigdata.flink.apitest.window;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.eventtime.BoundedOutOfOrdernessWatermarks;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkGeneratorSupplier;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;

/**
 * flink event time window案例
 *
 * @author Mr.黄
 * @date 2022/02/25
 **/
public class FlinkEventTimeWindow {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    
    env.getStreamTimeCharacteristic();
  
    DataStreamSource<String> socketTextStream = env.socketTextStream("localhost", 7777);
    socketTextStream.map((MapFunction<String, SensorReading>) value -> {
      String[] fields = value.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    }).assignTimestampsAndWatermarks(new WatermarkStrategy<SensorReading>() {
      @Override
      public WatermarkGenerator<SensorReading> createWatermarkGenerator(WatermarkGeneratorSupplier.Context context) {
        return null;
      }
    });
    env.execute("FlinkEventTimeWindow");
  }
}