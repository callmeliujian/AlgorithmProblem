package 异或;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//         
//
//        示例 1：
//
//        输入：nums = [4,1,4,6]
//        输出：[1,6] 或 [6,1]
//        示例 2：
//
//        输入：nums = [1,2,10,4,1,4,3,3]
//        输出：[2,10] 或 [10,2]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _剑指Offer_56_I_数组中数字出现的次数 {

    // https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
    // 分组异或

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int div = 1;
        while ((div & sum) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & div) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

}
