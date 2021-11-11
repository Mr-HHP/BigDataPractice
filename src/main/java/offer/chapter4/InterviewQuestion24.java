package offer.chapter4;

/**
 * 面试题24：反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后的链表的头节点
 *
 * @author Mr.黄
 * @date 2021/11/12
 **/
public class InterviewQuestion24 {
  /**
   * 相当于使用三个变量互换位置，以此来实现链表反转
   *
   * @param head 给定单向链表
   * @return 反转后的单向链表的头节点
   */
  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}