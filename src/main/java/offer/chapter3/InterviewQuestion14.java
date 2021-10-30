package offer.chapter3;

/**
 * 面试题14：字符串中的变位词
 * <p>
 * 输入字符串s1和s2，如何判断字符串s2中是否包含字符串s1的某个变位词？
 * 如果字符串s2包含字符串s1的某个变位词，则字符串s1至少有一个变位词是字符串s2的子字符串。
 * 假设两个字符串只包含英文小写字母。
 * <p>
 * 变位词：是一种把某个词或者句子的字母的位置（顺序）加以改换所形成的新词
 * 例如“post”、“stop”、“tops”是一组变位词
 * <p>
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(1)
 *
 * @author Mr.黄
 * @date 2021/10/27
 **/
public class InterviewQuestion14 {
  /**
   * 使用双指针法。
   * 基于双指针和哈希表进行解题
   *
   * @param s1 字符串1
   * @param s2 字符串2
   * @return true或false
   */
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] counts = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      counts[s1.charAt(i) - 'a']++;
      counts[s2.charAt(i) - 'a']--;
    }
    if (areAllZero(counts)) {
      return true;
    }
    for (int i = s1.length(); i < s2.length(); i++) {
      counts[s2.charAt(i) - 'a']--;
      counts[s2.charAt(i - s1.length()) - 'a']++;
      if (areAllZero(counts)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean areAllZero(int[] counts) {
    for (int count : counts) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(checkInclusion("ac", "dgcaf"));
    System.out.println(checkInclusion("abc", "ebac"));
  }
}