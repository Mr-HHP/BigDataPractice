package offer.chapter;

/**
 * 面试题9
 *
 * 输入一个由正整数组成的数组和一个正整数k，
 * 求数组中有多少个数字成绩小于k的连续子数组
 *
 *
 * @author Mr.黄
 * @date 2021/10/21
 **/
public class InterviewQuestion9 {
  /**
   * 使用双指针法，类似于面试题8
   *
   * 时间复杂度：O(n)
   *
   * @param nums 正整数数组
   * @param k 指定值
   * @return 复合条件连续子数组数量
   */
  public static int numSubarrayProductLessThank(int[] nums, int k) {
    long product = 1;
    int left = 0;
    int count = 0;
    for (int right = 0; right < nums.length; ++right) {
      product *= nums[right];
      while (left <= right && product >= k) {
        product /= nums[left++];
      }
      count += right >= left ? right - left + 1 : 0;
    }
    return count;
  }
  
  public static void main(String[] args) {
    System.out.println(numSubarrayProductLessThank(new int[]{10, 5, 2, 6}, 100));
  }
}