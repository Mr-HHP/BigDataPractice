package my.exercise.flink.apitest.source;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink案例：从文件获取数据源
 *
 * @author Mr.黄
 * @date 2022/02/12
 **/
public class SourceFromFile {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);
    // 从文件读取数据
    DataStream<String> dataStreamSource = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 打印输出
    dataStreamSource.print();
    
    // 执行
    env.execute("SourceFromFile");
  }
}