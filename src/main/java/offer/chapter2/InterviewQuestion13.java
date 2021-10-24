package offer.chapter2;

/**
 * 面试题13
 *
 * 输入一个二维矩阵，如何计算给定左上角坐标和右下角坐标的子矩阵的数字之和？
 * 对于同一个二维矩阵，计算子矩阵的数字之和的函数可能由于输入不同的坐标而被反复多次调用。
 *
 * 时间复杂度：O(mn)
 * 空间复杂度：O(mn)
 *
 * @author Mr.黄
 * @date 2021/10/24
 **/
public class InterviewQuestion13 {
  public static void main(String[] args) {
    int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
    NumMatrix numMatrix = new NumMatrix(matrix);
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    System.out.println(numMatrix.sumRegion(1, 1, 2, 3));
  }
}

/**
 * 二维矩阵类。
 * 存储着辅助数组sums
 * 利用公式：sums[r1][c2] - sums[r1-1][c2] - sums[r2][c1-1] + sums[ri-1][c1-1]计算子矩阵的数字之和
 */
class NumMatrix {
  /**
   * 辅助矩阵
   * 该矩阵中的坐标(i, j)的数值为输入矩阵中从左上角坐标(0， 0)到右下角坐标(i, j)的子矩阵的数字之和。
   */
  private int[][] sums;
  
  public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
    }
    // 由于公式r1-1或c1-1可能是负数，所以将辅助矩阵最上面增加一行，最左面增加一列。
    sums = new int[matrix.length + 1][matrix[0].length + 1];
    // 利用双重循环计算辅助矩阵
    for (int i = 0; i < matrix.length; i++) {
      int rowSum = 0;
      for (int j = 0; j < matrix[0].length; j++) {
        rowSum += matrix[i][j];
        sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
      }
    }
  }
  
  /**
   * 利用公式计算子矩阵的数字之和
   * 公式：sums[r1][c2] - sums[r1-1][c2] - sums[r2][c1-1] + sums[ri-1][c1-1]
   *
   * @param row1 子矩阵左上角横坐标
   * @param col1 子矩阵左上角纵坐标
   * @param row2 子矩阵右下角横坐标
   * @param col2 子矩阵右下角纵坐标
   * @return 子矩阵的数字之和
   */
  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
  }

}