package offer.chapter4;

import java.util.List;

/**
 * 面试题21：删除倒数第k哥节点
 *
 * 如果给定一个链表，请问如何删除链表中的倒数第k哥节点？
 * 假设链表中节点的总数为n，那么1 <= k <= n。
 * 要求只能遍历链表一次
 *
 * @author Mr.黄
 * @date 2021/11/09
 **/
public class InterviewQuestion21 {
  /**
   * 使用前后双指针法。
   * 指针P1从链表头节点开始先移动k步，指针P2保持不动
   * 从k+1步开始同时移动两个指针。
   * 由于两个指针的距离始终保持为k，当指针P1指向尾节点时，指针P2正好指向倒数第k+1个节点。
   *
   * 使用哨兵节点，可以优化被删除节点为原始链表的头节点的特殊情况
   *
   * @param head 给定的链表
   * @param n 倒数第n个节点
   * @return 删除了倒数第n个节点的链表
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    // 哨兵节点
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    // 指针P1
    ListNode front = head;
    // 指针P2
    ListNode back = dummy;
    for (int i = 0; i < n; i++) {
      front = front.next;
    }
    while (front != null) {
      front = front.next;
      back = back.next;
    }
    // 倒数第n+1的节点的next指针指向倒数第n-1个节点，由此实现删除了倒数第n个节点
    back.next = back.next.next;
    return dummy.next;
  }
  
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    LinkedListExercise linkedListExercise = new LinkedListExercise();
    for (int i = 2; i <= 6; i++) {
      linkedListExercise.appendNew(head, i);
    }
    ListNode node = head;
    for (int i = 0; i < 6; i++) {
      System.out.println(node.val);
      node = node.next;
    }
    System.out.println("==========================");
    ListNode newNode = removeNthFromEnd(head, 2);
    ListNode node1 = newNode;
    for (int i = 0; i < 5; i++) {
      System.out.println(node1.val);
      node1 = node1.next;
    }
  }
}