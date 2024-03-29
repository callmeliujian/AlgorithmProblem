package Search.BinarySearch;

//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//        每行的元素从左到右升序排列。
//        每列的元素从上到下升序排列。
//         
//
//        示例 1：
//
//
//        输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//        输出：true
//        示例 2：
//
//
//        输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//        输出：false
//         
//
//
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/search-a-2d-matrix-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _240_搜索二维矩阵_II {
    // https://leetcode.cn/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-so-9hcx/
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            int[] nums = matrix[i];
            if (search(nums, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mind = left + ((right - left) / 2);
            if (target == nums[mind]) {
                return true;
            } else if (nums[mind] < target) {
                left = mind + 1;
            } else {
                right = mind - 1;
            }
        }
        return false;
    }

}
