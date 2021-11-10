package offer.chapter4;

/**
 * 面试题22：链表中环的入口
 *
 * 如果一个链表中包含环，那么应该如何找出环的入口节点？
 * 从链表的头节点开始顺着next指针方向进入环的第一个节点为环的入口节点。
 *
 * 该题有两种解法：
 * 1、需要知道环中节点数目的解法（分两步）
 *   第一步：使用快慢双指针获取环中的一个节点
 *   第二步：绕环一圈使用前后双指针寻找入口节点
 *
 * 2、不需要知道环中节点数目的解法
 *
 * @author Mr.黄
 * @date 2021/11/10
 **/
public class InterviewQuestion22 {
  /**
   * 解法1第一步
   * 使用快慢双指针寻找环中的一个节点，如果链表中没有环则返回null
   *
   * @param head 给定的链表
   * @return 环中的一个节点，如果链表没有环则返回null
   */
  private static ListNode getNodeInLoop(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head.next;
    ListNode fast = slow.next;
    while (fast != null && slow != null) {
      if (slow == fast) {
        return slow;
      }
      // 慢指针
      slow = slow.next;
      // 快指针
      fast = fast.next;
      if (fast != null) {
        // 快指针比慢指针快两步
        fast = fast.next;
      }
    }
    return null;
  }
  
  /**
   * 解法1第二步
   * 使用前后指针寻找环的入口节点，如果没有环则返回null
   * 前后节点间的间隔为环中的节点数量
   *
   * @param head 给定节点
   * @return 环的入口节点，如果不存在环则返回null
   */
  public static ListNode detectCycle(ListNode head) {
    // 获取环中的一个节点，如果没有环则返回null
    ListNode inLoop = getNodeInLoop(head);
    if (inLoop == null) {
      return null;
    }
    // 统计环中节点的数量
    int loopCount = 1;
    for (ListNode n = inLoop; n.next != inLoop; n = n.next) {
      loopCount++;
    }
    ListNode fast = head;
    for (int i = 0; i < loopCount; i++) {
      fast = fast.next;
    }
    ListNode slow = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
  
  /**
   * 解法2
   * 不需要知道环中节点数目
   *
   * @param head 给定节点
   * @return 环的入口节点，如果没有环则返回null
   */
  public static ListNode detectCycle2(ListNode head) {
    // 获取环中的一个节点
    ListNode inLoop = getNodeInLoop(head);
    if (inLoop == null) {
      return null;
    }
    ListNode node = head;
    while (node != inLoop) {
      inLoop = inLoop.next;
      node = node.next;
    }
    return node;
  }
}