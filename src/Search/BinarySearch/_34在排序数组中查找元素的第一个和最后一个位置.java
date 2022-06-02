package Search.BinarySearch;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        如果数组中不存在目标值 target，返回 [-1, -1]。
//
//        进阶：
//
//        你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
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

// 使用二分查找

public class _34在排序数组中查找元素的第一个和最后一个位置 {


//    情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
//    情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
//    情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}

    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums,target);
        int rightBorder = getRightBorder(nums,target);
        // 情况1
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1,-1};
        // 情况三
        if (rightBorder - leftBorder >= 0) return new int[]{leftBorder, rightBorder};
        // 情况二
        return new int[]{-1,-1};
    }
    // 寻找左边界
    private int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                leftBorder = mid;
                right = mid - 1;
                //leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }

    private int getRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                rightBorder = mid;
                left = mid + 1;
                //rightBorder = left;
            } else {
                right = mid - 1;
            }
        }
        return rightBorder;
    }

    public static void main(String[] args) {
        _34在排序数组中查找元素的第一个和最后一个位置 a = new _34在排序数组中查找元素的第一个和最后一个位置();
//        int[] nums = new int[]{5,7,7,8,8,10};
//        int target = 8;

        int[] nums = new int[]{1};
        int target = 1;

        int[] res = a.searchRange(nums,target);
        for (int num : res) {
            System.out.println(num);
        }
    }

}
