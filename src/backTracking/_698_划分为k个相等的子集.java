package backTracking;
import java.util.*;

//给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//
//         
//
//        示例 1：
//
//        输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//        输出： True
//        说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
//        示例 2:
//
//        输入: nums = [1,2,3,4], k = 3
//        输出: false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _698_划分为k个相等的子集 {
    // https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/by-lfool-d9o7/
    // 球选桶
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int item : nums) {
                sum += item;
            }
            if (sum % k != 0) return false;
            int target = sum / k;
            int bucket[] = new int[k];
            // 优化：把数据转换为从大到小
            Arrays.sort(nums);
            int l = 0, r = nums.length-1;
            while (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            return backTrack(nums, 0, target, bucket, k);
        }

        private boolean backTrack(int[] nums, int index, int target, int[] bucket, int k) {
            if (index == nums.length) {
                return true;
            }
            for (int i = 0; i <k; i++) {
                // 剪枝：数组元素加上当前元素大于 target
                if (bucket[i] + nums[index] > target) {
                    continue;
                }
                // 剪枝：如果数组前一个元素与当前元素相等
                if (i > 0 && bucket[i] == bucket[i - 1]) {
                    continue;
                }
                bucket[i] += nums[index];
                if (backTrack(nums, index + 1, target, bucket, k)) {
                    return true;
                }
                bucket[i] -= nums[index];
            }
            return false;
        }

    }

}
