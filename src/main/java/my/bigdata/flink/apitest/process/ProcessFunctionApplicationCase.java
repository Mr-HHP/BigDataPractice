package my.bigdata.flink.apitest.process;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

/**
 * flink process function application case
 *
 * @author Mr.黄
 * @date 2022/03/07
 **/
public class ProcessFunctionApplicationCase {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//    env.setParallelism(1);
    DataStreamSource<String> source = env.socketTextStream("localhost", 7777);
    SingleOutputStreamOperator<SensorReading> dataStream = source.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], new Long(fields[1]), Double.parseDouble(fields[2]));
    });
    
    dataStream.keyBy(SensorReading::getId)
      .process(new TempConsIncreWarning(10))
      .print();
    
    env.execute("processFunctionApplicationCase");
  }
  
  /**
   * 实现自定义处理函数，监测一段时间内的温度连续上升，输出报警
   */
  public static class TempConsIncreWarning extends KeyedProcessFunction<String, SensorReading, String> {
    // 定义私有属性，当前统计的时间间隔
    private Integer interval;
    // 定义状态，保存上一次的温度值，定时器时间戳
    private ValueState<Double> lastTempStates;
    private ValueState<Long> timerState;
    
    public TempConsIncreWarning(Integer interval) {
      this.interval = interval;
    }
    
    @Override
    public void open(Configuration parameters) throws Exception {
      lastTempStates = getRuntimeContext().getState(new ValueStateDescriptor<Double>("last-temp", Double.class));
      timerState = getRuntimeContext().getState(new ValueStateDescriptor<Long>("timer-ts", Long.class));
    }
    
    @Override
    public void processElement(SensorReading value, Context ctx, Collector<String> out) throws Exception {
      // 取出状态
      Double lastTemp = lastTempStates.value() == null ? 0.0 : lastTempStates.value();
      // 如果温度上升并且没有定时器，注册10秒后的定时器，开始等待
      if (value.getTemperature() > lastTemp && timerState.value() == null) {
        // 计算出定时器时间戳
        long ts = ctx.timerService().currentProcessingTime() + interval * 1000L;
        ctx.timerService().registerProcessingTimeTimer(ts);
        timerState.update(ts);
      } else if (value.getTemperature() < lastTemp && timerState.value() != null) {
        // 如果温度下降，那么删除定时器
        ctx.timerService().deleteProcessingTimeTimer(timerState.value());
        timerState.clear();
      }
      // 更新温度状态
      lastTempStates.update(value.getTemperature());
    }
  
    @Override
    public void onTimer(long timestamp, OnTimerContext ctx, Collector<String> out) throws Exception {
      // 定时器触发，输出报警信息
      out.collect("传感器 " + ctx.getCurrentKey() + " 温度值连续" + interval + "s上升");
      timerState.clear();
    }
  
    @Override
    public void close() throws Exception {
      lastTempStates.clear();
    }
  }
}