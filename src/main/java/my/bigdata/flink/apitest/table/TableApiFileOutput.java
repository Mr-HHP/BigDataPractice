package my.bigdata.flink.apitest.table;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.*;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.types.DataType;

import static org.apache.flink.table.api.Expressions.$;

/**
 * flink table api file output
 *
 * @author Mr.黄
 * @date 2022/03/12
 **/
public class TableApiFileOutput {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        
        String filePath = "file:///D:/BigDataProject/BigDataPractice/src/main/resources/sensor.txt";
        TableDescriptor tableDescriptor = TableDescriptor.forConnector("filesystem")
            .schema(Schema.newBuilder()
                .column("id", DataTypes.STRING())
                .column("timestamp", DataTypes.BIGINT())
                .column("temp", DataTypes.DOUBLE())
                .build())
            .option("path", filePath)
            .format(FormatDescriptor.forFormat("csv").build())
            .build();
        tableEnv.createTemporaryTable("inputTable", tableDescriptor);
        Table inputTable = tableEnv.from("inputTable");
        
        Table resultTable = inputTable
            .select($("id"), $("temp"))
            .filter($("id").isEqual("sensor_6"));
        
        // 聚合统计
        Table aggTable = inputTable.groupBy($("id"))
            .select($("id"), $("temp").avg().as("avgTemp"));
        
        // 3.2 SQL
        tableEnv.sqlQuery("select id, temp from inputTable where id = 'sensor_6'");
        Table sqlAggTable = tableEnv.sqlQuery("select id, count(id) as count_id, avg(temp) from inputTable group by id");
        
        // 4. 输出到文件
        // 连接外部文件注册输出表
        String outPath = "file:///D:/BigDataProject/BigDataPractice/src/main/resources/out.txt";
        TableDescriptor outTableDescriptor = TableDescriptor.forConnector("filesystem")
            .schema(Schema.newBuilder()
                .column("id", DataTypes.STRING())
                .column("temp", DataTypes.DOUBLE())
                .build())
            .option("path", outPath)
            .format(FormatDescriptor.forFormat("csv").build())
            .build();
        tableEnv.createTemporaryTable("outputTable", outTableDescriptor);
        
        resultTable.executeInsert("outputTable");
//        aggTable.executeInsert("outputTable");
        
//        env.execute("TableApiFileOutput");
    }
}