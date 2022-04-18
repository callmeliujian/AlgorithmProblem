package 高频题;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
//
//         
//
//        示例 1：
//
//        输入：x = 2.00000, n = 10
//        输出：1024.00000
//        示例 2：
//
//        输入：x = 2.10000, n = 3
//        输出：9.26100
//        示例 3：
//
//        输入：x = 2.00000, n = -2
//        输出：0.25000
//        解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/powx-n
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _50_Pow {

    public double myPow(double x, int n) {
         boolean neg = n < 0;
         long y = neg ? - ((long) n) : n;
         double res = 1.0;
         while (y > 0) {
             if ((y & 1) == 1) {
                 // 如果最后一个二进制位是1，就累乘上x
                 res *= x;
             }
             x *= x;
             // 舍弃掉最后一个二进制位
             y >>= 1;
         }
         return neg ? (1 / res) : res;
    }

    public double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        // 是否为奇数
        boolean odd = (n & 1) == 1;
        double half = myPow(x, n >> 1);
        half *= half;
        return odd ? (half * x) : half;
    }

}
