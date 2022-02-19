package my.bigdata.flink.apitest.transform;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink转换算子RichFunction案例
 *
 * @author Mr.黄
 * @date 2022/02/19
 **/
public class TransformRichFunction {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//    env.setParallelism(1);
    // 从文件读取数据
    DataStreamSource<String> dataStreamSource = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
  
    // 转换成SensorReading类型
    SingleOutputStreamOperator<SensorReading> mapStream = dataStreamSource.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
    
    DataStream<Tuple2<String, Integer>> resultStrema = mapStream.map(new MyMapper());
    
    // 打印输出
//    dataStreamSource.print("data");
    resultStrema.print("result");
    
    // 执行
    env.execute("TransformRichFunction");
  }
  
  public static class MyMapper0 implements MapFunction<SensorReading, Tuple2<String, Integer>> {
  
    @Override
    public Tuple2<String, Integer> map(SensorReading value) throws Exception {
      return null;
    }
  }
  
  /**
   *  实现自定义富函数类
    */
  public static class MyMapper extends RichMapFunction<SensorReading, Tuple2<String, Integer>> {
    @Override
    public void close() throws Exception {
      // 一般是关闭连接和清空状态的工作
      System.out.println("close");
    }
  
    @Override
    public void open(Configuration parameters) throws Exception {
      // 初始化工作，一般是定义状态，或者建立数据库连接
      System.out.println("open");
    }
  
    @Override
    public Tuple2<String, Integer> map(SensorReading value) throws Exception {
      return new Tuple2<>(value.getId(), getRuntimeContext().getIndexOfThisSubtask());
    }
  }
}