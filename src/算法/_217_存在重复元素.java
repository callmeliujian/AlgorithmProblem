package 算法;
import java.util.*;

//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//         
//
//        示例 1：
//
//        输入：nums = [1,2,3,1]
//        输出：true
//        示例 2：
//
//        输入：nums = [1,2,3,4]
//        输出：false
//        示例 3：
//
//        输入：nums = [1,1,1,3,3,4,3,2,4,2]
//        输出：true
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/contains-duplicate
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _217_存在重复元素 {
    // https://leetcode.cn/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode-sol-iedd/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

}
