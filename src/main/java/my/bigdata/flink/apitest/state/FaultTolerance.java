package my.bigdata.flink.apitest.state;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.runtime.state.hashmap.HashMapStateBackend;
import org.apache.flink.streaming.api.CheckpointingMode;
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
    
    // 2.检查点配置
    // 每1000ms开始一次checkpoint
    env.enableCheckpointing(1000L);
    env.enableCheckpointing(1000, CheckpointingMode.EXACTLY_ONCE);
    env.enableCheckpointing();
    
    // 高级选项
    env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
    env.getCheckpointConfig().setCheckpointTimeout(1000L);
    env.getCheckpointConfig().setMaxConcurrentCheckpoints(2);
    env.getCheckpointConfig().setMinPauseBetweenCheckpoints(100);
    env.getCheckpointConfig().setTolerableCheckpointFailureNumber(3);
    
    // 重启策略
    // 固定延时重启
    env.setRestartStrategy(RestartStrategies.fixedDelayRestart(3, 10000L));
    // 失败率重启
    env.setRestartStrategy(RestartStrategies.failureRateRestart(3, Time.minutes(10), Time.minutes(1)));
    
  
    DataStreamSource<String> source = env.socketTextStream("localhost", 7777);
  
    SingleOutputStreamOperator<SensorReading> dataStream = source.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.parseLong(fields[1]), new Double(fields[2]));
    });
    
    dataStream.print();
    env.execute("FaultTolerance");
  }
}