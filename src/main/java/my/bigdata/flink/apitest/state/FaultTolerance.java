package my.bigdata.flink.apitest.state;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.runtime.state.hashmap.HashMapStateBackend;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink 状态后端、checkpoint机制（容错）案例
 *
 * @author Mr.黄
 * @date 2022/03/06
 **/
public class FaultTolerance {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    
    // 1.状态后端配置
    env.setStateBackend(new HashMapStateBackend());
  
    DataStreamSource<String> source = env.socketTextStream("localhost", 7777);
  
    SingleOutputStreamOperator<SensorReading> dataStream = source.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.parseLong(fields[1]), new Double(fields[2]));
    });
    
    dataStream.print();
    env.execute("FaultTolerance");
  }
}