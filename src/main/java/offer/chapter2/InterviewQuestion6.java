package offer.chapter2;

import java.util.Arrays;

/**
 * 面试题6
 * <p>
 * 输入一个递增排序的数组和一个值k，请问如何在数组中找出两个和为k的数字并返回他们的下标？
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能适用两次。
 *
 * @author Mr.黄
 * @date 2021/10/20
 **/
public class InterviewQuestion6 {
  /**
   * 双指针法，从数组头和尾同时遍历；
   * 如果两者和小于目标值，则左侧指针往右移；
   * 如果两者和大于目标值，则右侧指针往左移
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(1)
   *
   * @param numbers 递增数组
   * @param target 目标值
   * @return 数组下标
   */
  public static int[] towSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length - 1;
    while (i < j && numbers[i] + numbers[j] != target) {
      if (numbers[i] + numbers[j] < target) {
        i++;
      } else {
        j--;
      }
    }
    return new int[]{i, j};
  }
  
  public static void main(String[] args) {
    System.out.println(Arrays.toString(towSum(new int[]{1, 2, 4, 6, 10}, 8)));
  }
}