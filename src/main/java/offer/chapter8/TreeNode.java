package offer.chapter8;

import scala.Int;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树节点数据类型
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
    dfs(root.left, nodes);
    nodes.add(root.val);
    dfs(root.right, nodes);
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
   *
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
   * @param root 根节点
   * @param nodes 节点集合
   */
  private void dfs2(TreeNode root, List<Integer> nodes) {
    if (root != null) {
      nodes.add(root.val);
      dfs2(root.left, nodes);
      dfs2(root.right, nodes);
    }
  }
  
  /**
   * 二叉树前序遍历迭代实现
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
  
}