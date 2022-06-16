package 动态规划;

public class _53_最大子数组和 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = 0, maxValue = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxValue = Math.max(maxValue,pre);
        }
        return maxValue;
    }

}
