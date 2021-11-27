package offer.chapter5;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题32：有效的变位词
 *
 * 给定两个字符串s和t，请判断它们是不是一组变位词。
 * 在一组变位词中，它们中的字符及每个字符出现的次数都是相同，但字符的顺序不能相同。
 *
 * @author Mr.黄
 * @date 2021/11/27
 **/
public class InterviewQuestion32 {
  /**
   * 只考虑英文字母，用数组模拟哈希表
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(1)
   *
   * @param str1 字符串str1
   * @param str2 字符串str2
   * @return str1和str2互为变位词返回true，否则返回false
   */
  public boolean isAnagram(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    int[] counts = new int[26];
    for (char ch : str1.toCharArray()) {
      counts[ch - 'a']++;
    }
    for (char ch : str2.toCharArray()) {
      if (counts[ch - 'a'] == 0) {
        return false;
      }
      counts[ch - 'a']--;
    }
    return true;
  }
  
  /**
   * 如果考虑非英文字母，使用真正的HashMap来进行操作
   *
   * @param str1 字符串str1
   * @param str2 字符串str2
   * @return str1和str2互为变位词返回true，否则返回false
   */
  public boolean isAnagram2(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    Map<Character, Integer> counts = new HashMap<>();
    for (char ch : str1.toCharArray()) {
      counts.put(ch, counts.getOrDefault(ch, 0) + 1);
    }
    for (char ch : str2.toCharArray()) {
      if (counts.get(ch) == 0) {
        return false;
      }
      counts.put(ch, counts.get(ch) - 1);
    }
    return true;
  }
}