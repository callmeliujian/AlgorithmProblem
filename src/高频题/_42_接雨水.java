package 高频题;

public class _42_接雨水 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1, lowerMax = 0, water = 0;
        while (l < r) {
            // height[l]、height[r] 中较小的那个
            int lower = height[height[l] <= height[r] ? l++ : r--];
            // 目前为止遇到的最大的lower
            lowerMax = Math.max(lowerMax,lower);
            water += lowerMax - lower;
        }
        return water;
    }

}
