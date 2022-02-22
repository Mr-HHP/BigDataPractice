package my.bigdata.flink.apitest.window;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink count window案例
 *
 * @author Mr.黄
 * @date 2022/02/23
 **/
public class FlinkCountWindow {
  public static void main(String[] args) throws Exception {
    // 执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从socket读取数据
    DataStreamSource<String> socketTextStream = env.socketTextStream("localhost", 7777);
    // 转换成SensorReading类型
    SingleOutputStreamOperator<SensorReading> sensorReadingStream = socketTextStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
    // 开计数窗口测试
    SingleOutputStreamOperator<Double> aggregate = sensorReadingStream.keyBy((KeySelector<SensorReading, String>) SensorReading::getId)
      .countWindow(10, 2)
      .aggregate(new MyAvgTemp());
    // 打印输出
    aggregate.print();
  
    // 执行
    env.execute("FlinkCountWindow");
  }
  
  public static class MyAvgTemp implements AggregateFunction<SensorReading, Tuple2<Double, Integer>, Double> {
  
    @Override
    public Tuple2<Double, Integer> createAccumulator() {
      return new Tuple2<>(0.0, 0);
    }
  
    @Override
    public Tuple2<Double, Integer> add(SensorReading value, Tuple2<Double, Integer> accumulator) {
      return new Tuple2<>(accumulator.f0 + value.getTemperature(), accumulator.f1 + 1);
    }
  
    @Override
    public Double getResult(Tuple2<Double, Integer> accumulator) {
      return accumulator.f0 / accumulator.f1;
    }
  
    @Override
    public Tuple2<Double, Integer> merge(Tuple2<Double, Integer> a, Tuple2<Double, Integer> b) {
      return new Tuple2<>(a.f0 + b.f0, a.f1 + b.f1);
    }
  }
}