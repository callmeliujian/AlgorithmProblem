package 滑动窗口;

import java.util.HashMap;

public class _643_子数组最大平均数_I {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max_avg = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if ((i - start + 1) == k) {
                max_avg = Math.max(max_avg, sum / k);
            }
            if (i >= k - 1) {
                sum -= nums[start];
                start++;
            }
        }
        return max_avg;
    }



}
