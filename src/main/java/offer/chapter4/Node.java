package offer.chapter4;

/**
 * 多级双向链表
 * 有三个指针，两个指向前后节点，第三个指向它的子节点
 *
 * @author Mr.黄
 * @date 2021/11/18
 **/
public class Node {
  /**
   * 数据域
   */
  public int val;
  /**
   * 指向下一个节点的指针
   */
  public Node next;
  /**
   * 指向前街节点的指针
   */
  public Node prev;
  /**
   * 指向子节点的指针
   */
  public Node child;
  
  public Node(int val) {
    this.val = val;
  }
}