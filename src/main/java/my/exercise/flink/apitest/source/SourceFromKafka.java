package my.exercise.flink.apitest.source;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.metrics.MetricGroup;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.operators.StreamingRuntimeContext;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumerBase;
import org.apache.flink.streaming.connectors.kafka.config.OffsetCommitMode;
import org.apache.flink.streaming.connectors.kafka.internals.AbstractFetcher;
import org.apache.flink.streaming.connectors.kafka.internals.AbstractPartitionDiscoverer;
import org.apache.flink.streaming.connectors.kafka.internals.KafkaTopicPartition;
import org.apache.flink.streaming.connectors.kafka.internals.KafkaTopicsDescriptor;
import org.apache.flink.util.SerializedValue;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * flink从Kafka获取数据源案例
 *
 * @author Mr.黄
 * @date 2022/02/12
 **/
public class SourceFromKafka {
  public static void main(String[] args) throws Exception {
    // 创建环境上下文
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    Set<TopicPartition> partitionSet = new HashSet<>();
    partitionSet.add(new TopicPartition("sensor", 0));
    // 创建Kafka数据源
    KafkaSource<String> kafkaSource = KafkaSource.<String>builder()
      .setBootstrapServers("localhost:9092")
      .setTopics("sensor")
//      .setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
      .setGroupId("source-from-kafka")
//      .setPartitions(partitionSet)
      .setStartingOffsets(OffsetsInitializer.earliest())
      .setValueOnlyDeserializer(new SimpleStringSchema())
      .build();
    DataStream<String> dataStreamSource = env.fromSource(kafkaSource, WatermarkStrategy.noWatermarks(), "kafka source");
    // 打印输出
    dataStreamSource.print();
    // 执行程序
    env.execute("SourceFromKafka");
  }
}