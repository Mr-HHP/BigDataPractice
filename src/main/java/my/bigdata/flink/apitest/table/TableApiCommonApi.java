package my.bigdata.flink.apitest.table;

import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

/**
 * flink table common api案例
 *
 * @author Mr.黄
 * @date 2022/03/10
 **/
public class TableApiCommonApi {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
    
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        
        // 1.1 基于老版本planner的流处理
        EnvironmentSettings oldStreamSettings = EnvironmentSettings.newInstance()
            .useOldPlanner()
            .inStreamingMode()
            .build();
        StreamTableEnvironment oldStreamTableEnv = StreamTableEnvironment.create(env, oldStreamSettings);
        
        // 1.2 基于老版本planner的批处理
        StreamTableEnvironment batchTableEnv = StreamTableEnvironment.create(env, EnvironmentSettings.inBatchMode());
        
        
    }
}