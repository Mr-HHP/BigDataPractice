package offer.chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题43：在完全二叉树中添加节点
 *
 * 实现数据结构CBTInserter有如下三种方法
 * 1、构造函数CBTInserter(TreeNode root)，用一棵完全二叉树的根节点初始化该数据结构
 * 2、函数insert(int v)在完全二叉树中添加一个值为v的节点，并返回被插入节点的父节点。
 * 3、函数getRoot()返回完全二叉树的根节点
 *
 * @author Mr.黄
 * @date 2021/12/03
 **/
public class InterviewQuestion43 {
}

class CBTInserter {
  private Queue<TreeNode> queue;
  private TreeNode root;
  
  /**
   * 构造函数
   *
   * @param root 完全二叉树根节点
   */
  public CBTInserter(TreeNode root) {
    this.root = root;
    queue = new LinkedList<>();
    queue.offer(root);
    while (queue.peek().left != null && queue.peek().right != null) {
      // 算法优化，这样子不需要每次都从根节点开始遍历
      TreeNode node = queue.poll();
      queue.offer(node.left);
      queue.offer(node.right);
    }
  }
  
  /**
   * insert方法
   *
   * @param v 待插入的值
   * @return 被插入节点的父节点
   */
  public int insert(int v) {
    // 父节点
    TreeNode parent = queue.peek();
    // 待插入节点
    TreeNode node = new TreeNode(v);
    if (parent.left == null) {
      // 父节点没有左子树
      parent.left = node;
    } else {
      // 父节点没有右子树
      parent.right = node;
      // 算法优化，删除拥有左右子树的父节点
      // 将左右子树放入队列，从左右子树开始遍历，这样子可以减少遍历的节点数量
      queue.poll();
      queue.offer(node.left);
      queue.offer(node.right);
    }
    return parent.val;
  }
  
  /**
   * 获取完全二叉树的根节点
   *
   * @return 完全二叉树的根节点
   */
  public TreeNode getRoot() {
    return this.root;
  }
}