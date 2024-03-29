package 算法;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
//        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//        你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//         
//
//        示例 1：
//
//        输入：digits = [1,2,3]
//        输出：[1,2,4]
//        解释：输入数组表示数字 123。
//        示例 2：
//
//        输入：digits = [4,3,2,1]
//        输出：[4,3,2,2]
//        解释：输入数组表示数字 4321。
//        示例 3：
//
//        输入：digits = [0]
//        输出：[1]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/plus-one
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _66_加一 {
    // https://leetcode.cn/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

}
