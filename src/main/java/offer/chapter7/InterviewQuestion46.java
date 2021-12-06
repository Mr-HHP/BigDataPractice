package offer.chapter7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题46：二叉树的右侧视图
 *
 * 给定一棵二叉树，如果站在该二叉树的右侧，那么从上到下看到的节点构成二叉树的右侧视图。
 *
 * 二叉树的右侧视图：即每层最右边的节点
 *
 * 解题：利用广度优先搜索
 *
 * @author Mr.黄
 * @date 2021/12/06
 **/
public class InterviewQuestion46 {
  /**
   * 该题目和二叉树的层相关，所以可以利用广度优先搜索解题
   *
   * @param root 二叉树根节点
   * @return 二叉树的右侧视图
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> view = new LinkedList<>();
    if (root == null) {
      return view;
    }
    //存放当前层节点的队列
    Queue<TreeNode> queue1 = new LinkedList<>();
    // 存放下一层节点的队列
    Queue<TreeNode> queue2 = new LinkedList<>();
    queue1.offer(root);
    while (!queue1.isEmpty()) {
      TreeNode node = queue1.poll();
      if (node.left != null) {
        queue2.offer(node.left);
      }
      if (node.right != null) {
        queue2.offer(node.right);
      }
      if (queue1.isEmpty()) {
        // 当前层已经遍历完，当前节点即为当前层最右侧的节点
        view.add(node.val);
        // 将下一层节点赋值给queue1队列
        queue1 = queue2;
        // 重置queue2队列
        queue2 = new LinkedList<>();
      }
    }
    return view;
  }
}