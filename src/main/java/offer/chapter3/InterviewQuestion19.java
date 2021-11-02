package offer.chapter3;

/**
 * 面试题19：最多删除一个字符得到回文
 *
 * 给定一个字符串，请判断如果最多从字符串中删除一个字符能不能得到一个回文字符串。
 *
 * @author Mr.黄
 * @date 2021/11/03
 **/
public class InterviewQuestion19 {
  public static void main(String[] args) {
    System.out.println(validPalindrome("abca"));
    System.out.println(validPalindrome("abcaa"));
  }
  
  /**
   * 利用双指针法进行解题
   *
   * @param s 给定字符串s
   * @return 符合条件返回ture，否则返回false
   */
  public static boolean validPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    for (; start < s.length() / 2; start++, end--) {
      // 不是回文，跳出循环
      if (s.charAt(start) != s.charAt(end)) {
        break;
      }
    }
    // 如果start等于输入字符串s的长度的一半，那么s本身就是回文。
    // 如果start小于字符串s的长度的一半，那么下标为start和end的两个字符不相同，分别跳过下标start和end（相当于删除）调用回文判断函数判断剩下的字符串是否为回文
    return start == s.length() / 2 || isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
  }
  
  /**
   * 判断字符串s是否是回文
   *
   * @param s 字符串s
   * @param start 开始指针
   * @param end 结束指针
   * @return 是回文返回true，否则返回false
   */
  private static boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      // 不是回文，跳出循环
      if (s.charAt(start) != s.charAt(end)) {
        break;
      }
      start++;
      end--;
    }
    return start >= end;
  }
}