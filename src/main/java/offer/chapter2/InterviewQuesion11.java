package offer.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题11
 *
 * 输入一个只包含0和1的数组，请问如何求0和1的个数相同的最长连续子数组的长度？
 *
 * @author Mr.黄
 * @date 2021/10/24
 **/
public class InterviewQuesion11 {
  /**
   * 扫描数组时累加已经扫描过的数字之和。
   * 如果数组中前i个数字之和为m，前j个数字（j > i）之和也为m，那么从第i+1个数字到第j个数字的子数组的数字之和为0，
   * 这个和为0的子数组的长度是j-i
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(n)
   *
   * @param nums 只包含0和1的数组
   * @return 符合条件的最长连续子数组的长度
   */
  public static int findMaxLength(int[] nums) {
    // 哈希表的键是从第一个数字开始累加到当前扫描到的数字之和；
    // 值时当前扫描的数字的下标
    Map<Integer, Integer> sumToIndex = new HashMap<>();
    sumToIndex.put(0, -1);
    int sum = 0;
    int maxLength = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i] == 0 ? -1 : 1;
      if (sumToIndex.containsKey(sum)) {
        maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
      } else {
        sumToIndex.put(sum, i);
      }
    }
    return maxLength;
  }
  
  public static void main(String[] args) {
    System.out.println(findMaxLength(new int[]{0, 1, 0}));
  }
}