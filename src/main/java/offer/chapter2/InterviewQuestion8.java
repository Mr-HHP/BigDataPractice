package offer.chapter2;

/**
 * 面试题8
 * <p>
 * 输入一个正整数组成的数组和一个正整数k，
 * 求数组中和大于或等于k的连续子数组的最短长度。
 * 如果不存在所有数字之和大于或等于k的子数组，则返回0
 *
 * @author Mr.黄
 * @date 2021/10/21
 **/
public class InterviewQuestion8 {
  /**
   * 使用双指针法。
   * P1，P2初始化同时指向数组下标为0的位置，P1P2往同一个方向移动。
   *
   * 时间复杂度：O(n)
   *
   * @param k    指定值
   * @param nums 正整数数组
   * @return 子数组最短长度
   */
  public static int minSubArrayLen(int k, int[] nums) {
    int left = 0;
    int sum = 0;
    int minLength = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];
      while (left <= right && sum >= k) {
        minLength = Math.min(minLength, right - left + 1);
        sum -= nums[left++];
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
  
  public static void main(String[] args) {
    System.out.println(minSubArrayLen(7, new int[]{5, 1, 4, 3}));
  }
}