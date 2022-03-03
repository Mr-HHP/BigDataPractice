package my.bigdata.flink.apitest.state;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.state.ListState;
import org.apache.flink.api.common.state.ListStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;
import org.apache.flink.streaming.api.checkpoint.ListCheckpointed;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink operator state案例
 *
 * @author Mr.黄
 * @date 2022/03/03
 **/
public class OperatorState {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 读取数据源
//    DataStreamSource<String> readTextFile = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    DataStreamSource<String> readTextFile = env.socketTextStream("localhost", 7777);
    
    SingleOutputStreamOperator<SensorReading> dataStream = readTextFile.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.parseLong(fields[1]), Double.parseDouble(fields[2]));
    });
    
    // 定义一个有状态的map操作，统计当前分区的数据个数
    SingleOutputStreamOperator<Integer> result = dataStream.map(new MyCountMapper());
    
    result.print();
  
    env.execute("OperatorState");
  }
  
  /**
   * 自定义MapFunctiong
   */
  public static class MyCountMapper implements MapFunction<SensorReading, Integer>, CheckpointedFunction {
    // 定义一个本地变量，作为算子状态
    private int count = 0;
    private ListState<Integer> countState;
  
    @Override
    public Integer map(SensorReading value) throws Exception {
      count++;
      for (Integer i : countState.get()) {
        System.out.println("map:\t" + i);
      }
      return count;
    }
  
    @Override
    public void snapshotState(FunctionSnapshotContext context) throws Exception {
      System.out.println("snapshotState:\t" + count);
      countState.add(count);
    }
  
    @Override
    public void initializeState(FunctionInitializationContext context) throws Exception {
      ListStateDescriptor<Integer> listStateDescriptor = new ListStateDescriptor<Integer>("count", TypeInformation.of(new TypeHint<Integer>() {}));
      countState = context.getOperatorStateStore().getListState(listStateDescriptor);
      for (int l : countState.get()) {
        count += l;
      }
      System.out.println("initializeState:\t" + count);
    }
  }
}