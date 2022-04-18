package 动态规划;

//给定一个包含非负整数的 m x n网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
//
//        1 3 1
//        1 5 1
//        4 2 1
//        示例 1：
//        输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//        输出：7
//        解释：因为路径 1→3→1→1→1 的总和最小。
//        示例 2：
//
//        输入：grid = [[1,2,3],[4,5,6]]
//        输出：12
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/minimum-path-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _64_最小路径和 {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int [][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        // 求第0行
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }
        // 求第0列
        for (int row = 1; row < rows; row ++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }
        for (int row = 1; row < rows; row ++) {
            for (int col = 1; col < cols; col ++) {
                dp[row][col] = Math.min(dp[row][col - 1], dp[row - 1][col]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }

}
