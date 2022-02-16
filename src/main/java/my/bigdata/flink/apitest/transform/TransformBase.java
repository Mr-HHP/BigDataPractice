package my.bigdata.flink.apitest.transform;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * flink转换基本算子案例
 *
 * @author Mr.黄
 * @date 2022/02/15
 **/
public class TransformBase {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从文件读取
    DataStreamSource<String> dataStreamSource = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 1.map，把String转换成字符长度输出
    SingleOutputStreamOperator<Integer> mapStream = dataStreamSource.map(new MapFunction<String, Integer>() {
      @Override
      public Integer map(String value) throws Exception {
        return value.length();
      }
    });
    
    // 2.flatMap，按逗号切分字段
    DataStream<String> flatMapStream = dataStreamSource.flatMap(new FlatMapFunction<String, String>() {
      @Override
      public void flatMap(String value, Collector<String> out) throws Exception {
        String[] fields = value.split(",");
        for (String field : fields) {
          out.collect(field);
        }
      }
    });
    
    // 3.filter，筛选sensor1开头的id对应的数据
    DataStream<String> filterStream = dataStreamSource.filter(new FilterFunction<String>() {
      @Override
      public boolean filter(String value) throws Exception {
        return value.startsWith("sensor_1");
      }
    });
    
    // 打印输出
    mapStream.print("map");
    flatMapStream.print("flatMap");
    filterStream.print("filter");
  
    // 执行
    env.execute("TransformBase");
  }
}