package my.bigdata.flink.apitest.sink;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkBase;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch6.ElasticsearchSink;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestClientBuilder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * flink es sink案例
 *
 * @author Mr.黄
 * @date 2022/02/20
 **/
public class SinkEs {
  public static void main(String[] args) throws Exception {
    // 创建执行环境
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    
    // 从文件读取数据
    DataStream<String> inputStream = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
    
    // 转换成SensorReading类型
    SingleOutputStreamOperator<SensorReading> mapStream = inputStream.map(line -> {
      String[] fields = line.split(",");
      return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
    });
    
    // 定义es的连接配置
    ArrayList<HttpHost> httpHost = new ArrayList<>();
    httpHost.add(new HttpHost("localhost", 9200));
    
    ElasticsearchSink.Builder<SensorReading> esSinkBuilder = new ElasticsearchSink.Builder<>(httpHost, new MyEsSinkFunction());
    esSinkBuilder.setBulkFlushMaxActions(1);
    esSinkBuilder.setRestClientFactory(restClientBuilder -> {
      Header[] headers = {new BasicHeader("name", "value")};
      restClientBuilder.setDefaultHeaders(headers);
      restClientBuilder.setMaxRetryTimeoutMillis(1000);
      RestClientBuilder.HttpClientConfigCallback httpClientConfigCallback = httpClientBuilder -> null;
      restClientBuilder.setHttpClientConfigCallback(httpClientConfigCallback);
    });
    
    mapStream.addSink(esSinkBuilder.build());
    
    // 执行
    env.execute("SinkEs");
  }
  
  /**
   * 实现自定义的es写入操作
   */
  public static class MyEsSinkFunction implements ElasticsearchSinkFunction<SensorReading> {
    @Override
    public void process(SensorReading element, RuntimeContext ctx, RequestIndexer indexer) {
      // 定义写入的数据source
      HashMap<String, String> dataSource = new HashMap<>(16);
      dataSource.put("id", element.getId());
      dataSource.put("temp", element.getTemperature().toString());
      dataSource.put("ts", element.getTimestamp().toString());
      // 创建请求，作为向es发起的写入命令
      IndexRequest indexRequest = Requests.indexRequest()
        .index("sensor")
        .type("readingData")
        .source(dataSource);
      // 用index发送请求
      indexer.add(indexRequest);
    }
  }
}