package my.bigdata.flink.apitest.state;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.state.StateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink keyed state案例
 *
 * @author Mr.黄
 * @date 2022/03/04
 **/
public class KeyedState {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    
    DataStreamSource<String> socketTextStream = env.socketTextStream("localhost", 7777);
    SingleOutputStreamOperator<SensorReading> dataStream = socketTextStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.parseLong(fields[1]), Double.valueOf(fields[2]));
    });
    
    // 定义一个有状态的map操作，统计当前sensor数据个数
    SingleOutputStreamOperator<Integer> resultStream = dataStream
      .keyBy((KeySelector<SensorReading, String>) SensorReading::getId)
      .map(new MyKeyCountMapper());
    
    resultStream.print();
    env.execute("KeyedState");
  }
  
  /**
   * 自定义RichMapFunction
   */
  public static class MyKeyCountMapper extends RichMapFunction<SensorReading, Integer> {
    private ValueState<Integer> keyCountState;
    
    @Override
    public Integer map(SensorReading value) throws Exception {
      Integer stateValue = keyCountState.value();
      if (stateValue != null) {
        Integer count = stateValue;
        count++;
        keyCountState.update(count);
        return count;
      } else {
        keyCountState.update(1);
        return 1;
      }
    }
    
    @Override
    public void open(Configuration parameters) throws Exception {
      ValueStateDescriptor<Integer> valueStateDescriptor = new ValueStateDescriptor<Integer>("keyCount", TypeInformation.of(new TypeHint<Integer>() {
      }));
      // 在open方法中初始化状态
      keyCountState = getRuntimeContext().getState(valueStateDescriptor);
    }
  }
}