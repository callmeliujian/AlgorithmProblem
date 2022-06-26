package 动态规划;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//示例 1：
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//示例 2：
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//链接：https://leetcode.cn/problems/partition-equal-subset-sum



public class _416_分割等和子集 {

    public boolean canPartition(int[] nums) {
        int length = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        // dp[i][j] 表示考虑下标【0，1】这个区间里的所有整数，在它们当中是否能够选出一些数，使得这些数
        // 之和恰好为整数j
        boolean[][] dp = new boolean[length][target + 1];
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i-1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    // 存在j - nums[i] 这个数，才能使考虑nums[i]的数为true
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];
    }

}
