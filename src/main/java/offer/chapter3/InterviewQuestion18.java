package offer.chapter3;

/**
 * 面试题18：有效的回文
 * <p>
 * 给定一个字符串，请判断它是不是回文。
 * 假设只需要考虑字母和数字字符，并忽略大小写
 *
 * @author Mr.黄
 * @date 2021/11/03
 **/
public class InterviewQuestion18 {
  public static void main(String[] args) {
    System.out.println(isPalindrome("Was it a cat I saw?"));
    System.out.println(isPalindrome("race a car"));
  }
  
  /**
   * 使用双指针法判断是否是回文
   *
   * @param s 字符串
   * @return 是回文返回true，否则返回false
   */
  public static boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      char ch1 = s.charAt(i);
      char ch2 = s.charAt(j);
      if (!Character.isLetterOrDigit(ch1)) {
        i++;
      } else if (!Character.isLetterOrDigit(ch2)) {
        j--;
      } else {
        ch1 = Character.toLowerCase(ch1);
        ch2 = Character.toLowerCase(ch2);
        if (ch1 != ch2) {
          return false;
        }
        i++;
        j--;
      }
    }
    return true;
  }
}