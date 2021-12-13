package offer.chapter6;

import java.util.Stack;

/**
 * 面试题40：矩阵中的最大矩形
 *
 * 使用单调栈法解题
 *
 * @author Mr.黄
 * @date 2021/12/14
 **/
public class InterviewQuestion40 {
  /**
   * 计算矩阵中的最大矩形
   *
   * 假设输入的矩形的大小为 m x n
   * 时间复杂度：O(mn)
   * 空间复杂度：O(n)
   *
   * @param matrix 矩阵
   * @return 返回矩阵中的最大矩形
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    // 记录以某一行作为基线的直方图的每根柱子的高度
    int[] heights = new int[matrix[0].length];
    int maxArea = 0;
    for (char[] row : matrix) {
      for (int i = 0; i < row.length; i++) {
        // 初始化heights数组
        if (row[i] == '0') {
          heights[i] = 0;
        } else {
          heights[i]++;
        }
      }
      maxArea = Math.max(maxArea, largestRectangleArea(heights));
    }
    return maxArea;
  }
  
  /**
   * 使用单调栈法计算直方图中最大矩形面积
   *
   * 时间复杂度：O(n)
   * 空间复杂度：O(n)
   *
   * @param heights 给定的直方图数组
   * @return 返回直方图中的最大矩形面积
   */
  private int largestRectangleArea(int[] heights) {
    // 初始化栈，给栈内放置辅助值-1
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      // 遍历直方图数组
      while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
        // 当前柱子高度小于栈顶柱子高度
        // 栈顶柱子出栈，并计算以栈顶柱子为顶的矩形面积
        int height = heights[stack.pop()];
        // 宽的计算方式：左右两侧比它矮的柱子的下标之差再减1（当前柱子的下标 - 栈顶左侧柱子的下标 - 1）
        int width = i - stack.peek() - 1;
        // 计算面积
        maxArea = Math.max(maxArea, height * width);
      }
      // 当前柱子入栈
      stack.push(i);
    }
    // 直方图数组遍历完毕，处理栈中剩余的柱子
    while (stack.peek() != -1) {
      int height = heights[stack.pop()];
      int width = heights.length - stack.peek() - 1;
      maxArea = Math.max(maxArea, height * width);
    }
    return maxArea;
  }
}