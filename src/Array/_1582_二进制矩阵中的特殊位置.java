package Array;

//给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
//
//        特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
//
//         
//
//        示例 1：
//
//        输入：mat = [[1,0,0],
//                    [0,0,1],
//                    [1,0,0]]
//        输出：1
//        解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
//        示例 2：
//
//        输入：mat = [[1,0,0],
//                    [0,1,0],
//                    [0,0,1]]
//        输出：3
//        解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
//        示例 3：
//
//        输入：mat = [[0,0,0,1],
//                    [1,0,0,0],
//                    [0,1,1,0],
//                    [0,0,0,0]]
//        输出：2
//        示例 4：
//
//        输入：mat = [[0,0,0,0,0],
//                    [1,0,0,0,0],
//                    [0,1,0,0,0],
//                    [0,0,1,0,0],
//                    [0,0,0,1,1]]
//        输出：3
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/special-positions-in-a-binary-matrix
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1582_二进制矩阵中的特殊位置 {
    // https://leetcode.cn/problems/special-positions-in-a-binary-matrix/solution/er-jin-zhi-ju-zhen-zhong-de-te-shu-wei-z-kan4/
    class Solution {
        public int numSpecial(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[] row = new int[m], col = new int[n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        row[i] += mat[i][j];
                        col[j] += mat[i][j];
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

}
