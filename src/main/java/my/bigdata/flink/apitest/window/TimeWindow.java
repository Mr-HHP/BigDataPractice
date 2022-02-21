package my.bigdata.flink.apitest.window;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * flink time Window案例
 *
 * @author Mr.黄
 * @date 2022/02/21
 **/
public class TimeWindow {
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
    
    // 控制台输出
    resultStream.print();
  
    // 执行
    env.execute("timeWindow");
  }
}