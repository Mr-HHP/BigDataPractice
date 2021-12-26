package offer.chapter8;

/**
 * 面试题49：从根节点到叶子节点的路径数字之和
 *
 * 在一棵二叉树中所有节点都在0~9的范围内，从根节点到叶子节点的路径表示一个数字。
 * 求二叉树中所有路径的数字之和
 *
 * @author Mr.黄
 * @date 2021/12/27
 **/
public class InterviewQuestion49 {
  /**
   * 使用二叉树的前序遍历解题
   *
   * @param root 二叉树的根节点
   * @return 从根节点到叶子节点的路径数字之和
   */
  public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }
  
  /**
   * 利用二叉树的前序遍历计算根节点到叶子节点的路径数字之和
   *
   * @param root 二叉树节点
   * @param path 路径
   * @return
   */
  private int dfs(TreeNode root, int path) {
    if (root == null) {
      // 返回0表示当前路径已经终止，但是终点并不是叶子节点（即没有左子树或者右子树）
      return 0;
    }
    // 计算根节点到当前节点的路径数字
    path = path * 10 + root.val;
    if (root.left == null && root.right == null) {
      // 没有左子树和右子树（到达了叶子节点）
      return path;
    }
    // 计算路径之和
    return dfs(root.left, path) + dfs(root.right, path);
  }
}