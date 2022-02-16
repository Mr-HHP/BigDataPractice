package my.bigdata.flink.apitest.source;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 自定义flink source
 *
 * @author Mr.黄
 * @date 2022/02/15
 **/
public class MySource {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从文件读取数据
    DataStreamSource<SensorReading> dataStreamSource = env.addSource(new MySensorSource());
    
    // 打印输出
    dataStreamSource.print();
    
    // 执行
    env.execute("MySource");
  }
  
  public static class MySensorSource implements SourceFunction<SensorReading> {
    // 定义标志位，控制数据的产生
    private boolean running = true;
    
    @Override
    public void run(SourceContext<SensorReading> ctx) throws Exception {
      // 定义一个随机数发生器
      Random random = new Random();
      // 设置10个传感器的初始温度值
      Map<String, Double> sensorTempMap = new HashMap<>(16);
      for (int i = 0; i < 10; i++) {
        sensorTempMap.put("sensor_" + (i + 1), 60 + random.nextGaussian() * 20);
      }
      while (running) {
        for (String sensorId : sensorTempMap.keySet()) {
          // 在当前温度基础上随机波动
          double newTemp = sensorTempMap.get(sensorId) + random.nextGaussian();
          sensorTempMap.put(sensorId, newTemp);
          ctx.collect(new SensorReading(sensorId, System.currentTimeMillis(), newTemp));
        }
        Thread.sleep(5000);
      }
    }
    
    @Override
    public void cancel() {
      running = false;
    }
  }
  
}