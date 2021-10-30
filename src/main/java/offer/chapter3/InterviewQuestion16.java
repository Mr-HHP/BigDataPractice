package offer.chapter3;

/**
 * 面试题16：不含重复字符的最长子字符串
 * <p>
 * 输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。
 *
 * @author Mr.黄
 * @date 2021/10/30
 **/
public class InterviewQuestion16 {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("babcca"));
    System.out.println(lengthOfLongestSubstring2("babcca"));
  }
  
  /**
   * 使用双指针+哈希表的方法进行解题。
   * <p>
   * 哈希表中值不大于1表示没有重复字符，指针1向右移增加字符；
   * 否则指针2向左移删除字符。
   * <p>
   * 时间复杂度：O(n)
   * 不足：需要多次遍历整个哈希表的解法
   *
   * @param s 字符串
   * @return 不含重复字符的最长子字符串长度
   */
  public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    // 所有字符共有256个
    int[] counts = new int[256];
    // 指针1
    int i = 0;
    // 指针2
    int j = -1;
    int longest = 1;
    for (; i < s.length(); i++) {
      // 指针1向右移
      counts[s.charAt(i)]++;
      while (hasGreaterThan1(counts)) {
        j++;
        counts[s.charAt(j)]--;
      }
      longest = Math.max(i - j, longest);
    }
    return longest;
  }
  
  /**
   * 判断哈希表中是否出现重复字符
   *
   * @param counts 记录字符出现次数的哈希表
   * @return 有重复字符返回true，否则false
   */
  private static boolean hasGreaterThan1(int[] counts) {
    for (int count : counts) {
      if (count > 1) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * 增加一个变量countDup记录出现重复字符。
   * 字符重复countDup加1；删除重复字符countDup减1
   * <p>
   * 时间复杂度：O(n)
   * 优点：不需要多次遍历哈希表，时间效率有所提高
   *
   * @param s 字符串
   * @return 不含重复字符的最长子字符串长度
   */
  public static int lengthOfLongestSubstring2(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int[] counts = new int[256];
    // 指针1
    int i = 0;
    // 指针2
    int j = -1;
    int longest = 1;
    // 重复字符记录变量
    int countDup = 0;
    for (; i < s.length(); i++) {
      counts[s.charAt(i)]++;
      if (counts[s.charAt(i)] == 2) {
        countDup++;
      }
      while (countDup > 0) {
        j++;
        counts[s.charAt(j)]--;
        if (counts[s.charAt(j)] == 1) {
          countDup--;
        }
      }
      longest = Math.max(i - j, longest);
    }
    return longest;
  }
}