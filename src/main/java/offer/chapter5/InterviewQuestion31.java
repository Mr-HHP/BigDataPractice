package offer.chapter5;

import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题31：最近最少使用缓存
 * <p>
 * 请设计实现一个最近最少使用缓存，要求如下两个操作的时间复杂度都是O(1)
 * 1、get(key)：如果缓存中存在键key，则返回它对应的值；否则返回-1
 * 2、put(key, value)：如果缓存中之前包含键key，则它的值设为value；否则添加键key及对应的值value。
 * 在添加一个键是，如果缓存容量已经满了，则在添加新键之前删除最近最少使用的键（缓存中最长时间没有被使用过的元素）
 * <p>
 * 解题：使用哈希表+双向链表实现
 *
 * @author Mr.黄
 * @date 2021/11/25
 **/
public class InterviewQuestion31 {
  public static void main(String[] args) {
    
  }
}

/**
 * 哈希表+双向链表组成的容器
 */
class LRUCache {
  /**
   * 哨兵头节点
   */
  private ListNode head;
  /**
   * 哨兵尾节点
   */
  private ListNode tail;
  /**
   * 哈希表：键为缓存的键，值是双向链表的节点
   */
  private Map<Integer, ListNode> map;
  /**
   * 容量
   */
  int capacity;
  
  public LRUCache(int cap) {
    map = new HashMap<>();
    head = new ListNode(-1, -1);
    tail = new ListNode(-1, -1);
    head.next = tail;
    tail.perv = head;
    capacity = cap;
  }
  
  /**
   * 根据key获取容器中的值
   * 在返回值之前，需要先将待返回的值的节点移动到链表尾部
   *
   * @param key 给定的key
   * @return 存在改key则返回对应的值，否则返回-1
   */
  public int get(int key) {
    ListNode node = map.get(key);
    if (node == null) {
      return -1;
    }
    moveToTail(node, node.value);
    return node.value;
  }
  
  /**
   * 往容器中添加元素
   * 键已存在，直接用新值替换原始值，在替换前需要先将节点移动到链表尾部
   * 键不存在，未达到最大容量；直接插入，并把新插入的数据节点移动到链表尾部;
   * 已达到最大容量，需要删除最近最少使用的节点，然后在添加新节点。
   *
   * @param key 待插入的key
   * @param value 待插入的值
   */
  public void put(int key, int value) {
    if (map.containsKey(key)) {
      // 键已存在，移动到链表尾部
      moveToTail(map.get(key), value);
    } else {
      // 键不存在
      if (map.size() == capacity) {
        // 容量已满
        // 删除最近最少使用的节点
        ListNode toBeDeleted = head.next;
        deleteNode(toBeDeleted);
        map.remove(toBeDeleted.key);
      }
      // 容量未满
      ListNode node = new ListNode(key, value);
      insertToTail(node);
      map.put(key, node);
    }
  }
  
  /**
   * 删除双向链表中的节点
   *
   * @param node 待删除节点
   */
  private void deleteNode(ListNode node) {
    node.perv.next = node.next;
    node.next.perv = node.perv;
  }
  
  /**
   * 将节点移动到双向链表尾部
   * 第一步：先从当前位置删除节点
   * 第二步：链表尾部添加新节点
   *
   * @param node     待移动的节点
   * @param newValue 新的值
   */
  private void moveToTail(ListNode node, int newValue) {
    // 删除节点
    deleteNode(node);
    node.value = newValue;
    // 链表尾部插入新节点
    insertToTail(node);
  }
  
  /**
   * 链表尾部插入节点
   *
   * @param node 待插入的节点
   */
  private void insertToTail(ListNode node) {
    tail.perv.next = node;
    node.perv = tail.perv;
    node.next = tail;
    tail.perv = node;
  }
}

/**
 * 双向链表：节点是键与值的数对
 */
class ListNode {
  public int key;
  public int value;
  public ListNode next;
  public ListNode perv;
  
  public ListNode(int k, int v) {
    key = k;
    value = v;
  }
}