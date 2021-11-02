package offer.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题17：包含所有字符的最短字符串
 *
 * 输入两个字符串s和t，请找出字符串s中包含字符串t的所有字符的最短字符串。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author Mr.黄
 * @date 2021/11/01
 **/
public class InterviewQuestion17 {
  public static void main(String[] args) {
    System.out.println(minWindow( "ADDBANCAD", "ABC"));
  }
  
  /**
   * @param s 字符串s
   * @param t 字符串t
   * @return 符合条件的最短字符串
   */
  public static String minWindow(String s, String t) {
    Map<Character, Integer> charToCount = new HashMap<>();
    // 初始化哈希表，将t字符串的所有字符记录进去
    for (char ch : t.toCharArray()) {
      charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
    }
    // 出现在字符串t中但还没有出现在字符串s中的子字符串中的字符的个数。
    int count = charToCount.size();
    // 相当于指针1
    int start = 0;
    // 相当于指针2
    int end = 0;
    int minStart = 0;
    int minEnd = 0;
    int minLength = Integer.MAX_VALUE;
    // 指针2还没有到尽头；或者两个指针之间已经包含了t字符串中的所有字符，并且指针2已经到尽头
    while (end < s.length() || (count == 0 && end == s.length())) {
      // 两个指针之间还未包含t字符串的所有字符
      if (count > 0) {
        char endCh = s.charAt(end);
        // endCh存在于t字符串中
        if (charToCount.containsKey(endCh)) {
          // 子字符串中已经包含所有的endCh字符串
          charToCount.put(endCh, charToCount.get(endCh) - 1);
          if (charToCount.get(endCh) == 0) {
            count--;
          }
        }
        // 右移指针2添加字符
        end++;
      } else {
        if (end - start < minLength) {
          minLength = end - start;
          minStart = start;
          minEnd = end;
        }
        // 右移指针1，减短两个指针之间的长度
        char startCh = s.charAt(start);
        // startCh存在于t字符串中，右移指针1删除字符后需要右移指针2继续添加字符
        if (charToCount.containsKey(startCh)) {
          charToCount.put(startCh, charToCount.get(startCh) + 1);
          if (charToCount.get(startCh) == 1) {
            // 表示两个指针之间还没有包含t字符串的所有字符
            count++;
          }
        }
        // 右移指针1删除字符
        start++;
      }
    }
    return minLength < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : "";
  }
}