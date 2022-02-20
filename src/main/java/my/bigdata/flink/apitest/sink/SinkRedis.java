package my.bigdata.flink.apitest.sink;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.redis.RedisSink;
import org.apache.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;

/**
 * flink redis sink案例
 *
 * @author Mr.黄
 * @date 2022/02/20
 **/
public class SinkRedis {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    // 从文件读取数据
    DataStreamSource<String> inputStream = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 转换成SensorReading类型
    DataStream<SensorReading> sensorReadingStream = inputStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
    
    // 定义Jedis连接配置
    FlinkJedisPoolConfig jedisPoolConfig = new FlinkJedisPoolConfig.Builder()
      .setHost("localhost")
      .setPort(6379)
      .build();
  
    sensorReadingStream.addSink(new RedisSink<>(jedisPoolConfig, new MyRedisMapper()));
  
  
    // 执行
    env.execute("SinkRedis");
  }
  
  /**
   * 自定义RedisMapper
   */
  public static class MyRedisMapper implements RedisMapper<SensorReading> {
  
    /**
     * 定义保存数据到redis的命令，存储成哈希表，hset sensor_temp id temperature
     *
     * @return data type descriptor
     */
    @Override
    public RedisCommandDescription getCommandDescription() {
      return new RedisCommandDescription(RedisCommand.HSET, "sensor_temp");
    }
  
    /**
     * Extracts key from data.
     *
     * @param data source data
     * @return key
     */
    @Override
    public String getKeyFromData(SensorReading data) {
      return data.getId();
    }
  
    /**
     * Extracts value from data.
     *
     * @param data source data
     * @return value
     */
    @Override
    public String getValueFromData(SensorReading data) {
      return data.getTemperature().toString();
    }
  }
}