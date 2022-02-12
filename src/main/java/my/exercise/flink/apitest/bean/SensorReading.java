package my.exercise.flink.apitest.bean;

/**
 * 传感器温度读数的数据类型
 *
 * @author Mr.黄
 * @date 2022/02/12
 **/
public class SensorReading {
  /**
   * 传感器id
   */
  private String id;
  
  /**
   * 时间戳
   */
  private Long timestamp;
  
  /**
   * 温度值
   */
  private Double temperature;
  
  public SensorReading() {
  }
  
  public SensorReading(String id, Long timestamp, Double temperature) {
    this.id = id;
    this.timestamp = timestamp;
    this.temperature = temperature;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public Long getTimestamp() {
    return timestamp;
  }
  
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
  
  public Double getTemperature() {
    return temperature;
  }
  
  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }
  
  @Override
  public String toString() {
    return "SensorReading{" +
      "id='" + id + '\'' +
      ", timestamp=" + timestamp +
      ", temperature=" + temperature +
      '}';
  }
}