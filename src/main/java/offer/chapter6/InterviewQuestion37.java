package offer.chapter6;

import java.util.Stack;

/**
 * 面试题37：小行星碰撞
 * <p>
 * 输入一个代表小行星的数组，数组中每个数字的绝对值表示小行星的大小，数字的正负号表示小行星运动的方向，
 * 证号表示向右飞行，负号表示向左飞行。如果两颗小行星相撞，那么体积较小的小行星将会爆炸最终消失，
 * 体积较大的小行星不受影响。如果相撞的两颗小行星大小相同，那么它们都会爆炸消失。飞行方向相同的小行星永远不会相撞。
 * 求最终剩下的小行星。
 *
 * @author Mr.黄
 * @date 2021/12/08
 **/
public class InterviewQuestion37 {
  /**
   * 使用栈进行解题
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(n)
   *
   * @param asteroids 小行星集合
   * @return 碰撞后剩余的小行星
   */
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int as : asteroids) {
      while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -as) {
        // 当前小行星为负数
        // 栈顶的小行星小于当前的小行星（绝对值比较）
        stack.pop();
      }
      if (!stack.isEmpty() && as < 0 && stack.peek() == -as) {
        // 当前小行星为负数
        // 栈顶的小行星等于当前的小行星（绝对值比较）
        stack.pop();
      } else if (as > 0 || stack.empty() || stack.peek() < 0) {
        // 当前小行星入栈
        stack.push(as);
      }
    }
    return stack.stream().mapToInt(i -> i).toArray();
  }
}