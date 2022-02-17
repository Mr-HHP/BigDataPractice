package my.bigdata.flink.apitest.transform;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

/**
 * flink转换操作split案例，多流转换
 *
 * @author Mr.黄
 * @date 2022/02/17
 **/
public class TransformMultiple {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从文件获取数据
    DataStream<String> dataStream = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    // 转换成SensorReading类型
    DataStream<SensorReading> mapStream = dataStream.map((MapFunction<String, SensorReading>) line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
  
    // 1. 分流
    OutputTag<SensorReading> highTag = new OutputTag<SensorReading>("high"){};
    OutputTag<SensorReading> lowTag = new OutputTag<SensorReading>("low"){};
//    OutputTag<SensorReading> allTag = new OutputTag<SensorReading>("all"){};
    SingleOutputStreamOperator<SensorReading> processStream = mapStream.process(new ProcessFunction<SensorReading, SensorReading>() {
      @Override
      public void processElement(SensorReading value, Context ctx, Collector<SensorReading> out) throws Exception {
        if (value.getTemperature() > 30) {
          ctx.output(highTag, value);
        } else {
          ctx.output(lowTag, value);
        }
        out.collect(value);
      }
    });
    DataStream<SensorReading> highStream = processStream.getSideOutput(highTag);
    DataStream<SensorReading> lowStream = processStream.getSideOutput(lowTag);
//    DataStream<SensorReading> allStream = processStream.getSideOutput(allTag);
    // 打印输出
    highStream.print("high");
    lowStream.print("low");
//    allStream.print("all");
    processStream.print("process");
    
    // 2. 合流 connect 将高温流转换成二元组类型，与低温流连接合并之后，输出状态信息
    SingleOutputStreamOperator<Tuple2<String, Double>> warnStream = highStream.map(new MapFunction<SensorReading, Tuple2<String, Double>>() {
      @Override
      public Tuple2<String, Double> map(SensorReading value) throws Exception {
        return new Tuple2<>(value.getId(), value.getTemperature());
      }
    });
  
    ConnectedStreams<Tuple2<String, Double>, SensorReading> connectedStreams = warnStream.connect(lowStream);
    SingleOutputStreamOperator<Object> resultStream = connectedStreams.map(new CoMapFunction<Tuple2<String, Double>, SensorReading, Object>() {
      @Override
      public Object map1(Tuple2<String, Double> value) throws Exception {
        return new Tuple3<String, Double, String>(value.f0, value.f1, "high temp warning");
      }
    
      @Override
      public Object map2(SensorReading value) throws Exception {
        return new Tuple2<String, String>(value.getId(), "normal");
      }
    });
  
    // 打印输出
    resultStream.print("result");
    // 执行
    env.execute("TransformMultiple");
  }
}