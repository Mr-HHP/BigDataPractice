package offer.chapter4;

/**
 * 第四章链表简单练习
 *
 * @author Mr.黄
 * @date 2021/11/09
 **/
public class LinkedListExercise {
  /**
   * 原始单项链表插入节点操作
   *
   * @param head 链表头节点
   * @param value 要插入的节点值
   * @return 插入了节点的新链表
   */
  public ListNode append(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    // 链表头节点为null的特殊处理
    if (head == null) {
      return newNode;
    }
    ListNode node = head;
    while (node.next != null) {
      node = node.next;
    }
    node.next = newNode;
    return head;
  }
  
  /**
   * 使用哨兵节点简化链表插入操作
   *
   * 优点：省略了头节点为null的特殊处理操作
   * @param head 链表头节点
   * @param value 要插入的值
   * @return 插入了节点的新链表
   */
  public ListNode appendNew(ListNode head, int value) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode newNode = new ListNode(value);
    ListNode node = dummy;
    while (node.next != null) {
      node = node.next;
    }
    node.next = newNode;
    return dummy.next;
  }
  
  /**
   * 常规的链表删除操作
   *
   * @param head 链表头节点
   * @param value 要删除的值
   * @return 删除节点后的链表
   */
  public ListNode delete(ListNode head, int value) {
    // 链表头节点为null的特殊处理
    if (head == null) {
      return null;
    }
    // 链表头节点不为null，被删除的节点是头节点的特殊处理
    if (head.val == value) {
      return head.next;
    }
    ListNode node = head;
    while (node.next != null) {
      if (node.next.val == value) {
        node.next = node.next.next;
        break;
      }
      node = node.next;
    }
    return head;
  }
  
  /**
   * 使用哨兵节点简化链表删除操作
   *
   * @param head 链表头节点
   * @param value 要删除的节点
   * @return 删除了节点的新链表
   */
  public ListNode deleteNew(ListNode head, int value) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode node = dummy;
    while (node.next != null) {
      if (node.next.val == value) {
        node.next = node.next.next;
        break;
      }
      node = node.next;
    }
    return dummy.next;
  }
}