package my.bigdata.flink.apitest.window;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.eventtime.*;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.ReadableConfig;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.time.Duration;

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
    env.setParallelism(1);
    ExecutionConfig config = env.getConfig();
    config.setAutoWatermarkInterval(100);
    
    DataStreamSource<String> socketTextStream = env.socketTextStream("localhost", 7777);
    // 转换成SensorReading类型，已经分配了时间戳和watermark
    DataStream<SensorReading> watermarkStream = socketTextStream.map((MapFunction<String, SensorReading>) value -> {
      String[] fields = value.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    })
      .assignTimestampsAndWatermarks(WatermarkStrategy.<SensorReading>forBoundedOutOfOrderness(Duration.ofMillis(200L))
        .withTimestampAssigner((SerializableTimestampAssigner<SensorReading>) (element, recordTimestamp) -> element.getTimestamp() * 1000));
    
    // 基于事件时间的开窗聚合，统计15秒内的温度最小是
    DataStream<SensorReading> minTempStream = watermarkStream
      .keyBy((KeySelector<SensorReading, String>) SensorReading::getId)
      .window(TumblingEventTimeWindows.of(Time.seconds(15L)))
      .min("temperature");
    
    minTempStream.print("minTemp");
    
    env.execute("FlinkEventTimeWindow");
  }
}