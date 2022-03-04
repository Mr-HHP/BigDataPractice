package my.bigdata.flink.apitest.state;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.state.*;
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
    
    // 其他类型状态的声明
    private ListState<String> myListState;
    private MapState<String, Double> myMapState;
    private ReducingState<SensorReading> myReduceState;
    
    @Override
    public Integer map(SensorReading value) throws Exception {
      Integer stateValue = keyCountState.value();
      if (stateValue != null) {
        Integer count = stateValue;
        count++;
        keyCountState.update(count);
        // 其他状态aip调用
        Iterable<String> strings = myListState.get();
        myListState.add("hello");
        
        // map state
        myMapState.get("1");
        myMapState.put("2", 23.0);
        // reducing state
        myReduceState.add(null);
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
      
      myListState = getRuntimeContext().getListState(new ListStateDescriptor<String>("myListState", String.class));
      myMapState = getRuntimeContext().getMapState(new MapStateDescriptor<String, Double>("myMapState", String.class, Double.class));
      
      myReduceState = getRuntimeContext().getReducingState(new ReducingStateDescriptor<SensorReading>("myReudceState", null, SensorReading.class));
    }
  }
}