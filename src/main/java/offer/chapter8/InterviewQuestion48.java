package offer.chapter8;

/**
 * 面试题48：序列化和反序列化二叉树
 *
 * 请设计一个算法将二叉树序列化成一个字符串，并能将该字符串反序列化出原来的二叉树。
 *
 * @author Mr.黄
 * @date 2021/12/25
 **/
public class InterviewQuestion48 {
  /**
   * 序列化
   * 使用二叉树的前序遍历进行序列化
   * 二叉树前序遍历：根左右
   *
   * 为了保证反序列化的时候构建出原来的二叉树，使用一个分隔符把不同的节点分隔开。
   * 并且把null节点序列化成“#”
   *
   * @param root 二叉树根节点
   * @return 序列化后的二叉树
   */
  public String serialize(TreeNode root) {
    if (root == null) {
      return "#";
    }
    // 前序遍历：根左右
    String leftStr = serialize(root.left);
    String rightStr = serialize(root.right);
    return String.valueOf(root.val) + "," + leftStr + "," + rightStr;
  }
  
  /**
   * 反序列化
   *
   * @param data 前序遍历序列化的二叉树
   * @return 反序列化后的原二叉树
   */
  public TreeNode deserialize(String data) {
    String[] nodeStrs = data.split(",");
    int[] i = {0};
    return dfs(nodeStrs, i);
  }
  
  /**
   * 利用二叉树前序遍历递归实现进行反序列化操作
   *
   * @param strs 前序遍历序列化的二叉树
   * @return 二叉树节点
   */
  private TreeNode dfs(String[] strs, int[] i) {
    String str = strs[0];
    i[0]++;
    // 序列化的时候将null序列化成了“#”
    if ("#".equals(str)) {
      return null;
    }
    // 二叉树的前序遍历：根左右
    TreeNode node = new TreeNode(Integer.valueOf(str));
    node.left = dfs(strs, i);
    node.right = dfs(strs,i);
    return node;
  }
}