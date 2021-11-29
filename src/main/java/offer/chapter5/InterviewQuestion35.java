package offer.chapter5;

import java.util.List;

/**
 * 面试题35：最小时间差
 *
 * 给定一组范围在00:00至23:59的时间，求任意两个时间之间的最小时差。
 *
 * @author Mr.黄
 * @date 2021/11/30
 **/
public class InterviewQuestion35 {
  public static void main(String[] args) {
  
  }
  
  /**
   * 利用哈希表解题，
   *
   * 使用数组模拟一个键为时间，值为true或者false的哈希表。
   * 一天24小时，1440分钟，所以数组长度为1440。
   * 从头到位扫描一遍数组，相邻的两个为true的值表示对应的两个时间在输入时间数组中是相邻的。
   * 由于数组的下标对应的是时间，因此两个时间之间的时间差就是它们在数组中对应的下标之差
   *
   * 代码用了两个for循环，主函数的时间复杂度是O(n)，辅助函数的时间复杂度是O(1440) == O(1)
   * 所以，时间复杂度：O(n)
   * 代码使用了长度为1440的辅助数组，是一个常数。
   * 所以，空间复杂度：O(1)
   *
   * @param timePoints 给定的时间数组
   * @return 返回任意两个时间之间的最小时间差
   */
  public int findMinDifference(List<String> timePoints) {
    // 数组长度大于1440，说明至少存在一对相同的时间，则最小时间差为0。
    if (timePoints.size() > 1440) {
      return 0;
    }
    boolean[] minuteFlags = new boolean[1440];
    for (String time : timePoints) {
      String[] t = time.split(":");
      // 将00:00格式的时间转换成分钟
      int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
      if (minuteFlags[min]) {
        // 存在相同的时间，所以最小时间差为0。
        return 0;
      }
      minuteFlags[min] = true;
    }
    return helper(minuteFlags);
  }
  
  /**
   * 计算时间差核心方法
   *
   * @param minuteFlages 初始化好了的时间数组
   * @return 返回任意两个时间的最小时间差
   */
  private int helper(boolean[] minuteFlages) {
    // 初始化最小时间差。
    int minDiff = minuteFlages.length - 1;
    // 前一个时间
    int prev = -1;
    // 初始化第一个时间
    int first = minuteFlages.length - 1;
    // 初始化最后一个时间
    int last = -1;
    for (int i = 0; i < minuteFlages.length; i++) {
      // 存在该时间
      if (minuteFlages[i]) {
        // 存在前一个时间
        if (prev >= 0) {
          // 计算前一个时间和当前时间的时间差
          minDiff = Math.min(i - prev, minDiff);
        }
        prev = i;
        // 寻找第一个时间和最后一个时间
        first = Math.min(i, first);
        last = Math.max(i, last);
      }
    }
    // 将第一个时间加上24h，再与最后一个时间计算时间差（计算跨天的时间差）
    minDiff = Math.min(first + minuteFlages.length - last, minDiff);
    return minDiff;
  }
}