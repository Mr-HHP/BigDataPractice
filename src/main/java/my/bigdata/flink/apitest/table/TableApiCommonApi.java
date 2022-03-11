package my.bigdata.flink.apitest.table;

import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.connector.datagen.table.DataGenConnectorOptions;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.*;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

import static org.apache.flink.table.api.Expressions.$;

/**
 * flink table common api案例
 *
 * @author Mr.黄
 * @date 2022/03/10
 **/
public class TableApiCommonApi {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        
        // 1.1 基于老版本planner的流处理
        EnvironmentSettings oldStreamSettings = EnvironmentSettings.newInstance()
            .inStreamingMode()
            .build();
        StreamTableEnvironment oldStreamTableEnv = StreamTableEnvironment.create(env, oldStreamSettings);
        
        // 1.2 基于老版本planner的批处理
        StreamTableEnvironment batchTableEnv = StreamTableEnvironment.create(env, EnvironmentSettings.inBatchMode());
        
        // 1.4 基于Blink的批处理
        StreamTableEnvironment blinkBatchTableEnv = StreamTableEnvironment.create(env, EnvironmentSettings.newInstance().useBlinkPlanner().inBatchMode().build());
        
        // 2. 表的创建：连接外部系统，读取数据
        // 2.1 读取文件
        String filePath = "file:///D:/BigDataProject/BigDataPractice/src/main/resources/sensor.txt";
        TableDescriptor tableDescriptor = TableDescriptor.forConnector("filesystem")
            .format(FormatDescriptor.forFormat("csv").build())
            .schema(Schema.newBuilder()
                .column("id", DataTypes.STRING())
                .column("timestamp", DataTypes.BIGINT())
                .column("temp", DataTypes.DOUBLE())
                .build()
            )
            .option("path", filePath)
//            .option(DataGenConnectorOptions.ROWS_PER_SECOND, 100L)
            .build();
        tableEnv.createTemporaryTable("inputTable", tableDescriptor);
    
        Table inputTable = tableEnv.from("inputTable");
//        tableEnv.toDataStream(inputTable, Row.class).print();
//        inputTable.printSchema();
        
        // 3. 查询转换
        // 3.1 Table API
        // 简单转换
        Table resultTable = inputTable.select($("id"), $("temp"))
            .filter($("id").isEqual("sensor_6"));
        
        // 聚合统计
        Table aggTable = inputTable.groupBy($("id"))
            .select($("id"), $("id").count(), $("temp").avg().as("avgTemp"));
        
        // 3.2 SQL
        tableEnv.sqlQuery("select id, temp from inputTable where id = 'sensor_6'");
        Table sqlAggTable = tableEnv.sqlQuery("select id, count(id) as count_id, avg(temp) from inputTable group by id");
        
        // 打印输出
        tableEnv.toDataStream(resultTable, Row.class).print("result");
        tableEnv.toChangelogStream(aggTable).print("agg");
        tableEnv.toChangelogStream(sqlAggTable).print("sqlAgg");
    
    
        env.execute("TableApiCommonApi");
    }
}