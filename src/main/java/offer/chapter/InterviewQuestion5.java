package offer.chapter;

/**
 * 面试题5
 *
 * 输入一个字符串数组words，计算不包含相同字符的两个字符串words[i]和words[j]的长度乘积的最大值。
 * 如果所有字符串都包含至少一个相同字符，那么返回0。
 * 假设字符串中只包含英文小写字母
 *
 * @author Mr.黄
 * @date 2021/10/16
 **/
public class InterviewQuestion5 {
  public static void main(String[] args) {
  
  }
  
  /**
   * 解法1：用哈希表记录字符串中出现的字符
   *
   * 时间复杂度：O(nk+nn)
   * 空间复杂度：O(n)
   *
   * @param words 字符串数组
   * @return 乘积
   */
  public static int maxProduce(String[] words) {
    boolean[][] flags = new boolean[words.length][26];
    for (int i = 0; i < words.length; i++) {
      for (char c : words[i].toCharArray()) {
        flags[i][c - 'a'] = true;
      }
    }
    int result = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        int k = 0;
        for (;k < 26; k++) {
          if (flags[i][k] && flags[j][k]) {
            break;
          }
        }
        if (k == 26) {
          int prod = words[i].length() * words[j].length();
          return Math.max(result, prod);
        }
      }
    }
    return result;
  }
  
  /**
   * 解法2：用整数的二进制位记录字符串中出现的字符
   *
   * @param words
   * @return
   */
  public int maxProduce2(String[] words) {
    int[] flags = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      for (char ch : words[i].toCharArray()) {
        flags[i] |= 1 << (ch - 'a');
      }
    }
    int result = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i; j < words.length; j++) {
        if ((flags[i] & flags[j]) == 0) {
          int prod = words[i].length() * words[j].length();
          result = Math.max(result, prod);
        }
      }
    }
    return result;
  }
}