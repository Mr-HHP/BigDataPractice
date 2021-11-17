package offer.chapter4;

import java.util.List;

/**
 * 面试题27：回文链表
 *
 * 如何判断一个链表是不是回文？
 * 要求解法的时间复杂度是O(n)，并且不得使用超过O(1)的辅助空间。
 * 如果一个链表是回文，那么链表的节点序列从前往后看和从后往前看是相同的。
 *
 * @author Mr.黄
 * @date 2021/11/17
 **/
public class InterviewQuestion27 {
  /**
   * 判断链表是否是回文
   *
   * 将链表分割两半，将后半段链表反转后再进行比较，判断是否为回文
   * 注意：如果链表节点为奇数，那么把链表分成前后两半时不用包括中间节点
   *
   * @param head 给定链表
   * @return 是回文返回true，否则false
   */
  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    // 使用快慢双指针法将链表分割两半
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode secondHalf = slow.next;
    // 如果链表节点数为奇数，前后两半不包含中间节点
    if (fast.next != null) {
      secondHalf = slow.next.next;
    }
    slow.next = null;
    return equals(secondHalf, reverseList(head));
  }
  
  /**
   * 判断前后两半链表是否相同
   *
   * @param head1 后半段链表
   * @param head2 前半段链表
   * @return 相同返回true，否则返回false
   */
  private static boolean equals(ListNode head1, ListNode head2) {
    while (head1 != null && head2 != null) {
      if (head1.val != head2.val) {
        return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }
    return head1 == null && head2 == null;
  }
  
  /**
   * 反转链表
   * @param head 给定的链表
   * @return 反转后的链表
   */
  private static ListNode reverseList(ListNode head) {
    // 当前节点
    ListNode cur = head;
    // 前一个节点
    ListNode prev = null;
    
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}