package my.exercise.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * flink批处理词频统计
 *
 * @author Mr.黄
 * @date 2022/02/06
 **/
public class WordCountBatch {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();
    // 从文件中读取数据
    String inputPath = "D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\word.txt";
    DataSet<String> stringDataSet = executionEnvironment.readTextFile(inputPath);
    
    // 对数据集进行处理，按空格分词展开，转成(word, 1)二元组进行统计
    DataSet<Tuple2<String, Integer>> resultSet = stringDataSet
      .flatMap(new MyFlatMapper())
      // 按照第一个位置的word分组
      .groupBy(0)
      // 将第二个位置上的数据求和
      .sum(1);
    resultSet.print();
  }
  
  /**
   * 自定义静态内部类，实现FlatMapFunction
   */
  public static class MyFlatMapper implements FlatMapFunction<String, Tuple2<String, Integer>> {
    
    /**
     * The core method of the FlatMapFunction. Takes an element from the input data set and
     * transforms it into zero, one, or more elements.
     *
     * @param value The input value.
     * @param out   The collector for returning result values.
     * @throws Exception This method may throw exceptions. Throwing an exception will cause the
     *                   operation to fail and may trigger recovery.
     */
    @Override
    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
      // 按空格分词
      String[] words = value.split(" ");
      for (String word : words) {
        out.collect(new Tuple2<>(word, 1));
      }
    }
  }
}