package my.bigdata.flink.apitest.process;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

/**
 * flink process function侧输出流案例
 *
 * @author Mr.黄
 * @date 2022/03/07
 **/
public class ProcessFunctionSideOutput {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    DataStreamSource<String> socketTextStream = env.socketTextStream("localhost", 7777);
    SingleOutputStreamOperator<SensorReading> dataStream = socketTextStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.parseLong(fields[1]), new Double(fields[2]));
    });
    
    // 定义一个outputTag，用来表示侧输出流低温流
    OutputTag<SensorReading> lowTempTag = new OutputTag<SensorReading>("lowTemp") {
    };
    // 测试ProcessFunction，自定义测输出流实现分流操作
    SingleOutputStreamOperator<SensorReading> highTempStream = dataStream.process(new ProcessFunction<SensorReading, SensorReading>() {
      @Override
      public void processElement(SensorReading value, Context ctx, Collector<SensorReading> out) throws Exception {
        // 判断温度大于30度，高温流输出到主流；小于30度低温流输出到侧输出流
        if (value.getTemperature() > 30) {
          out.collect(value);
        } else {
          ctx.output(lowTempTag, value);
        }
      }
    });
    
    highTempStream.print("high-temp");
    highTempStream.getSideOutput(lowTempTag).print("low-temp");
  
    env.execute("processFunctionSideOutput");
  }
}