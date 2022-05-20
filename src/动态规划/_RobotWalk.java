package 动态规划;

//假设有排成一行的N个位置记为1~N，N一定大于或等于2
//开始时机器人在其中的M位置上(M一定是1~N中的一个)
//如果机器人来到1位置，那么下一步只能往右来到2位置；
//如果机器人来到N位置，那么下一步只能往左来到N-1位置；
//如果机器人来到中间位置，那么下一步可以往左走或者往右走；
//规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
//给定四个参数 N、M、K、P，返回方法数

public class _RobotWalk {

    public int ways1(int N, int cur, int rest, int P) {
        if (N < 2 || cur < 1 || cur > N || rest < 1 || P > N || P < 1) {
            return -1;
        }
        return walk(N, cur, rest, P);
    }

    // N:位置为 1～N，固定参数
    // cur：当前在 cur 位置，可变参数
    // rest：还剩 rest 步没有走，可变参数
    // p：最终目标位置是 p， 固定参数
    public int walk(int N, int cur, int rest, int P) {
        // 如果没有剩余步数了，当前的 cur 位置就是最后的位置
        // 如果最后的位置停在 P 上，那么之前做的移动就是有效的
        // 如果最后的位置没在 P 上，那么之前做的移动就是无效的
        if (rest == 0) {
            int res = cur == P ? 1 : 0;
            return res;
        }
        // 如果还有 rest 步要走，而当前的 cur 位置在 1 位置上，那么当前这步只能从 1 走向 2
        // 后续的过程就是，来到 2 位置上，还剩 rest - 1 步要走
        if (cur == 1) {
            return walk(N,2,rest - 1,P);
        }
        // 如果还有 rest 步要走，而当前的 cur 位置在 N 位置上，那么当前这步只能从 N 走向 N - 1
        // 后续的过程就是，来到 N - 1 位置上，还剩 rest - 1 步要走/
        if (cur == N) {
            return walk(N,N - 1,rest - 1,P);
        }
        // 如果还有 rest 步要走，而当前的 cur 位置在中间位置上，那么当前这步可以走向左，也可以走向右
        // 走向左之后，后续的过程就是，来到 cur - 1 位置上，还剩 rest - 1 步要走
        // 走向右之后，后续的过程就是，来到 cur + 1 位置上，还剩 rest - 1 步要走
        // 走向左、走向右是截然不同的方法，所以总方法数要都算上
        int ans1 =  walk(N,cur + 1,rest - 1, P);
        int ans2 =  walk(N,cur - 1,rest - 1, P);
        return ans1 + ans2;
    }

    public int ways2(int N, int cur, int rest, int P) {
        if (N < 2 || cur < 1 || cur > N || rest < 1 || P > N || P < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][rest + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= rest; j++) {
                dp[i][j] = -1;
            }
        }
        // dp就是缓存表
        // dp[cur][rest] == -1 -> walkCache(cur, rest)之前没算过！
        // dp[cur][rest] != -1 -> walkCache(cur, rest)之前算过！返回值，dp[cur][rest]
        // N+1 * K+1
        return walkCache(N, cur, rest, P, dp);
    }

    public int walkCache(int N, int cur, int rest, int P, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        // 之前没算过
        int ans = 0;
        if (rest == 0) {
            ans = cur == P ? 1 : 0;
        } else if (cur == 1) {
            ans = walkCache(N,2,rest - 1,P,dp);
        } else if (cur == N) {
            ans = walkCache(N,N - 1,rest - 1,P,dp);
        } else {
            ans = walkCache(N,cur + 1,rest - 1, P,dp) +  walkCache(N,cur - 1,rest - 1, P,dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    public static void main(String[] args) {
        _RobotWalk a = new _RobotWalk();
        int ans = a.ways1(5,2,6,4);
        System.out.println(ans);
        int ans2 = a.ways2(5,2,6,4);
        System.out.println(ans2);
    }

}
