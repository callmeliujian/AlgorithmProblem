package Sort;

//给你一个整数数组 nums，请你将该数组升序排列。
//示例 1：
//
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//示例 2：
//
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/sort-an-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.Random;

public class _912_排序数组 {

    Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivoteIndex = pritition_random(nums,left,right);
        quickSort(nums,left,pivoteIndex - 1);
        quickSort(nums,pivoteIndex + 1,right);
    }

    // 随机选择切分元素，他可以优化顺序数组，逆序数组，或者接近有序的数组
    private int pritition_random(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums,left,randomIndex);
        int pivote = nums[left];
        int j = left;
        // 第一个区间[left+ 1,j]
        // 第二个区间(j,i);
        for (int i = left + 1; i <= right; i ++) {
            if (nums[i] <= pivote) {
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // j 为第一个区间最后一个元素
    // 切分元素为第一个区间的最后一个位置
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int pvoite = partition(nums, left, right);
            quickSort(nums, left, pvoite - 1);
            quickSort(nums, pvoite + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int p = nums[left];
            int j = left;
            // [left + 1, j] <= p
            // (j, i) > p
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] <= p) {
                    j++;
                    swap(nums, j, i);
                }
            }
            swap(nums,left, j);
            return j;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

    }
    // j 为第二个区间第一个元素
    // 切分元素为第一个区间的最后一个位置
    class Solution1 {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;
            int pvoite = partition(nums, left, right);
            quickSort(nums, left, pvoite - 1);
            quickSort(nums, pvoite + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int p = nums[left];
            int j = left+1;
            // [left + 1, j) <= p
            // [j, i) > p
            for (int i = left+1; i <= right; i++) {
                if (nums[i] <= p) {
                    swap(nums, j, i);
                    j++;
                }
            }
            swap(nums,left, j-1);
            return j-1;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

    }


}
