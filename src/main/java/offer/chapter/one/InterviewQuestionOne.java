package offer.chapter.one;

/**
 * 面试题1
 *
 * 输入两个int型正数，它们进行除法计算并返回商，要求不能使用乘号、除号、以及求余符号。
 * 当发生溢出的时候返回最大的整数值。
 * 除数不为零
 *
 * @author Mr.黄
 * @date 2021/10/10
 **/
public class InterviewQuestionOne {
  
  /**
   * 进行减法操作的前提操作
   *
   * @param dividend 被除数
   * @param divisor 除数
   * @return 商
   */
  public static int divide(int dividend, int divisor) {
    // 0x80000000为最小的int型整数
    if (dividend == 0x80000000 && divisor == -1) {
      // 溢出情况处理
      return Integer.MAX_VALUE;
    }
    int negative = 2;
    // 防止溢出，将被除数和除数都转成负数进行计算（正数转负数会溢出，反过来不会）
    if (dividend > 0) {
      negative--;
      dividend = -dividend;
    }
     if (divisor > 0) {
       negative--;
       divisor = -divisor;
     }
    int result = divideCore(dividend, divisor);
    return negative == 1 ? -result : result;
  }
  
  /**
   * 使用减法实现两个负数的除法
   * 因为数两个负数进行相除，所有一切判断取反
   *
   * @param dividend 被除数
   * @param divisor 除数
   * @return 商
   */
  private static int divideCore(int dividend, int divisor) {
    int result = 0;
    while (dividend <= divisor) {
      int value = divisor;
      int quotient = 1;
      // 当除数超过被除数一半时商只能是1
      // 0xc0000000，int型最小整数的一半
      while (value >= 0xc0000000 && dividend <= value + value) {
        quotient += quotient;
        value += value;
      }
      result += quotient;
      dividend -= value;
    }
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println(divide(15, 2));
    System.out.println(divide(15, 3));
    System.out.println(divide(18, 9));
    System.out.println(divide(18, 10));
  }
}