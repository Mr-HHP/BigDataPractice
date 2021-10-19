package offer.chapter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题7
 *
 * 输入一个无序数组，如何找出数组中所有和为0的3个数字的三元组？
 * 需要注意的是，返回值中不得包含重复的三元组。
 *
 * @author Mr.黄
 * @date 2021/10/20
 **/
public class InterviewQuestion7 {
  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
  
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if (nums.length >= 3) {
      // 对无序数组排序，时间复杂度O(nlogn)
      Arrays.sort(nums);
      int i = 0;
      while (i < nums.length - 2) {
        towSum(nums, i, result);
        int temp = nums[i];
        while (i < nums.length && temp == nums[i]) {
          ++i;
        }
      }
    }
    return result;
  }
  
  private static void towSum(int[] nums, int i, List<List<Integer>> result) {
    int j = i;
    int k = nums.length - 1;
    while (j < k) {
      if (nums[i] + nums[j] + nums[k] == 0) {
        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        int temp = nums[j];
        while (nums[j] == temp && j < k) {
          ++j;
        }
      } else if (nums[i] + nums[j] + nums[k] < 0) {
        ++j;
      } else {
        --k;
      }
    }
  }
}