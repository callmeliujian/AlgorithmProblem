package 滑动窗口;

//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//        输出：6
//        解释：[1,1,1,0,0,1,1,1,1,1,1]
//        粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//        示例 2：
//
//        输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//        输出：10
//        解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//        粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashMap;

public class _1004_最大连续1的个数_III {

    public int longestOnes(int[] nums, int k) {
        int max = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int value = hashMap.getOrDefault(current,0) + 1;
            hashMap.put(current,value);
            if (hashMap.getOrDefault(0,0) <= k) {
                max = Math.max(max, i - start + 1);
            }
            while (hashMap.getOrDefault(0,0) > k) {
                int head = nums[start];
                int headValue = hashMap.getOrDefault(head,0) - 1;
                if (headValue <= 0) {
                    hashMap.remove(head);
                } else  {
                    hashMap.put(head,headValue);
                }
                start++;
            }
        }
        return max;
    }

}
