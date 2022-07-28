package Sort;
import java.util.*;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//示例 1:
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//示例2:
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _215_数组中的第K个最大元素 {

    // 最小堆解法
    // https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int length = nums.length;
            if (k > length) return 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                queue.offer(nums[i]);
            }
            for (int i = k; i < length; i++) {
                if (nums[i] > queue.peek()) {
                    queue.remove();
                    queue.offer(nums[i]);
                }
            }
            return queue.poll();
        }
        // 这个函数优化了下最小堆的解法
        // 从 2 个 for 循环改成一个 for 循环，但是思路不是很清晰
        public int findKthLargest1(int[] nums, int k) {
            int length = nums.length;
            if (k > length) return 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < length; i++) {
                if (queue.size() < k) {
                    queue.offer(nums[i]);
                } else {
                    if (nums[i] > queue.peek()) {
                        queue.remove();
                        queue.offer(nums[i]);
                    }
                }
            }
            return queue.peek();
        }

    }

    // 快排
    // https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
    Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int ans = quickSort(nums,0,nums.length - 1,nums.length - k);
        return ans;
    }

    private int  quickSort(int[] nums, int left, int right, int k) {
        int pivoteIndex = pritition_random(nums,left,right);
        if (pivoteIndex == k) {
            return nums[k];
        } else {
            return pivoteIndex < k ? quickSort(nums,pivoteIndex + 1, right,k) : quickSort(nums, left, pivoteIndex - 1,k);
        }
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
