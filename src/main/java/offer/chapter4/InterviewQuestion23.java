package offer.chapter4;

/**
 * 面试题23：两个链表的第1个重合节点
 *
 * 输入两个单向链表，请问如何找出他们的第一个重合节点
 *
 * @author Mr.黄
 * @date 2021/11/12
 **/
public class InterviewQuestion23 {
  /**
   * 使用双指针法
   *
   * 第一步，遍历两个链表获得长度
   * 第二步，第一个指针在较长链表中先移动若干步
   * 第三步，第二个指针指向较短节点的头节点
   * 第四步，相同速度同时移动两个指针，当他们相遇，则找到第一个重合节点
   *
   * 时间复杂度：O(m+n)
   * 空间复杂度：O(1)
   *
   * @param headA 链表A
   * @param headB 链表B
   * @return 第一个重合节点
   */
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // 获取链表长度
    int countA = countList(headA);
    int countB = countList(headB);
    // 求出差值
    int delta = Math.abs(countA - countB);
    ListNode longer = countA > countB ? headA : headB;
    ListNode shorter = countA > countB ? headB : headA;
    // 指针1
    ListNode node1 = longer;
    // 第一个指针先一移动若干步
    for (int i = 0; i < delta; i++) {
      node1 = node1.next;
    }
    // 指针2
    ListNode node2 = shorter;
    while (node1 != node2) {
      node1 = node1.next;
      node2 = node2.next;
    }
    return node1;
  }
  
  /**
   * 获取链表长度
   *
   * @param head 单向链表
   * @return 链表长度
   */
  private static int countList(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}