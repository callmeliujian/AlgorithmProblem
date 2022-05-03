package 滑动窗口;

//给定一个二进制数组 nums ，如果最多可以翻转一个 0 ，则返回数组中连续 1 的最大个数。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,0,1,1,0]
//        输出：4
//        解释：翻转第一个 0 可以得到最长的连续 1。
//             当翻转以后，最大连续 1 的个数为 4。
//        示例 2:
//
//        输入：nums = [1,0,1,1,0,1]
//        输出：4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/max-consecutive-ones-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashMap;

public class _487_最大连续1的个数_II {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int value = hashMap.getOrDefault(current,0) + 1;
            hashMap.put(current,value);
            if (hashMap.getOrDefault(0,0) <= 1) {
                max = Math.max(max,i - start + 1);
            }
            while (hashMap.getOrDefault(0,0) > 1) {
                int head = nums[start];
                int headValue = hashMap.getOrDefault(head,0) - 1;
                if (headValue == 0) {
                    hashMap.remove(head);
                } else {
                    hashMap.put(head,headValue);
                }
                start++;
            }
        }
        return max;
    }

}
