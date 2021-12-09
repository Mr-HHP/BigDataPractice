package offer.chapter6;

import java.util.Stack;

/**
 * 面试题38：每日温度
 * <p>
 * 输入一个数组，它的每个数字是某天的温度。
 * 请计算每天需要等几天才会出现更高的温度
 *
 * @author Mr.黄
 * @date 2021/12/09
 **/
public class InterviewQuestion38 {
  /**
   * 利用栈解题
   *
   * 时间复杂度：O(n)，虽然有两个循环，但是数组中每个值入栈、出栈各一次
   * 空间复杂度：O(n)
   *
   * @param temperatures 给定的温度数组
   * @return 返回结果数组
   */
  public int[] dailyTemperatures(int[] temperatures) {
    int result[] = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      // 栈不为空，并且当前温度大于栈顶温度
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        // 栈顶温度出栈
        int prev = stack.pop();
        // 球差值
        result[prev] = i - prev;
      }
      // 栈为空或者当前温度小于栈顶温度
      stack.push(i);
    }
    return result;
  }
}