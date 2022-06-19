package Sort;

import java.util.Random;

public class QuickSort {

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

    private int pritition(int[] nums, int left, int right) {
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

}

