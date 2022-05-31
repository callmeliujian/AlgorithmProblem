package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i ++) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                // 输入：[[6,9,7]]。top < bottom
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[bottom][i]);
                }
                // 输入：{{3},{2}} left < right
                for (int i = bottom; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        _54_螺旋矩阵 a = new _54_螺旋矩阵();
        int[][] matrix = new int[][]{{3},{2}};
        List<Integer> res = a.spiralOrder(matrix);
        System.out.print(res);
    }

}
