package offer.chapter4;

/**
 * 面试题25：链表中的数字相加
 *
 * 给定两个表示非负整数的单向链表，请问如何实现这两个整数的相加并且把它们的和仍然用单向链表表示？
 * 链表中的每个节点表示整数中的十进制的一位，并且头节点对应整数的最高位数而尾节点对应整数的个位数。
 *
 * @author Mr.黄
 * @date 2021/11/16
 **/
public class InterviewQuestion25 {
  /**
   * 两个非负整数的链表相加
   *
   * 先将链表反转，从尾部开始逐一相加，逢十进一
   *
   * @param head1 链表1
   * @param head2 链表2
   * @return 相加后的结果链表
   */
  public static ListNode addTowNumbers(ListNode head1, ListNode head2) {
    // 将链表进行反转
    head1 = reverseList(head1);
    head2 = reverseList(head2);
    // 进行反转后的链表相加
    ListNode reversedHead = addReversed(head1, head2);
    // 将相加结果进行反转后输出
    return reverseList(reversedHead);
  }
  
  /**
   * 链表相加具体实现
   *
   * @param head1 反转后的链表1
   * @param head2 反转后的链表2
   * @return 相加后的反转链表
   */
  private static ListNode addReversed(ListNode head1, ListNode head2) {
    // 哨兵节点，简化边界值判断
    ListNode dummy = new ListNode(0);
    ListNode sumNode = dummy;
    // 进位
    int carry = 0;
    while (head1 != null || head2 != null) {
      int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
      carry = sum > 10 ? 1 : 0;
      sum = sum >= 10 ? sum - 10 : sum;
      // 相加后产生的新节点
      ListNode newNode = new ListNode(sum);
      sumNode.next = newNode;
      sumNode = sumNode.next;
      head1 = head1 == null ? null : head1.next;
      head2 = head2 == null ? null : head2.next;
    }
    // 处理最后一个进位
    if (carry > 0) {
      sumNode.next = new ListNode(carry);
    }
    return dummy.next;
  }
  
  /**
   * 反转单向链表
   *
   * @param head 给定的链表
   * @return 反转后的链表
   */
  private static ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode prev = null;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}