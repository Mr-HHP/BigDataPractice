package my.bigdata.flink.apitest.process;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.TimerService;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

/**
 * flink processFunction案例
 *
 * @author Mr.黄
 * @date 2022/03/06
 **/
public class ProcessFunctionCase {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    
    DataStreamSource<String> streamSource = env.socketTextStream("localhost", 7777);
    SingleOutputStreamOperator<SensorReading> dataStream = streamSource.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), new Double(fields[2]));
    });
    
    // 测试KeyProcessFunction，先分组然后自定义处理
    DataStreamSink print = dataStream.keyBy((KeySelector<SensorReading, String>) SensorReading::getId)
      .process(new MyProcess())
      .print();
    
    env.execute("processFunctionCase");
  }
  
  /**
   * 实现自定义的处理函数
   */
  public static class MyProcess extends KeyedProcessFunction<String, SensorReading, Integer> {
    ValueState<Long> tsTimerState;
    
    @Override
    public void open(Configuration parameters) throws Exception {
      tsTimerState = getRuntimeContext().getState(new ValueStateDescriptor<Long>("ts-timers", Long.class));
    }
  
    @Override
    public void close() throws Exception {
      tsTimerState.clear();
    }
  
    @Override
    public void processElement(SensorReading value, Context ctx, Collector<Integer> out) throws Exception {
      out.collect(value.getId().length());
      
      // context
      ctx.timestamp();
      ctx.getCurrentKey();
//      ctx.output();
      TimerService timerService = ctx.timerService();
      long currentProcessingTime = timerService.currentProcessingTime();
      timerService.currentWatermark();
      timerService.registerProcessingTimeTimer(currentProcessingTime + 1000L);
      tsTimerState.update(currentProcessingTime);
//      timerService.registerEventTimeTimer((value.getTimestamp() + 10) * 1000);
//      timerService.deleteProcessingTimeTimer(10000L);
//      timerService.deleteEventTimeTimer((value.getTimestamp() + 10) * 1000);
//      timerService.deleteProcessingTimeTimer(currentProcessingTime);
    }
    
    @Override
    public void onTimer(long timestamp, OnTimerContext ctx, Collector<Integer> out) throws Exception {
      System.out.println(timestamp + " 定时器触发");
      ctx.getCurrentKey();
//      ctx.output();
      ctx.timeDomain();
    }
  }
}