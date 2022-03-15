package my.bigdata.flink.apitest.table;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.Schema;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

import java.time.Duration;

/**
 * flink table api time and window案例
 *
 * @author Mr.黄
 * @date 2022/03/15
 **/
public class TableApiTimeAndWindow {
    public static void main(String[] args) throws Exception {
        // 1. 创建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        ExecutionConfig config = env.getConfig();
        config.setAutoWatermarkInterval(100);
        
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        
        // 2. 读入文件数据，得到DataStream
        DataStreamSource<String> inputStream = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
        // 3. 转换成pojo
        SingleOutputStreamOperator<SensorReading> dataStream = inputStream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), Double.parseDouble(fields[2]));
        })
            .assignTimestampsAndWatermarks(WatermarkStrategy
                .<SensorReading>forBoundedOutOfOrderness(Duration.ofMillis(200L))
                .withTimestampAssigner((SerializableTimestampAssigner<SensorReading>) (element, recordTimestamp) -> element.getTimestamp() * 1000));
        
        // 4. 将流转换成表，定义时间特性
        Table dataTable = tableEnv.fromDataStream(dataStream, Schema.newBuilder()
            .column("id", DataTypes.STRING())
            .column("timestamp", DataTypes.BIGINT())
            .column("temperature", DataTypes.DOUBLE())
            .columnByMetadata("rowtime", "TIMESTAMP_LTZ(3)")
            .watermark("rowtime", "SOURCE_WATERMARK()")
//            .column("pt.procetime", DataTypes.BIGINT())
            .build());
        
        tableEnv.toDataStream(dataTable, Row.class).print();
        
        env.execute("tableApiTimeAndWindow");
    }
}