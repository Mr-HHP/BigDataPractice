package my.bigdata.flink.apitest.window;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.OutputTag;

/**
 * flink 时间窗口其他API操作
 *
 * @author Mr.黄
 * @date 2022/02/24
 **/
public class FlinkTimeWindow2 {
  public static void main(String[] args) {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    
    DataStream<String> socketStream = env.socketTextStream("localhost", 7777);
    
    SingleOutputStreamOperator<SensorReading> dataStream = socketStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
    
    OutputTag<SensorReading> outputTag = new OutputTag<SensorReading>("late") {
    };
    SingleOutputStreamOperator<SensorReading> sumStream = dataStream.keyBy(SensorReading::getId)
      .window(TumblingProcessingTimeWindows.of(Time.seconds(15L)))
//      .trigger()
//      .evictor()
      .allowedLateness(Time.minutes(1))
      .sideOutputLateData(outputTag)
      .sum("temperature");
    DataStream<SensorReading> resultStream = sumStream.getSideOutput(outputTag);
    resultStream.print();
    
  }
}