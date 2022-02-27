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
public class BoundedOutOfOrDernessGenerator implements WatermarkGenerator<String> {
  
  /**
   * 3.5秒，watermark的滞后时间
   */
  private final  long maxOutOfOrderness = 3500;
  
  /**
   * 当前最大时间戳
   */
  private long currentMaxTimestamp;
  
  @Override
  public void onEvent(String event, long eventTimestamp, WatermarkOutput output) {
    currentMaxTimestamp = Math.max(currentMaxTimestamp, eventTimestamp);
  }
  
  @Override
  public void onPeriodicEmit(WatermarkOutput output) {
    // 发出的 watermark = 当前最大时间戳 - 最大乱序时间
    output.emitWatermark(new Watermark(currentMaxTimestamp - maxOutOfOrderness - 1));
  }
}