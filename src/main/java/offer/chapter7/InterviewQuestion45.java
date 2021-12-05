package offer.chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题45：二叉树最低层最左边的值
 *
 * 如何在一棵二叉树中找到它最低层最左边节点的值？
 * 假设二叉树中最少有一个节点。
 *
 * @author Mr.黄
 * @date 2021/12/06
 **/
public class InterviewQuestion45 {
  /**
   * 获取二叉树最低层最左边的值
   *
   * @param root 二叉树的根节点
   * @return 二叉树最低层最左边的值
   */
  public int findBottomLeftValue(TreeNode root) {
    // 存放当前层节点的队列
    Queue<TreeNode> queue1 = new LinkedList<>();
    // 存放下一层节点的队列
    Queue<TreeNode> queue2 = new LinkedList<>();
    queue1.offer(root);
    // 保存每一层最左边的节点的值，新的一层会将当前值覆盖
    int bottomLeft = root.val;
    while (!queue1.isEmpty()) {
      TreeNode node = queue1.poll();
      if (node.left != null) {
        queue2.offer(node.left);
      }
      if (node.right != null) {
        queue2.offer(node.right);
      }
      if (queue1.isEmpty()) {
        // 当前层遍历结束，queue1队列指向queue2队列，进入下一层的遍历
        queue1 = queue2;
        // 重置queue2
        queue2 = new LinkedList<>();
        if (!queue1.isEmpty()) {
          // 在进入下一层遍历前，获取下一层的最左边的节点的值
          bottomLeft = queue1.peek().val;
        }
      }
    }
    return bottomLeft;
  }
}