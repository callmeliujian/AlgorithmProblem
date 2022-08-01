package 算法;

//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
//
//        点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
//
//        一个 有效的正方形 有四条等边和四个等角(90度角)。
//
//         
//
//        示例 1:
//
//        输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//        输出: True
//        示例 2:
//
//        输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//        输出：false
//        示例 3:
//
//        输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//        输出：true
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/valid-square
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _593_有效的正方形 {

    class Solution {
        // 每三个点的构成的三角形的斜边是否相等
        // 而且需要保证每一个三角形都是直角三角形
        int lenght = -1;
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            boolean sum1 = cal(p1, p2, p3);
            boolean sum2 = cal(p1, p2, p4);
            boolean sum3 = cal(p1, p3, p4);
            boolean sum4 = cal(p2, p3, p4);
            return sum1 && sum2 && sum3 && sum4;
        }

        private boolean cal(int[] a, int[] b, int[] c) {
            int length1 = (a[0] - b[0]) * (a[0] - b[0]) +(a[1] - b[1]) * (a[1] - b[1]);
            int length2 = (b[0] - c[0]) * (b[0] - c[0]) +(b[1] - c[1]) * (b[1] - c[1]);
            int length3 = (a[0] - c[0]) * (a[0] - c[0]) +(a[1] - c[1]) * (a[1] - c[1]);
            // 判断是否为三角形
            boolean rightangle = (length1 == length2 && length1 + length2 == length3) || (length2 == length3 && length2 + length3 == length1) || (length1 == length3 && length1 + length3 == length2);
            if (!rightangle) return false;
            int final1 = Math.min(length1, length2);
            int final2 = Math.min(length2, length3);
            int sum = final1 + final2;
            if (sum == 0) return false;
            if (lenght == -1) {
                // 当前没有三角形斜边，将斜边保存
                lenght = sum;
                return true;
            } else {
                // 当前三角形与上一个三角形的斜边相等
                if (lenght == sum) {
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

}
