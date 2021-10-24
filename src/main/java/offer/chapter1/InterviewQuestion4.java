package offer.chapter1;

/**
 * 面试题4
 *
 * 输入一个整数数组，数组中只有一个数字出现了一次，其他的都出现了三次。
 * 请找出只出现了一次的数字
 * 例如，数组为[0,1,0,1,0,1,100]，则只出现一次的数字是100
 *
 * @author Mr.黄
 * @date 2021/10/16
 **/
public class InterviewQuestion4 {
  public static int singleNumber(int[] nums) {
    // 保存数组nums中所有整数的二进制形式中第i个数位之和
    int[] bitSums = new int[32];
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        // “(num >> (31 - i)) & 1”用来获取整数num的二进制形式中从左到右数起第i个数位
        bitSums[i] += (num >> (31 - i)) & 1;
      }
    }
    int result = 0;
    for (int i = 0; i < 32; i++) {
      // “bitSums[i] % 3”为0，则出现一次的数字的第i位数位一定是0
      // “bitSums[i] % 3”为1，则出现一次的数字的第i位数位是1
      // “(result << 1) + bitSums[i] % 3”将二进制转换成10进制
      result = (result << 1) + bitSums[i] % 3;
    }
    return result;
  }
  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 1, 0, 1, 100};
    System.out.println(singleNumber(nums));
  }
}