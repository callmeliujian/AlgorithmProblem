package Search.BinarySearch;

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
//        由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//         
//
//        示例 1：
//
//        输入：x = 4
//        输出：2
//        示例 2：
//
//        输入：x = 8
//        输出：2
//        解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/sqrtx
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _69_x_的平方根 {
    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            // mid *mid 有可能益处，所以转化为 long
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 2147395599;
        int left = 0, right = x, res = -1;
        int mid = (left + right) / 2;
        long b = (long) mid * (long)mid;
        System.out.println(b);

    }


}
