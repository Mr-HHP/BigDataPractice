package offer.chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树广度优先搜索
 *
 * @author Mr.黄
 * @date 2021/12/04
 **/
public class BreadthFirstSearch {
  /**
   * 使用队列实现二叉树的广度优先搜索
   *
   * @param root 二叉树根节点
   * @return 广度优先搜索的二叉树所有节点值
   */
  public List<Integer> bfs(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
    }
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      result.add(node.val);
      if (node.left != null) {
        // 存在左子树
        queue.offer(node.left);
      }
      if (node.right != null) {
        // 存在右子树
        queue.offer(node.right);
      }
    }
    return result;
  }
  
  
}