package 动态规划;
import sliding_window._3_无重复字符的最长子串;

import java.util.*;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//        子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
//         
//        示例 1：
//
//        输入：nums = [10,9,2,5,3,7,101,18]
//        输出：4
//        解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//        示例 2：
//
//        输入：nums = [0,1,0,3,2,3]
//        输出：4
//        示例 3：
//
//        输入：nums = [7,7,7,7,7,7,7]
//        输出：1
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/longest-increasing-subsequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _300_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度
        int[] dp = new int[nums.length];
        int ans = 0;
        // 每一个i，对应的dp[i]（即最长上升子序列）起始大小至少都是1.
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i;j++) {
                int a = nums[i];
                int b = nums[j];
                if (nums[i] > nums[j]) {
                    // 位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。所以：if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _300_最长递增子序列 ob = new _300_最长递增子序列();
        int[] array = new int[]{10,9,2,5,3,7,101,18};
        int length = ob.lengthOfLIS(array);
        System.out.println(length);
    }

}
