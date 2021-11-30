package offer.chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题41：滑动窗口的平均值
 * <p>
 * 请实现如下类型MovingAverage，计算滑动窗口中所有数字的平均值，
 * 该类型构造函数的参数确定滑动窗口的大小，每次调用成员方法函数next时都会在滑动窗口中添加一个整数，
 * 并返回滑动窗口中所有数字的平均值。
 *
 * @author Mr.黄
 * @date 2021/12/01
 **/
public class InterviewQuestion41 {
  public static void main(String[] args) {
  
  }
}

/**
 * 满足要求的类型
 * <p>
 * 解题思路：使用队列模拟滑动窗口
 */
class MovingAverage {
  /**
   * 队列模拟滑动窗口
   */
  private Queue<Integer> nums;
  /**
   * 滑动窗口大小（队列容量）
   */
  private int capacity;
  /**
   * 滑动窗口数字总和（队列中所有数字总和）
   */
  private int sum;
  
  public MovingAverage(int size) {
    nums = new LinkedList<>();
    capacity = size;
  }
  
  public double next(int val) {
    nums.offer(val);
    sum += val;
    if (nums.size() > capacity) {
      sum -= nums.poll();
    }
    
    return (double) sum / nums.size();
  }
}