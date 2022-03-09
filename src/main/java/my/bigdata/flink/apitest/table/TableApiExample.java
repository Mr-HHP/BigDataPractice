package my.bigdata.flink.apitest.table;

import my.bigdata.flink.apitest.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

import static org.apache.flink.table.api.Expressions.$;

/**
 * flink table api案例
 *
 * @author Mr.黄
 * @date 2022/03/09
 **/
public class TableApiExample {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStreamSource<String> source = env.readTextFile("D:\\BigDataProject\\BigDataPractice\\src\\main\\resources\\sensor.txt");
        
        SingleOutputStreamOperator<SensorReading> dataStream = source.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
        });
        
        // 创建表环境
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        // 基于流创建一张表
        Table dataTable = tableEnv.fromDataStream(dataStream);
        // 调用table api进行转换操作
        Table resultTable = dataTable
            .select($("id"), $("temperature"))
            .where($("id").isEqual("sensor_1"));
        
        // 执行SQL
        tableEnv.createTemporaryView("sensor", resultTable);
        String sql = "select id, temperature from sensor where id = 'sensor_1'";
        Table resultSqlTable = tableEnv.sqlQuery(sql);
        
//        dataStream.print("dataStream");
        tableEnv.toDataStream(resultTable, Row.class).print("resultTable");
        tableEnv.toDataStream(resultSqlTable, Row.class).print("resultSqlTable");
        env.execute("TableApiExample");
    
    }
}