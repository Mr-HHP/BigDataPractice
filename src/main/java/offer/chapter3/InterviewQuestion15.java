package offer.chapter3;

import sun.applet.Main;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题15
 *
 * 输入字符串s1和s2，如何找出字符串s2的所有变位词在字符串s1中的起始下标？
 * 假设两个字符串中只包含英文小写字母
 *
 * @author Mr.黄
 * @date 2021/10/28
 **/
public class InterviewQuestion15 {
  public static void main(String[] args) {
    String s1 = "cbadabacg";
    String s2 = "abc";
    List<Integer> list = findAnagrams(s1, s2);
    for (int i : list) {
      System.out.println(i);
    }
  }
  
  /**
   * 解法与14题类似，使用双指针法
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(1)
   *
   * @param s1 字符串s1
   * @param s2 字符串s2
   * @return 返回结果
   */
  public static List<Integer> findAnagrams(String s1, String s2) {
    List<Integer> indices = new LinkedList<>();
    if (s1.length() < s2.length()) {
      return indices;
    }
    int[] counts = new int[26];
    for (int i = 0; i < s2.length(); i++) {
      counts[s2.charAt(i) - 'a']++;
      counts[s1.charAt(i) - 'a']--;
    }
    if (areAllZero(counts)) {
      indices.add(0);
    }
    for (int i = s2.length(); i < s1.length(); i++) {
      counts[s1.charAt(i) - 'a']--;
      counts[s1.charAt(i - s2.length()) - 'a']++;
      if (areAllZero(counts)) {
        indices.add(i - s2.length() + 1);
      }
    }
    return indices;
  }
  
  private static boolean areAllZero(int[] counts) {
    for (int count : counts) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
}