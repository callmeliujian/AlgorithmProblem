package 动态规划._01背包;

public class _0_1_背包问题 {
    // 题解：https://programmercarl.com/背包理论基础01背包-1.html
    // 题解：https://programmercarl.com/背包理论基础01背包-2.html
    public static void main(String[] args) {
        // 每个物品重量
        int[] weight = {1, 3, 4};
        // 每个物品的价值
        int[] value = {15, 20, 30};
        // 背包大小
        int bagsize = 4;
        testweightbagproblem5(weight, value, bagsize);
    }

    public static void testweightbagproblem5(int[] weight, int[] value, int bagsize){
        int length = weight.length;
        // dp[i][j] 第 i 件物品放入容量为 j 的背包中，最大值是多少
        int[] dp = new int[bagsize + 1];
        // 递推公式 dp[i][j] = max(dp[i-1][j](不要第i个物品的最大价值),dp[i-1][j-weight[i]]+value[i](要第i个物品的最大价值))
        // 根据递推公式可知，i 通过 i - 1推出，所以 i = 0 的时候需要预先处理好
//        for (int j = weight[0]; j <= bagsize; j++) {
//            dp[j] = value[0];
//        }
        for (int i = 0; i < length; i++) {
            for (int j = bagsize; j >= weight[i];j--) { // 遍历背包，必须倒叙，不然dp[0] 会多次添加
                //if (j >= weight[i]) {
                int value1 = dp[j];
                int value2 = dp[j-weight[i]] + value[i];
                    dp[j] = Math.max(value1,value2);
                //}
            }

            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[j]);
                System.out.print(",");
            }
            System.out.println("");
        }

        }


    // 通过二维数组求解

    public static void testweightbagproblem3(int[] weight, int[] value, int bagsize){
        int length = weight.length;
        // dp[i][j] 第 i 件物品放入容量为 j 的背包中，最大值是多少
        int[][] dp = new int[length][bagsize + 1];
        // 当背包大小为 0 的时候，其总价值为 0
        for (int i = 0; i < length; i++) {
            dp[i][0] = 0;
        }
        // 递推公式 dp[i][j] = max(dp[i-1][j](不要第i个物品的最大价值),dp[i-1][j-weight[i]]+value[i](要第i个物品的最大价值))
        // 根据递推公式可知，i 通过 i - 1推出，所以 i = 0 的时候需要预先处理好
        for (int j = weight[0]; j <= bagsize; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= bagsize; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j]);
                System.out.print(",");
            }
            System.out.println("");
        }
    }

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize){
        int length = weight.length;
        // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
        int[][] dp = new int[length][bagsize + 1];
        // 初始化数组
        for (int i = weight[0]; i <= bagsize; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < length; i++) { // 遍历物品
            for (int j = 0; j <= bagsize; j++) { // 遍历背包
            //for(int j = bagsize; j >=0;j--) { // 倒叙遍历也可以
                dp[i][j] = dp[i - 1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i < length; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    // 通过一维数组求解
    public static void testweightbagproblem1(int[] weight, int[] value, int bagsize){
        // 在一维dp数组中，dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
        int[] dp = new int[bagsize+1];
        int length = weight.length;
        for (int i = 0; i < length; i++) {// 遍历物品
            for (int j = bagsize; j >= weight[i];j--) { // 遍历背包，必须倒叙，不然dp[0] 会多次添加
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int i = 0; i <= bagsize; i++){
            System.out.print(dp[i] + " ");
        }
    }

}