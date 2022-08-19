package Search.BinarySearch;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//        如果数组中不存在目标值 target，返回 [-1, -1]。
//
//        你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
//         
//
//        示例 1：
//
//        输入：nums = [5,7,7,8,8,10], target = 8
//        输出：[3,4]
//        示例 2：
//
//        输入：nums = [5,7,7,8,8,10], target = 6
//        输出：[-1,-1]
//        示例 3：
//
//        输入：nums = [], target = 0
//        输出：[-1,-1]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    // https://labuladong.github.io/algo/2/20/29/
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = findLeft(nums, target);
            int right = findRight(nums, target);
            return new int[]{left, right};
        }

        private int findLeft(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mind = left + (right - left) / 2;
                if (nums[mind] == target) {
                    right = mind;
                } else if (nums[mind] < target) {
                    left = mind + 1;
                } else if (nums[mind] > target) {
                    right = mind;
                }
            }
            if (left == nums.length) return -1;
            return nums[left] == target ? left : -1;
        }

        private int findRight(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mind = left + (right - left) / 2;
                if (nums[mind] == target) {
                    left = mind + 1;
                } else if (nums[mind] < target) {
                    left = mind + 1;
                } else if (nums[mind] > target) {
                    right = mind;
                }
            }
            if (left - 1 < 0) return -1;
            return nums[left - 1] == target ? (left - 1) : -1;
        }

    }

}
