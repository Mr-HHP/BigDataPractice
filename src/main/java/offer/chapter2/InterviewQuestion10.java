package offer.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题10：和为k的子数组
 *
 * 输入一个整数数组和一个整数k，求数组中有多少个数字之和等于k的连续子数组。
 *
 * @author Mr.黄
 * @date 2021/10/22
 **/
public class InterviewQuestion10 {
  /**
   * 数组前i个数字之和记为x。
   * 如果存在一个j（j < i），数组的前j个数字之和为x-k，
   * 那么数组中从第j+1个数字开始到第i个数字结束的子数组之和为k
   *
   * @param nums 整数数组
   * @param k 指定值
   * @return 子数组个数
   */
  public static int subArraySum(int[] nums, int k) {
    Map<Integer, Integer> sumToCount = new HashMap<>();
    sumToCount.put(0, 1);
    int sum = 0;
    int count = 0;
    for (int num : nums) {
      sum += num;
      count += sumToCount.getOrDefault(sum - k, 0);
      sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
    }
    
    return count;
  }
  
  public static void main(String[] args) {
    System.out.println(subArraySum(new int[]{1, 1, 1}, 2));
  }
}