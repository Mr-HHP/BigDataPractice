package offer.chapter1;

/**
 * 面试题2
 *
 * 输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。
 * 例如，输入的二进制字符串分别是“11”和“10”，则输出“101”的。
 *
 * @author Mr.黄
 * @date 2021/10/12
 **/
public class InterviewQuestion2 {
  public static String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    // 获取char数组下标，从后往前，并且可以判断参与计算的数据准确性
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
      int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
      int sum = digitA + digitB + carry;
      carry = sum >= 2 ? 1 : 0;
      sum = sum >= 2 ? sum - 2 : sum;
      result.append(sum);
    }
    if (carry == 1) {
      result.append(1);
    }
    // 上述加法是从字符串的最右端开始，最低为保存在result的最左边，所以输出的时候需要将字符串翻转一下
    return result.reverse().toString();
  }
  
  public static void main(String[] args) {
    System.out.println(addBinary("", ""));
    System.out.println(addBinary("11", "10"));
    System.out.println(addBinary("11", "100"));
    System.out.println(addBinary("110", "10"));
    System.out.println(addBinary("1", "1"));
    System.out.println(addBinary("0000", "00"));
  }
}