package 算法;

//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
//示例 1：
//
//输入：n = 2
//输出：[0,1,1]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//示例 2：
//
//输入：n = 5
//输出：[0,1,1,2,1,2]
//解释：
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
//
//链接：https://leetcode.cn/problems/counting-bits

//算法：
//对于所有的数字，只有两类：
//
//奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
//举例：
//0 = 0       1 = 1
//2 = 10      3 = 11
//偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
//举例：
//2 = 10       4 = 100       8 = 1000
//3 = 11       6 = 110       12 = 1100
//另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。
//
//
//链接：https://leetcode.cn/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/



public class _338_比特位计数 {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                // 奇数
                ans[i] = ans[i - 1] + 1;
            } else {
                // 偶数
                ans[i] = ans[i/2];
            }
        }
        return ans;
    }

    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i&1) == 1) {
                // 奇数
                ans[i] = ans[i - 1] + 1;
            } else {
                // 偶数
                ans[i] = ans[i>>1];
            }
        }
        return ans;
    }

}
