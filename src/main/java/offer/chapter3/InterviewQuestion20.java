package offer.chapter3;

/**
 * 面试题20：回文子字符串的个数
 *
 * 给定一个字符串，请问该字符串中有多少个回文连续子字符串？
 *
 * @author Mr.黄
 * @date 2021/11/05
 **/
public class InterviewQuestion20 {
  public static void main(String[] args) {
    System.out.println(countSubstrings("abc"));
    System.out.println(countSubstrings("aaa"));
    System.out.println(countSubstrings("abcba"));
  }
  
  /**
   * 计算回文子字符串个数
   *
   * 利用双指针，从子字符串的中心开始向两端延申。
   * 如果延申的两个字符相同，则找到了一个回文子字符串。
   * 因为回文的长度既可以是奇数，也可以是偶数。
   * 所以长度为奇数的回文的对称中心只有一个字符，而长度为偶数的回文的对称中心有两个字符
   *
   * 时间复杂度：O(n2)
   * 空间复杂度：O(1)
   *
   * @param s 给定的字符串
   * @return 返回回文子字符串的个数
   */
  public static int countSubstrings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      // 处理长度为奇数的回文子字符串
      count += countPalindrome(s, i, i);
      // 处理长度为偶数的回文子字符串
      count += countPalindrome(s, i, i + 1);
    }
    return count;
  }
  
  private static int countPalindrome(String s, int start, int end) {
    int count = 0;
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      count++;
      start--;
      end++;
    }
    return count;
  }
}