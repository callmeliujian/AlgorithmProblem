package 算法;

import java.util.*;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//        请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//         
//
//        示例 1：
//
//        输入：nums = [100,4,200,1,3,2]
//        输出：4
//        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//        示例 2：
//
//        输入：nums = [0,3,7,2,5,8,4,6,0,1]
//        输出：9
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/longest-consecutive-sequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _128_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        // 去重
        for (int num : nums) {
            num_set.add(num);
        }
        int ans = 0;
        for (int num : num_set) {
            // 优化，前一个数在数组里不在查找，while 会查找所有的
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }
                ans = Math.max(ans,length);
            }
        }
        return ans;

    }

}
