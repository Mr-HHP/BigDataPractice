package my.bigdata.flink.apitest.sink;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.connector.jdbc.JdbcSink;
import org.apache.flink.connector.jdbc.JdbcStatementBuilder;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * flink JDBC sink案例
 *
 * @author Mr.黄
 * @date 2022/02/21
 **/
public class SinkJdbc {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    // 从文件读取数据
    DataStreamSource<String> dataStreamSource = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    SingleOutputStreamOperator<SensorReading> mapStream = dataStreamSource.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.parseLong(fields[1]), Double.valueOf(fields[2]));
    });
    
    // 使用JDBC sink
    String insert = "insert into sensor_temp(id, temp) values(?, ?)";
    String update = "update sensor_temp set temp = ? where id = ?";
    SinkFunction<SensorReading> jdbcSink = JdbcSink.sink(insert, (JdbcStatementBuilder<SensorReading>) (preparedStatement, sensorReading) -> {
      preparedStatement.setString(1, sensorReading.getId());
      preparedStatement.setDouble(2, sensorReading.getTemperature());
    }, JdbcExecutionOptions
      .builder()
      .withBatchSize(1000)
      .withBatchIntervalMs(200)
      .withMaxRetries(5).build(), new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
      .withUrl("jdbc:mysql://localhost:3306/test")
      .withDriverName("")
      .withUsername("root")
      .withPassword("root")
    .build());
    mapStream.addSink(jdbcSink);
    
    // 执行
    env.execute("SinkJdbc");
  }
  
}