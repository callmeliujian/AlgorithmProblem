package Search.BinarySearch;

//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
//
//
//        示例 1:
//
//        输入: nums = [-1,0,3,5,9,12], target = 9
//        输出: 4
//        解释: 9 出现在 nums 中并且下标为 4
//        示例 2:
//
//        输入: nums = [-1,0,3,5,9,12], target = 2
//        输出: -1
//        解释: 2 不存在 nums 中因此返回 -1
//         
//
//        提示：
//
//        你可以假设 nums 中的所有元素是不重复的。
//        n 将在 [1, 10000]之间。
//        nums 的每个元素都将在 [-9999, 9999]之间。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/binary-search
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _704_二分查找 {
    // https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-48c1d/wo-xie-le--9c7a4/
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            // 搜索[left, right]
            //  while (left <= right)
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    class Solution1 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            // 搜索[left, right]
            // while (left < right)
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return nums[left] == target ? left : -1;
        }
    }

    class Solution2 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length;
            // 搜索[left, right)
            // while (left < right)
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            if (left == nums.length) {
                return -1;
            } else {
                return nums[left] == target ? left : -1;
            }
        }
    }

}
