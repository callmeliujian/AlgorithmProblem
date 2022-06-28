package 动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _322_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]]+1);
            }
        }
        return dp[amount];
    }

}
