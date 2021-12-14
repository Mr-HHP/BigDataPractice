package offer.chapter8;

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
   *
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
   * @param root 根节点
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
   *
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
  
}