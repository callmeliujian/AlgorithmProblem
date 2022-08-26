package Array;
import java.util.*;

//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
//
//        请你计算并返回该式的最大值。
//
//         
//
//        示例 1：
//
//        输入：nums = [3,4,5,2]
//        输出：12
//        解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
//        示例 2：
//
//        输入：nums = [1,5,4,5]
//        输出：16
//        解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
//        示例 3：
//
//        输入：nums = [3,7]
//        输出：12
//
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _1464_数组中两元素的最大乘积 {

    // https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/solution/shu-zu-zhong-liang-yuan-su-de-zui-da-che-oqkf/
    // O(nlogn)
    // 排序，拿到最大的两个值
    class Solution {
        public int maxProduct(int[] nums) {
            Arrays.sort(nums);
            int length = nums.length;
            return (nums[length - 1] - 1) * (nums[length - 2] - 1);
        }
    }

    // 遍历一次，拿到最大的两个值，计算乘积
    // https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/solution/shu-zu-zhong-liang-yuan-su-de-zui-da-che-oqkf/
    class Solution1 {
        public int maxProduct(int[] nums) {
            int a = nums[0];
            int b = nums[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            for (int i = 2; i < nums.length; i++) {
                int item = nums[i];
                if (item > b) {
                    int temp  = b;
                    b = item;
                    a = temp;
                } else if (item > a) {
                    a = item;
                }
            }
            return (a - 1) * (b - 1);
        }
    }

}
