package offer.chapter8;

/**
 * 面试题47：二叉树剪枝
 *
 * 一棵二叉树的所有节点的值要么是0要么是1，请剪除该二叉树中所有节点的值全是0的子树。
 *
 * @author Mr.黄
 * @date 2021/12/25
 **/
public class InterviewQuestion47 {
  /**
   * 使用二叉树的后序遍历递归写法解题。
   * 二叉树后序遍历：左右根
   *
   * 剪枝条件：
   *   首先，值为0；其次，如果有子树，那么它的子树的所有节点的值都为0
   * 总结：如果一个节点可以被删除，那么它的子树的所有节点都可以被删除
   *
   * @param root 二叉树的根节点
   * @return 返回剪枝后的树
   */
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    pruneTree(root.left);
    pruneTree(root.right);
    if (root.left == null && root.right == null && root.val == 0) {
      // 没有左右子树，并且值为0，返回null（删除该节点）
      return null;
    }
    return root;
  }
}