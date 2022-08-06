package PrefixSum_前缀和;

//给定一个二维矩阵 matrix，以下类型的多个请求：
//
//        计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
//        实现 NumMatrix 类：
//
//        NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//        int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
//         
//
//        示例 1：
//
//
//
//        输入:
//        ["NumMatrix","sumRegion","sumRegion","sumRegion"]
//        [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
//        输出:
//        [null, 8, 11, 12]
//
//        解释:
//        NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
//        numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//        numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//        numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/range-sum-query-2d-immutable
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _304_二维区域和检索_矩阵不可变 {

    // 求出没一行前缀和数组，之后相加
    class NumMatrix {

        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            preSum = new int[row][col + 3];
            for (int i = 0; i < row; i++) {
                for (int j = 1; j < col+1; j++) {
                    preSum[i][j] = preSum[i][j-1] + matrix[i][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                ans += preSum[i][col2 + 1] - preSum[i][col1];
            }
            return ans;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

//for (int i = 0; i <= row; i++) {
//        for (int j = 0; j <= col; j++) {
//            System.out.print(preSum[i][j]);
//            System.out.print(",");
//        }
//        System.out.println("");
//    }


class NumMatrix1 {
    // 二维数组前缀和求法
    // https://labuladong.github.io/algo/2/20/24/
    int[][] preSum;
    public void NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        preSum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }
}


}
