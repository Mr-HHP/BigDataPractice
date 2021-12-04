package offer.chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题42：最近请求次数
 * <p>
 * 请实现如下类型RecentCounter，它是统计过去3000ms内的请求次数的计数器。
 * 该类型的构造函数RecentCounter初始化计数器，请求数初始化为0；
 * 函数ping(int t)在时间t添加一个请求（t表示以毫秒为单位的时间），
 * 并返回过去3000ms内（时间范围为[t-3000, t]）发生的所有请求数。
 * 假设每次调用函数ping的参数t都比之前调用的参数值大。
 *
 * @author Mr.黄
 * @date 2021/12/02
 **/
public class InterviewQuestion42 {

}

/**
 * 解法：使用队列进行存储请求记录
 */
class RecentCounter {
  /**
   * 存储请求发生的记录队列
   */
  private Queue<Integer> times;
  /**
   * 滑动窗口
   */
  private int windowSize;
  
  /**
   * 构造函数初始化计数器
   */
  public RecentCounter() {
    times = new LinkedList<>();
    windowSize = 3000;
  }
  
  public int ping(int t) {
    // 新的请求插入队列
    times.offer(t);
    // 删除超过时间范围的请求
    while (times.peek() + windowSize < t) {
      times.poll();
    }
    // [t-3000, t]时间范围内的所有请求次数
    return times.size();
  }
}