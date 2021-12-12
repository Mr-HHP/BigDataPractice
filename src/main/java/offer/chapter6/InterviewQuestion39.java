package offer.chapter6;

import java.util.Stack;

/**
 * 面试题39：直方图最大矩形面积
 *
 * 输入一个由非负数组成的数组，数组中的数字是直方图中柱子的高。
 * 求直方图中最大矩形面积。
 * 假设直方图中柱子的宽都为1
 *
 * @author Mr.黄
 * @date 2021/12/11
 **/
public class InterviewQuestion39 {
  /**
   * 蛮力法解题，使用双重循环
   *
   * 时间复杂度：O(n*n)
   * 空间复杂度：O(1)
   *
   * @param heights 给定的直方图数组
   * @return 返回直方图最大矩形面积
   */
  public int largestRectangleArea1(int[] heights) {
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      int min = heights[i];
      for (int j = i; j < heights.length; j++) {
        min = Math.min(min, heights[j]);
        int area = min * (j - i - 1);
        maxArea = Math.max(maxArea, area);
      }
    }
    return maxArea;
  }
  
  /**
   * 使用分治法解题（递归）
   *
   * 时间复杂度：O(n*logn)，最坏时间复杂度为O(n*n)
   * 平均空间复杂度：O(logn),最坏为O(n)
   *
   * @param heights 给定的直方图数组
   * @return 返回直方图最大矩形面积
   */
  public int largestRectangleArea2(int[] heights) {
    return helper(heights, 0, heights.length);
  }
  
  /**
   * 分治法的核心地方方法
   *
   * @param heights 给定的直方图数组
   * @param start 开始位置
   * @param end 结束位置（数组长度）
   * @return
   */
  private int helper(int[] heights, int start, int end) {
    if (start == end) {
      return 0;
    }
    if (start + 1 == end) {
      // 此时已经递归到最后一个值
      return heights[start];
    }
    int minIndex = start;
    for (int i = start + 1; i < end; i ++) {
      if (heights[i] < heights[minIndex]) {
        // 找到数组中最矮的柱子
        minIndex = i;
      }
    }
    // 计算通过最矮的柱子的最大矩形面积
    int area = (end - start) * heights[minIndex];
    // 递归寻找左边
    int left = helper(heights, start, minIndex);
    // 递归寻找右边
    int right = helper(heights, start + 1, end);
    // 取面积的最大值
    area = Math.max(area, left);
    return Math.max(area, right);
  }
  
  /**
   * 使用单调栈法解题
   *
   * 时间复杂度：虽然有两层循环，但是每个柱子都入栈出栈一次，所以时间复杂度为O(n)
   * 空间复杂度：O(n)
   *
   * @param heights 给定的直方图数组
   * @return 返回直方图最大的矩形面积
   */
  public int largestRectangleArea3(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    // 初始化栈，这是一个辅助值，计算最后一个矩形时所用
    stack.push(-1);
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
        // 当前柱子的高小于栈顶柱子的高。
        // 栈顶柱子出栈；并计算以栈顶矩形为顶的矩形面积
        int height = heights[stack.pop()];
        // 宽的计算方式：左右两侧比它矮的柱子的下标之差再减1（当前柱子的下标 - 栈顶左侧柱子的下标 - 1）
        int width = i - stack.peek() - 1;
        // 计算矩形面积
        maxArea = Math.max(maxArea, height * width);
      }
      // 当前柱子入栈
      stack.push(i);
    }
    // 所有柱子都遍历完，处理栈中残留的柱子
    while (stack.peek() != -1) {
      // 栈中还残留了柱子
      // 计算处理方式和上述差不多
      int height = heights[stack.pop()];
      // 因为已经遍历到最后一个柱子，所以假设右边还有柱子，所以宽的计算方式为：数组长度（假设右边还有柱子） - 栈顶左侧柱子的下标 - 1
      int width = heights.length - stack.peek() - 1;
      // 计算矩形面积
      maxArea = Math.max(maxArea, height * width);
    }
    return maxArea;
  }
}