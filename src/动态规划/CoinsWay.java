package 动态规划;

// arr 中都是正数且无重复值，返回组成 aim 的方法数

public class CoinsWay {

    public int ways1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr,0,aim);
    }

    // 可以自由使用 arr[index...]所有的面值，每一种面值都可以使用任意张
    // 组成 rest 有多少种方法
    private int process1(int[] arr, int index, int rest) {
        if (rest <0) {
            return 0;
        }
        // rest >= 0
        if (index == arr.length) { // 没有货币可以选择了
            return rest == 0 ? 1 : 0;
        }
        // 当前有货币，arr[index]
        int ways = 0;
        for (int zhang = 0;  zhang * arr[index] <= rest; zhang++) {
            ways+= process1(arr,index+1,rest - (zhang * arr[index]));
        }
        return ways;
    }

    public int ways2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < arr.length + 1; i ++) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr,0,aim,dp);
    }
    // 如果 index 和 rest 的参数组合，是没算过的， dp[index][rest] == -1；
    // 如果 index 和 rest 的参数组合，是算过的， dp[index][rest] > -1；
    // 自顶向下
    private int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) { // 没有货币可以选择了
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        // 当前有货币，arr[index]
        int ways = 0;
        for (int zhang = 0;  zhang * arr[index] <= rest; zhang++) {
            ways+= process1(arr,index+1,rest - (zhang * arr[index]));
        }
        dp[index][rest] = ways;
        return ways;
    }
    // 从简单到复杂
    public int ways3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1; // dp[N][1...aim] = 0
        for (int index = N - 1; index >= 0; index --) {
            for (int rest = 0; rest <= aim; rest ++) {
                int ways = 0;
                for (int zhang = 0;  zhang * arr[index] <= rest; zhang++) { // 枚举行为，有些题可以省掉。预处理数组的某些题、斜率优化的某些题、四边形不等式的某些题
                    ways+= dp[index+1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    // 从简单到复杂
    public int ways4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1; // dp[N][1...aim] = 0
        for (int index = N - 1; index >= 0; index --) {
            for (int rest = 0; rest <= aim; rest ++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        CoinsWay a = new CoinsWay();
        int[] arr = {5, 10, 50, 100};
        int sum = 1000;
        int ans1 = a.ways1(arr,sum);
        int ans2 = a.ways2(arr,sum);
        int ans3 = a.ways3(arr,sum);
        int ans4 = a.ways4(arr,sum);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
    }

}
