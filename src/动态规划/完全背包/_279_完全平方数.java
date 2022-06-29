package 动态规划.完全背包;
import java.util.*;

//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
//        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//         
//
//        示例 1：
//
//        输入：n = 12
//        输出：3
//        解释：12 = 4 + 4 + 4
//        示例 2：
//
//        输入：n = 13
//        输出：2
//        解释：13 = 4 + 9
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/perfect-squares
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _279_完全平方数 {

    public int numSquares(int n) {
        // dp[j]：和为j的完全平方数的最少数量为dp[j]
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {// 物品
            for (int j = i; j <= n; j++) {// 背包
                if (j - i*i >= 0)
                    dp[j] = Math.min(dp[j],dp[j - i*i]+1);
            }
        }
        return dp[n];
    }

}
