package 滑动窗口;

public class _209_长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int min_len = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                min_len = Math.min(min_len, i - start + 1);
            }
            while (sum >= target) { // 先判断  min_len = Math.min 的原因，用例：
//                15
//                [1,2,3,4,5]
                min_len = Math.min(min_len,i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        if (min_len == Integer.MAX_VALUE) {
            return 0;
        }
        return min_len;
    }

    // 性能更高的解决方法
    public int minSubArrayLen1(int s, int[] nums) {
        int startIndex = 0, ans = Integer.MAX_VALUE, sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i - startIndex + 1);
                sum = sum - nums[startIndex];
                startIndex++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
