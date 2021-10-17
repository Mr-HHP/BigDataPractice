package offer.chapter.three;

/**
 * 面试题3
 *
 * 输入一个非负数n，计算0到n之间每个数字的二进制形式中1的个数，并输出一个数组。
 * 例如，输入的n为4，输出数组为[0, 1, 1, 2, 1]
 *
 * @author Mr.黄
 * @date 2021/10/13
 **/
public class InterviewQuestionThree {
  /**
   * 通过 i & (i - 1)计算i的二进制形式中1的个数
   * 时间复杂度O(nk)
   *
   * @param num 非负数
   * @return 数组
   */
  public static int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 0; i <= num; ++i) {
      int j = i;
      while (j != 0) {
        result[i]++;
        j = j & (j - 1);
      }
    }
    return result;
  }
  
  /**
   * 根据i & (i - 1)进行优化。
   * i的二进制形式中1的个数比i & (i - 1)的二进制形式中1的个数多1
   * 时间复杂度O(n)
   * @param num 非负数
   * @return 数组
   */
  public static int[] countBits2(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i <= num; ++i) {
      result[i] = result[i & (i - 1)] + 1;
    }
    return result;
  }
  
  /**
   * 根据“i/2”计算i的二进制形式中1的个数
   *
   * @param num 非负数
   * @return 数组
   */
  public static int[] countBits3(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i < num; ++i) {
      result[i] = result[i >> 1] + (i & 1);
    }
    return result;
  }
  
  public static void main(String[] args) {
    countBits(4);
  }
}