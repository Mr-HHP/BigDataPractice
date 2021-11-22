package offer.chapter4;

/**
 * 面试题29：排序的循环链表
 *
 * 在一个循环链表中节点的值递增排序，请设计一个算法在该循环链表中插入节点，并保证插入结点之后的循环链表仍然是排序的
 *
 * @author Mr.黄
 * @date 2021/11/19
 **/
public class InterviewQuestion29 {
  /**
   * 插入操作
   *
   * @param head 给定的循环链表
   * @param insertVal 待插入的值
   * @return 插入值后的循环链表
   */
  public static Node insert(Node head, int insertVal) {
    Node node = new Node(insertVal);
    // 边界情况处理
    // 链表为空
    if (head == null) {
      head = node;
      head.next = head;
    } else if (head.next == null) {
      // 链表只有一个节点
      head.next = node;
      node.next = head;
    } else {
      // 正常插入节点
      
    }
    return head;
  }
  
  /**
   * 插入节点核心逻辑
   *
   * @param head 给定的循环链表
   * @param node 待插入的节点
   */
  private static void insertCore(Node head, Node node) {
    Node cur = head;
    Node next = head.next;
    // 最大值的节点
    Node biggest = head;
    while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
      // 找到两个节点，满足前一个节点值小于等于待插入节点值，后一个节点值大于等于待插入节点值
      cur = next;
      next = next.next;
      if (cur.val > biggest.val) {
        biggest = cur;
      }
    }
    if (cur.val <= node.val && next.val >= node.val) {
      cur.next = node;
      node.next = next;
    } else {
      // 待插入的节点大于链表中的最大值或者小于链表中的最小值
      // 将新节点插入值最大的节点biggest的后面
      node.next = biggest.next;
      biggest.next = node;
    }
  }
}