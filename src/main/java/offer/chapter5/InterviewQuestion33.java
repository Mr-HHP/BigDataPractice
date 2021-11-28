package offer.chapter5;

import java.util.*;

/**
 * 面试题33：给定一组单词，请将他们按照变位词分组。假设单词只包含英文小写字母
 *
 * @author Mr.黄
 * @date 2021/11/28
 **/
public class InterviewQuestion33 {
  /**
   * 解法一：将单词映射到数字
   *
   * 把每个英文小写字母映射到一个质数。
   * 每给出一个单词，就把单词中的所有字母对应的数字相乘，于是每个单词都可以算出一个数字。
   * 由于每个字母都是映射到一个质数，因此不互为变位词的两个单词一定会映射到不同的数字
   *
   * 弊端：由于把单词映射到了数字用到了乘法，因此如果单词非常长，乘法就有可能溢出
   *
   * 时间复杂度：n个单词，平均每个单词m个字母，O(nm)
   *
   * @param strs 给定的字符串数组
   * @return 按变位词分组后的单词集合
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    // 按顺序递增的26位质数
    int[] hash = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    // 键是单词中字母映射的数字的乘积，值是一组变位词
    Map<Long, List<String>> groups = new HashMap<>(16);
    for (String str : strs) {
      long wordHash = 1;
      for (char ch : str.toCharArray()) {
        wordHash *= hash[ch - 'a'];
      }
      // 初始化变位词集合
      groups.putIfAbsent(wordHash, new LinkedList<String>());
      // 将数字映射的单词放入变位词集合中
      groups.get(wordHash).add(str);
    }
    return new LinkedList<>(groups.values());
  }
  
  /**
   * 解法二：将单词字母排序
   *
   * 把一组变位词映射到同一个单词。
   * 由于互为变位词的单词的字母出现的次数分别相同，因此如果把单词中的字母排序就会得到相同的字符串。
   *
   * 如果每个单词平均有m个字母，排序需要O(mlogm)
   * 假设有n个单词
   * 时间复杂度：O(nmlogm)
   *
   * 优势：不存在乘法导致的溢出问题
   *
   * @param strs 给定的字符串数组
   * @return 按变位词分组后的单词集合
   */
  public List<List<String>> groupAnagrams2(String[] strs) {
    // 键是把单词字母排序得到的字符串
    Map<String, List<String>> groups = new HashMap<>(16);
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      // 初始化变位词集合
      groups.putIfAbsent(sorted, new LinkedList<>());
      // 将变位词与相同的字符串映射起来
      groups.get(sorted).add(str);
    }
    return new LinkedList<>(groups.values());
  }
}