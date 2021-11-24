package offer.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 面试题30：插入、删除和随机访问都是O(1)的容器
 *
 * 使用哈希表+数组来实现该容器
 *
 * @author Mr.黄
 * @date 2021/11/24
 **/
public class InterviewQuestion30 {

}

/**
 * 复合条件的容器
 */
class RandomizedSet {
  /**
   *  实现哈希表。键是数值；对应的值是它在数组中的位置
    */
  HashMap<Integer, Integer> numToLocation;
  /**
   * 动态数组。保存数值
   */
  ArrayList<Integer> nums;
  
  public RandomizedSet() {
    numToLocation = new HashMap<>();
    nums = new ArrayList<>();
  }
  
  /**
   * 从数组尾部插入值
   *
   * @param val 待插入的值
   * @return 插入成功返回true，否则false
   */
  public boolean insert(int val) {
    // 已经包含该值
    if (numToLocation.containsKey(val)) {
      return false;
    }
    numToLocation.put(val, nums.size());
    nums.add(val);
    return true;
  }
  
  /**
   * 删除值
   *
   * @param val 待删除的值
   * @return 删除成功返回true，否则返回false
   */
  public boolean remove(int val) {
    // 不存在该值，删除失败
    if (!numToLocation.containsKey(val)) {
      return false;
    }
    int location = numToLocation.get(val);
    numToLocation.put(nums.get(nums.size() - 1), location);
    // 哈希表可以直接删除该值
    numToLocation.remove(val);
    // 将动态数组最后一个值和待删除值调换位置，然后再删除数组最后一个值，以此来删除待删除之，时间复杂度为O(1)
    nums.set(location, nums.get(nums.size() - 1));
    nums.remove(nums.size() - 1);
    return true;
  }
  
  /**
   * 随机访问
   *
   * @return 随机返回容器中的一个值
   */
  public int getRandom() {
    Random random = new Random();
    int r = random.nextInt(nums.size());
    return nums.get(r);
  }
  
}