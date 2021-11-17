package offer.chapter4;

import java.util.List;

/**
 * 面试题26：重排链表
 * <p>
 * 给定一个链表，链表中节点的顺序是L0->L1->L2->...->Ln-1->Ln，
 * 请问如何重排链表时节点的顺序变成L0->Ln->L1->Ln-1->L2->Ln-2->...？
 * <p>
 * 解法：
 * 先将链表分成两半。后半段反转，然后在插入前半段中
 * 使用快慢双指针法找到链表的中间部分，将链表进行分割
 * <p>
 * 注意事项：
 * 当链表的节点总数是奇数是要确保前半段节点总是比后半段多一个节点
 *
 * @author Mr.黄
 * @date 2021/11/16
 **/
public class InterviewQuestion26 {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    LinkedListExercise linkedListExercise = new LinkedListExercise();
    for (int i = 2; i < 7; i++) {
      linkedListExercise.appendNew(head, i);
    }
    ListNode node = head;
    while (node != null) {
      System.out.print(node.val);
      node = node.next;
    }
    reorderList(head);
    ListNode node1 = head;
    System.out.println();
    while (node1 != null) {
      System.out.print(node1.val);
      node1 = node1.next;
    }
  }
  
  /**
   * 重排链表
   *
   * @param head 给定的链表
   */
  public static void reorderList(ListNode head) {
    // 使用快慢双指针法将链表分成两半
    // 使用哨兵节点简化边界值操作
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // 快慢双指针
    ListNode fast = dummy;
    ListNode slow = dummy;
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast.next != null) {
        fast = fast.next;
      }
    }
    // 将链表分割成两半
    // 后半段链表
    ListNode temp = slow.next;
    // 前半段链表
    slow.next = null;
    link(head, InterviewQuestion24.reverseList(temp), dummy);
  }
  
  /**
   * 进行前后半段链表拼接
   *
   * @param node1 前半段链表
   * @param node2 反转的后半段链表
   * @param head  哨兵节点
   */
  private static void link(ListNode node1, ListNode node2, ListNode head) {
    ListNode prev = head;
    while (node1 != null && node2 != null) {
      ListNode temp = node1.next;
      
      prev.next = node1;
      node1.next = node2;
      prev = node2;
      
      node1 = temp;
      node2 = node2.next;
    }
    // 前半段链表比后半段多一个节点的情况处理
    if (node1 != null) {
      prev.next = node1;
    }
  }
}