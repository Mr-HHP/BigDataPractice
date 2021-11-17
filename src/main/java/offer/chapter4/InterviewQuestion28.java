package offer.chapter4;

/**
 * 面试题28：展开多级双向链表
 *
 * 在一个多级双向链表中，节点除了有两个指针分别指向前后两个节点，还有一个指针指向它的子链表，
 * 并且子链表也是一个双向链表，它的节点也有指向子链表的指针。
 * 请将这样的多级双向链表展平成普通的双向链表，即所有节点都没有子链表。
 *
 * 展平规则：
 * 一个节点的子链展平之后将插入该节点和它的下一个节点之间。
 *
 * 解法：
 * 使用递归的方法进行解题
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(k)，k为链表层数
 *
 * @author Mr.黄
 * @date 2021/11/18
 **/
public class InterviewQuestion28 {
  /**
   * 展平多级双向链表
   *
   * @param head 给定的多级双向链表
   * @return 展平后的双向链表
   */
  public static Node flatten(Node head) {
    flattenGetTail(head);
    return head;
  }
  /**
   * 展平尾节点的递归函数
   *
   * @param head 给定节点
   * @return 尾节点
   */
  private static Node flattenGetTail(Node head) {
    Node node = head;
    Node tail = null;
    while (node != null) {
      Node next = node.next;
      if (node.child != null) {
        Node child = node.child;
        Node childTail = flattenGetTail(child);
        
        node.child = null;
        node.next = child;
        child.prev = node;
        childTail.next = next;
        if (next != null) {
          next.prev = childTail;
        }
        tail = childTail;
      } else {
        tail = node;
      }
      node = next;
    }
    return tail;
  }
}