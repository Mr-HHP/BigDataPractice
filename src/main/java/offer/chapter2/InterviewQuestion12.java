package offer.chapter2;

/**
 * 面试题12
 *
 * 输入一个整数数组，
 * 如果一个数字左边的子数组的数字之和等于右边的子数组的数字之和，那么返回该数字的下标。
 * 如果存在多个这样的数字，则返回最左边一个数字之和。
 * 如果不存在这样的数字，则返回-1
 *
 * @author Mr.黄
 * @date 2021/10/24
 **/
public class InterviewQuestion12 {
  /**
   * 如果从数组的第i个数字开始扫描并逐一累加扫描到的数字，当扫描到第1个数字的时候，就可以知道累加到的第i个数字的和，
   * 这个和减去第i个数字就是累加到第i-1的数字和。
   * 同时，要知道数组中的所有数字之和，只需要从头到尾扫描一次数组就可以。
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(1)
   *
   * @param nums 整数数组
   * @return 符合要求的数字下标
   */
  public static int pivotIndex(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    int sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      if (total - sum == sum - nums[i]) {
        return i;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 2, 9}));
  }
}