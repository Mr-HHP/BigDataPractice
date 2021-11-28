package offer.chapter5;

/**
 * 面试题34：外星语言是否排序
 *
 * 有一门外星语言，它的字母表刚好包含所有的英文小写字母，只是字母表的顺序不同。
 * 给定一组单词和字母表顺序，请判断这些单词是否按照字母表的顺序排序。
 * 例如，输入一组单词["offer", "is", "coming"]，以及字母表顺序"zyxwvutsrqponmlkjihgfedcba"，
 * 由于字母'o'在字母表中位于‘i’的前面，因此单词“offer”排在“is”的前面。
 *
 * @author Mr.黄
 * @date 2021/11/28
 **/
public class InterviewQuestion34 {
  /**
   * 使用哈希表解题，哈希表的键为字母表的每个字母，值为字母在字母表中的顺序。
   * 使用一个数组模拟哈希表。数组的下标对应哈希表的键，而数组的值对应哈希表的值。
   *
   * 扫描两个单词中的字母找出第一个不相同的字母。哪个单词的第一个不相同的字母在字母表中的顺序靠前，排序的时候它就在前面。
   * 如果找不到不相同的字母，那么短的单词排序的时候更靠前
   * @param words 给定的单词数组
   * @param order 字母顺序表
   * @return 如果给定的单词按照字母顺序表排序，则返回true，否则返回false
   */
  public boolean isAlienSorted(String[] words, String order) {
    int[] orderArray = new int[order.length()];
    for (int i = 0; i < words.length - 1; i++) {
      if (!isSorted(words[i], words[i + 1], orderArray)) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * 比较相邻的两个单词是否按照字母顺序表排序
   *
   * @param word1 左边的单词
   * @param word2 右边的单词
   * @param order 字母顺序表
   * @return 如果左右两个单词按照字母顺序表排序则返回true，否则返回false
   */
  private boolean isSorted(String word1, String word2, int[] order) {
    int i = 0;
    for (; i < word1.length() && i < word2.length(); i++) {
      char ch1 = word1.charAt(i);
      char ch2 = word2.charAt(i);
      // 正确按照给定的字母顺序表排序
      if (order[ch1 - 'a'] < order[ch2 - 'a']) {
        return true;
      }
      // 没有按照给定的字母顺序表排序
      if (order[ch1 - 'a'] > order[ch2 - 'a']) {
        return false;
      }
    }
    // 两个单词找不到第一个不相同的字母，此时长度短的单词应该排在前面
    return i == word1.length();
  }
}