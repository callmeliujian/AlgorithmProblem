package 动态规划._01背包;

//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
//
//如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
//
//示例 1：
//
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
//示例 2：
//
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
//
//链接：https://leetcode.cn/problems/ones-and-zeroes


public class _474_一和零 {
//  题解：https://programmercarl.com/0474.一和零.html#_474-一和零
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        // 滚动数组优化
        int[][] dp = new int[m+1][n+1];
        // 字符串的zeroNum和oneNum相当于物品的重量（weight[i]），字符串本身的个数相当于物品的价值（value[i]）。
        int zeroNum = 0, oneNum = 0;
        for (String str : strs) { // 物品
            zeroNum = 0;
            oneNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 背包容量就是题目描述中的m和n。
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
