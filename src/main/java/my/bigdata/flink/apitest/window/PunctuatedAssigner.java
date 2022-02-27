package my.bigdata.flink.apitest.window;

import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkOutput;

/**
 * 自定义标记watermark生成器
 *
 * @author Mr.黄
 * @date 2022/02/27
 **/
public class PunctuatedAssigner implements WatermarkGenerator<MyEvent> {
  
  @Override
  public void onEvent(MyEvent event, long eventTimestamp, WatermarkOutput output) {
    if (event.hasWaterMarker()) {
      output.emitWatermark(new Watermark(event.getWatermarkTimestamp()));
    }
  }
  
  @Override
  public void onPeriodicEmit(WatermarkOutput output) {
    // 标记watermark生成器不需要实现此方法
  }
}

class MyEvent {
  public boolean hasWaterMarker() {
    return true;
  }
  
  public long getWatermarkTimestamp() {
    return 0L;
  }
}