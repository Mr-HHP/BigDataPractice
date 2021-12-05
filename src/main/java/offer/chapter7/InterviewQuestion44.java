package offer.chapter7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题44：二叉树中每层的最大值
 *
 * 输入一棵二叉树，请找出二叉树中每层的最大值
 *
 * @author Mr.黄
 * @date 2021/12/05
 **/
public class InterviewQuestion44 {
  /**
   * 用一个队列实现二叉树的广度优先搜索
   *
   * @param root 二叉树的根节点
   * @return 二叉树中每层的最大值
   */
  public List<Integer> largestValues1(TreeNode root) {
    // 记录当前层中位于队列中的节点数
    int current = 0;
    // 记录下一层中位于队列中的节点数
    int next = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
      current = 1;
    }
    List<Integer> result = new LinkedList<>();
    int max = Integer.MIN_VALUE;
    // 对二叉树进行广度优先遍历
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      current--;
      max = Math.max(max, node.val);
      if (node.left != null) {
        // 将当前节点的左子树放入队列
        queue.offer(node.left);
        next++;
      }
      if (node.right != null) {
        // 将当前节点的右子树放入队列中
        queue.offer(node.right);
        next++;
      }
      if (current == 0) {
        // 当前层的所有节点已经遍历完，获取当前层的最大值
        result.add(max);
        // 进入下一层遍历前重置所有参数
        max = Integer.MIN_VALUE;
        current = next;
        next = 0;
      }
    }
    return result;
  }
  
  /**
   * 用两个队列实现二叉树的广度优先搜索
   *
   * @param root 二叉树的根节点
   * @return 二叉树中每层的最大值
   */
  public List<Integer> largestValues2(TreeNode root) {
    // 存放当前层节点的队列
    Queue<TreeNode> queue1 = new LinkedList();
    // 存放下一层节点的队列
    Queue<TreeNode> queue2 = new LinkedList();
    if (root != null) {
      queue1.offer(root);
    }
    List<Integer> result = new LinkedList<>();
    int max = Integer.MIN_VALUE;
    while (!queue1.isEmpty()) {
      TreeNode node = queue1.poll();
      max = Math.max(max, node.val);
      if (node.left != null) {
        // 将当前节点的左子树放入queue2
        queue2.offer(node.left);
      }
      if (node.right != null) {
        // 将当前节点的右子树放入queue2
        queue2.offer(node.right);
      }
      if (queue1.isEmpty()) {
        // 当前层遍历结束，获取当前层的最大值
        result.add(max);
        // 重置max参数进入下一层遍历
        max = Integer.MIN_VALUE;
        // 将queue1指向queue2，并同时清空queue2，进入下一层遍历
        queue1 = queue2;
        queue2 = new LinkedList<>();
      }
    }
    return result;
  }
}