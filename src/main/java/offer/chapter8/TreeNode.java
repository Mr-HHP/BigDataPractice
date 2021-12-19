package offer.chapter8;

import scala.Int;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前中后三种遍历，递归和迭代实现
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(h)，h为二叉树的深度
 *
 * 二叉树深度h的最小是是：log2（n+1），最大时为n
 *
 * @author Mr.黄
 * @date 2021/12/14
 **/
public class TreeNode {
  private int val;
  TreeNode left;
  TreeNode right;
  
  public TreeNode(int val) {
    this.val = val;
  }
  
  /**
   * 递归实现二叉树的中序遍历
   * <p>
   * 二叉树中序遍历：左根右
   *
   * @param root 根节点
   * @return 返回中序遍历的节点集合
   */
  public List<Integer> inorderTraversalRecursion(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    dfs(root, nodes);
    return nodes;
  }
  
  /**
   * 递归实现二叉树中序遍历核心逻辑代码
   *
   * @param root  根节点
   * @param nodes 节点集合
   */
  private void dfs(TreeNode root, List<Integer> nodes) {
    if (root != null) {
      // 左根右
      dfs(root.left, nodes);
      nodes.add(root.val);
      dfs(root.right, nodes);
    }
  }
  
  /**
   * 迭代实现二叉树的中序遍历
   * 使用辅助栈
   * <p>
   * 二叉树中序遍历：左根右
   *
   * @param root 根节点
   * @return 返回中序遍历的节点集合
   */
  public List<Integer> inorderTraversalIteration(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      nodes.add(cur.val);
      cur = cur.right;
    }
    return nodes;
  }
  
  /**
   * 递归实现二叉树的前序遍历
   * <p>
   * 二叉树前序遍历：根左右
   *
   * @param root 根节点
   * @return 前序遍历的值
   */
  public List<Integer> preorderTraversalRecursion(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    dfs2(root, nodes);
    return nodes;
  }
  
  /**
   * 二叉树前序遍历递归核心代码
   *
   * @param root  根节点
   * @param nodes 节点集合
   */
  private void dfs2(TreeNode root, List<Integer> nodes) {
    if (root != null) {
      // 根左右
      nodes.add(root.val);
      dfs2(root.left, nodes);
      dfs2(root.right, nodes);
    }
  }
  
  /**
   * 二叉树前序遍历迭代实现
   * 遍历顺序：根左右
   * 使用栈辅助实现
   *
   * @param root 根节点
   * @return 二叉树前序遍历节点集合
   */
  public List<Integer> preorderTraversalIteration(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.empty()) {
      while (cur != null) {
        // 将根节点存入结果
        result.add(cur.val);
        stack.push(cur);
        // 左节点
        cur = cur.left;
      }
      cur = stack.pop();
      // 右节点
      cur = cur.right;
    }
    return result;
  }
  
  /**
   * 二叉树后序遍历递归实现：左右根
   *
   * @param root 根节点
   * @return 后序遍历的结果集
   */
  public List<Integer> postorderTraversalRecursion(TreeNode root) {
    List<Integer> nodes = new LinkedList<>();
    dfs3(root, nodes);
    return nodes;
  }
  
  /**
   * 二叉树后序遍历递归是实现：左右根
   *
   * @param root  根节点
   * @param nodes 后序遍历节点集合
   */
  public void dfs3(TreeNode root, List<Integer> nodes) {
    if (root != null) {
      // 左右根
      dfs3(root.left, nodes);
      dfs3(root.right, nodes);
      nodes.add(root.val);
    }
  }
  
  /**
   * 二叉树后续遍历迭代实现
   * 遍历顺序：左右根
   *
   * 如果一个节点存在右子节点并且右子节点正好是前一个被遍历的节点，
   * 那么它的右子树已经遍历过。
   *
   * @param root 二叉树根节点
   * @return 后序遍历的节点集合
   */
  public List<Integer> postorderTraversalIteration(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    // 当前遍历的节点
    TreeNode cur = root;
    // 遍历过的前一个节点
    TreeNode prev = null;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.peek();
      if (cur.right != null && cur.right != prev) {
        // 当前节点有右子节点，并且右子节点不等于上一个遍历的节点
        // 根据后序遍历“左右根”的顺序，优先遍历当前节点的右子节点
        cur = cur.right;
      } else {
        // 当前节点没有右子节点，遍历当前节点
        stack.pop();
        result.add(cur.val);
        prev = cur;
        cur = null;
      }
    }
    return result;
  }
  
}