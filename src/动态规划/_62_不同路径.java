package 动态规划;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//        问总共有多少条不同的路径？
//
//         
//
//        示例 1：
//
//
//        输入：m = 3, n = 7
//        输出：28
//        示例 2：
//
//        输入：m = 3, n = 2
//        输出：3
//        解释：
//        从左上角开始，总共有 3 条路径可以到达右下角。
//        1. 向右 -> 向下 -> 向下
//        2. 向下 -> 向下 -> 向右
//        3. 向下 -> 向右 -> 向下
//        示例 3：
//
//        输入：m = 7, n = 3
//        输出：28
//        示例 4：
//
//        输入：m = 3, n = 3
//        输出：6
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/unique-paths
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _62_不同路径 {

    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        // dp 初始化
        for (int row = 0; row < m; row ++ ) {
            dp[row][0] = 1;
        }
        for (int col = 0; col < n; col ++) {
            dp[0][col] = 1;
        }
        for (int row = 1; row < m; row ++) {
            for (int col = 1; col < n; col ++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
