package 动态规划.股票问题;

//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
//        设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//         
//
//        示例 1：
//
//        输入：k = 2, prices = [2,4,1]
//        输出：2
//        解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//        示例 2：
//
//        输入：k = 2, prices = [3,2,6,5,0,3]
//        输出：7
//        解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//        随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _188_买卖股票的最佳时机_IV {
    // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 使用二维数组 dp[i][j] ：第i天的状态为j，所剩下的最大现金是dp[i][j]
        // j的状态表示为：
        // 0 表示不操作
        // 1 第一次买入
        // 2 第一次卖出
        // 3 第二次买入
        // 4 第二次卖出
        // .....
        // 大家应该发现规律了吧 ，除了0以外，偶数就是卖出，奇数就是买入。
        // 题目要求是至多有K笔交易，那么j的范围就定义为 2 * k + 1 就可以了。
        int[][] dp = new int[prices.length][2 * k + 1];
        dp[0][0] = 0;
        for (int j = 1; j < 2 * k + 1; j+= 2) {
            dp[0][j] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k + 1 - 2; j+= 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i -1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }

}
