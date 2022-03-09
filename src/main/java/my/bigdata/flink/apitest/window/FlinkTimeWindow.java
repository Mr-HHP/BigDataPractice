package my.bigdata.flink.apitest.window;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.commons.collections.IteratorUtils;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * flink time Window案例
 *
 * @author Mr.黄
 * @date 2022/02/21
 **/
public class FlinkTimeWindow {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从文件读取数据
//    DataStreamSource<String> inputStream = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // socket文本流
    DataStreamSource<String> inputStream = env.socketTextStream("localhost", 7777);
    SingleOutputStreamOperator<SensorReading> dataStream = inputStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.parseDouble(fields[2]));
    });
    
    // 开窗测试
    
    // 增量聚合函数
    SingleOutputStreamOperator<Integer> resultStream = dataStream.keyBy((KeySelector<SensorReading, String>) SensorReading::getId)
      .window(TumblingProcessingTimeWindows.of(Time.seconds(15L)))
      .aggregate(new AggregateFunction<SensorReading, Integer, Integer>() {
        @Override
        public Integer createAccumulator() {
          return 0;
        }
      
        @Override
        public Integer add(SensorReading value, Integer accumulator) {
          return accumulator + 1;
        }
      
        @Override
        public Integer getResult(Integer accumulator) {
          return accumulator;
        }
      
        @Override
        public Integer merge(Integer a, Integer b) {
          return a + b;
        }
      });
    
    // 全窗口函数
    SingleOutputStreamOperator<Tuple3<String, Long, Integer>> applyStream = dataStream.keyBy(SensorReading::getId)
      .window(TumblingProcessingTimeWindows.of(Time.seconds(15L)))
      .apply(new WindowFunction<SensorReading, Tuple3<String, Long, Integer>, String, TimeWindow>() {
        @Override
        public void apply(String s, TimeWindow window, Iterable<SensorReading> input, Collector<Tuple3<String, Long, Integer>> out) throws Exception {
          String id = s;
          Long windowEnd = window.getEnd();
          Integer count = IteratorUtils.toList(input.iterator()).size();
          out.collect(new Tuple3<>(id, windowEnd, count));
        }
      });
  
    // 控制台输出
//    resultStream.print();
    applyStream.print();
  
    // 执行
    env.execute("timeWindow");
  }
}