package Search.BinarySearch;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        请必须使用时间复杂度为 O(log n) 的算法。
//
//         
//
//        示例 1:
//
//        输入: nums = [1,3,5,6], target = 5
//        输出: 2
//        示例 2:
//
//        输入: nums = [1,3,5,6], target = 2
//        输出: 1
//        示例 3:
//
//        输入: nums = [1,3,5,6], target = 7
//        输出: 4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/search-insert-position
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _35_搜索插入位置 {

    // https://leetcode.cn/problems/search-insert-position/solution/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/
    // 「在一个有序数组中找第一个大于等于 target 的下标」
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int ans = nums.length;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    ans = mid;
                    right = mid - 1;
                }
            }
            return ans;
        }
    }

}
