package offer.chapter6;

import java.util.Stack;

/**
 * 面试题36：后缀表达式
 * <p>
 * 后缀表达式是一种算术表达式，它的操作符在操作数的后面。
 * 输入一个用字符串数组表示的后缀表达式，请输出该后缀表达式的计算结果。
 * 假设输入的一定是有效的后缀表达式。
 * <p>
 * 后缀表达式：
 * 又叫逆波兰式，是一种将操作符放在操作数后面的算术表达式。例如：[2，1，3，*，+] => 2+1*3
 * 通常用的式中缀表达式，即操作符位于两个操作数的中间。例如：2+1*3
 *
 * @author Mr.黄
 * @date 2021/12/06
 **/
public class InterviewQuestion36 {
  /**
   * 后缀表达式。利用栈来解题
   *
   * @param tokens 字符串数组形式的后缀表达式
   * @return 后缀表达式的计算结果
   */
  public int evalRPN(String[] tokens) {
    // 初始化一个堆栈来存储中间结果以及最终结果
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      switch (token) {
        case "+":
        case "-":
        case "*":
        case "/":
          // 获取之前入栈了的数字
          int num1 = stack.pop();
          int num2 = stack.pop();
          // 将num1和num2的计算结果入栈，这个结果可能会成为后面操作符的操作数
          stack.push(calculate(num1, num2, token));
          break;
        default:
          // 将数字入栈
          stack.push(Integer.parseInt(token));
      }
    }
    // 返回结果
    return stack.pop();
  }
  
  /**
   * 表达式计算方法
   *
   * @param num1     数值1
   * @param num2     数值2
   * @param operator 操作符
   * @return 数值1和数值2根据操作符计算出来的结果
   */
  private int calculate(int num1, int num2, String operator) {
    switch (operator) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      case "*":
        return num1 * num2;
      case "/":
        return num1 / num2;
      default:
        return 0;
    }
  }
}