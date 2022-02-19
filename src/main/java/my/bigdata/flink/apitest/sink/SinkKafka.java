package my.bigdata.flink.apitest.sink;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink的sink案例
 *
 * @author Mr.黄
 * @date 2022/02/19
 **/
public class SinkKafka {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    
    // 从文件读取数据
//    DataStreamSource<String> inputStream = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 从kafka读取
    KafkaSource<String> kafkaSource = KafkaSource.<String>builder()
      .setBootstrapServers("localhost:9092")
      .setTopics("sensor")
      .setGroupId("source-from-kafka")
      .setStartingOffsets(OffsetsInitializer.earliest())
      .setValueOnlyDeserializer(new SimpleStringSchema())
      .build();
    DataStreamSource<String> inputStream = env.fromSource(kafkaSource, WatermarkStrategy.noWatermarks(), "kafka_source");
  
    // 转换成SensorReading类型
    SingleOutputStreamOperator<String> dataStream = inputStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2])).toString();
    });
  
    KafkaSink<String> kafkaSink = KafkaSink.<String>builder()
      .setBootstrapServers("localhost:9092")
      .setRecordSerializer(KafkaRecordSerializationSchema.<String>builder()
        .setTopic("sink_test")
        .setValueSerializationSchema(new SimpleStringSchema())
        .build()
      )
      .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
      .build();
  
    dataStream.sinkTo(kafkaSink);
    
    // 执行
    env.execute("SinkKafka");
  }
}