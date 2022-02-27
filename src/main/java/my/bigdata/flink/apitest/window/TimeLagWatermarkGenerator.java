package my.bigdata.flink.apitest.window;

import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkOutput;

/**
 * 自定义周期性watermark生成器
 *
 * @author Mr.黄
 * @date 2022/02/27
 **/
public class TimeLagWatermarkGenerator implements WatermarkGenerator<String> {
  
  /**
   * 5秒，watermark的滞后时间
   */
  private final long maxTimeLag = 5000;
  @Override
  public void onEvent(String event, long eventTimestamp, WatermarkOutput output) {
    // 处理时间场景下不需要实现
  }
  
  @Override
  public void onPeriodicEmit(WatermarkOutput output) {
    output.emitWatermark(new Watermark(System.currentTimeMillis() - maxTimeLag));
  }
}