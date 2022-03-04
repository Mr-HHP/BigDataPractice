package my.bigdata.flink.apitest.state;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * flink keyed state案例
 *
 * @author Mr.黄
 * @date 2022/03/05
 **/
public class KeyedStateApplicationCase {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
  
    DataStreamSource<String> streamSource = env.socketTextStream("localhost", 7777);
  
    SingleOutputStreamOperator<SensorReading> dateStream = streamSource.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], new Long(fields[1]), Double.valueOf(fields[2]));
    });
    
    // 定义一个flatmap操作，检测温度跳变，输出报警
    SingleOutputStreamOperator<Tuple3<String, Double, Double>> resultStream = dateStream.keyBy(SensorReading::getId)
      .flatMap(new TempChangeWarning(10.9));
    
    resultStream.print();
  
    env.execute("keyedStateApplicationCase");
  }
  
  public static class TempChangeWarning extends RichFlatMapFunction<SensorReading, Tuple3<String, Double, Double>> {
    // 私有属性，当前温度跳变的阈值
    private Double threshold;
    
    // 定义状态，保存上一次的温度值
    private ValueState<Double> lastTempState;
  
    public TempChangeWarning(Double threshold) {
      this.threshold = threshold;
    }
  
    @Override
    public void flatMap(SensorReading value, Collector<Tuple3<String, Double, Double>> out) throws Exception {
      // 获取状态
      Double lastTmep = lastTempState.value();
      if (lastTmep != null) {
        // 如果状态不为null，那么就判断两次温度插值
        double diff = Math.abs(value.getTemperature() - lastTmep);
        if (diff >= threshold) {
          out.collect(new Tuple3<>(value.getId(), lastTmep, value.getTemperature()));
        }
      }
      // 更新状态
      lastTempState.update(value.getTemperature());
    }
  
    @Override
    public void close() throws Exception {
      lastTempState.clear();
    }
  
    @Override
    public void open(Configuration parameters) throws Exception {
      lastTempState = getRuntimeContext().getState(new ValueStateDescriptor<Double>("last-temp", Double.class));
    }
  }
}