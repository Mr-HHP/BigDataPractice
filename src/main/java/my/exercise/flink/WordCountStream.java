package my.exercise.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink流式处理词频统计
 *
 * @author Mr.黄
 * @date 2022/02/07
 **/
public class WordCountStream {
  public static void main(String[] args) throws Exception {
    // 创建流处理执行环境
    StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.createLocalEnvironment();
    streamExecutionEnvironment.setParallelism(8);
    // 从文件中读取数据
    String inputPath = "D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\word.txt";
    DataStream<String> stringDataStreamSource = streamExecutionEnvironment.readTextFile(inputPath);
    
    // 基于数据流进行转化计算
    DataStream<Tuple2<String, Integer>> result = stringDataStreamSource
      .flatMap(new WordCountBatch.MyFlatMapper())
      .keyBy(0)
      .sum(1);
    
    result.print();
    
    // 执行任务
    streamExecutionEnvironment.execute();
  }
}