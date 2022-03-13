package my.bigdata.flink.apitest.table;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.*;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.types.DataType;

import static org.apache.flink.table.api.Expressions.$;

/**
 * flink table api kafka案例
 *
 * @author Mr.黄
 * @date 2022/03/13
 **/
public class TableApiKafkaPipeLine {
    public static void main(String[] args) throws Exception {
        // 1. 创建环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        
        // 2. 连接kafka，读取数据
        TableDescriptor tableDescriptor = TableDescriptor
            .forConnector("kafka")
            .schema(Schema
                .newBuilder()
                .column("id", DataTypes.STRING())
                .column("timestamp", DataTypes.BIGINT())
                .column("temp", DataTypes.DOUBLE())
                .build())
            .format(FormatDescriptor.forFormat("csv").build())
            .option("properties.bootstrap.servers", "localhost:9092")
            .option("topic", "sensor")
            .option("properties.group.id", "sensor_consumer")
//            .option("scan.startup.mode", "latest-offset")
            .option("scan.startup.mode", "earliest-offset")
            .build();
        tableEnv.createTemporaryTable("inputTable", tableDescriptor);
        
        // 3. 查询转换
        // 简单转换
        Table sensorTable = tableEnv.from("inputTable");
        Table resultTable = sensorTable.select($("id"), $("temp"))
            .filter($("id").isEqual("sensor_6"));
        
        // 聚合统计
        Table aggTable = sensorTable.groupBy($("id"))
            .select($("id"), $("id").count().as("count_id"), $("temp").avg().as("avgTemp"));
        
        
        // 4. 建立kafka接连，输出到不同的topic下
        TableDescriptor outTableDescriptor = TableDescriptor
            .forConnector("kafka")
            .schema(Schema
                .newBuilder()
                .column("id", DataTypes.STRING())
                .column("temp", DataTypes.DOUBLE())
                .build())
            .format(FormatDescriptor.forFormat("csv").build())
            .option("properties.bootstrap.servers", "localhost:9092")
            .option("topic", "sinkTest")
            .build();
        tableEnv.createTemporaryTable("outputTable", outTableDescriptor);
        resultTable.executeInsert("outputTable");
        
//        env.execute();
    }
}