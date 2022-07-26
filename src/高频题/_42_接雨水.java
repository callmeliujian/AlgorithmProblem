package 高频题;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//         
//
//        示例 1：
//
//
//
//        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出：6
//        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//        示例 2：
//
//        输入：height = [4,2,0,3,2,5]
//        输出：9
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/trapping-rain-water
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _42_接雨水 {
    class Solution2 {
        // 双指针解法
        // 时间O(n),空间O(1)
        public int trap(int[] height) {
            int length = height.length - 1;
            int left = 0, right = length;
            int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
            int ans = 0;
            while (left < right) {
                lMax = Math.max(lMax, height[left]);
                rMax = Math.max(rMax, height[right]);
                if (lMax < rMax) {
                    ans = ans + lMax - height[left];
                    left++;
                } else {
                    ans = ans + rMax - height[right];
                    right--;
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int trap(int[] height) {
            // 备忘录解法
            // lMaxArray i 左面的柱子最大高度，包含 i
            // rMaxArray i 右面的柱子最大高度，包含 i
            // 包含 i 是没问题的，因为计算 ans 的时候会减去 height[i],如果 ii 为最大值，则本次计算出来的为 0.
            // 时间复杂度 O(n),空间 O(n)
            int length = height.length;
            int ans = 0;
            int[] lMaxArray = new int[length];
            lMaxArray[0] = height[0];
            int[] rMaxArray = new int[length];
            rMaxArray[length - 1] = height[length - 1];
            for (int i = 1; i < length; i++) {
                lMaxArray[i] = Math.max(lMaxArray[i - 1], height[i]);
            }
            for (int i = length - 2; i >= 0; i--) {
                rMaxArray[i] = Math.max(rMaxArray[i + 1],height[i]);
            }
            for (int i = 1; i < length; i ++) {
                ans = ans + Math.min(lMaxArray[i], rMaxArray[i]) - height[i];
            }
            return ans;
        }
    }

    class Solution {
        // 暴力算法，每次找到当前柱子左面，右面的最大值，来计算雨水值
        // 时间O(n2), 空间O(1)
        // https://labuladong.github.io/algo/4/33/129/
        public int trap(int[] height) {
            int ans = 0;
            int length = height.length;
            for (int i = 1; i < length; i++) {
                // 注意不能将下面这行代码放到 for 循环的外面，比如在 i < 7 的时候 rmax 为3，i > 7 的时候 rmax 比3小，如果放到 for 循环的外面，rmax 永远为 3.
                int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
                // 左面最大值
                // 找到左面第一根柱子
                for (int j = i; j >= 0; j --) {
                    lMax = Math.max(lMax, height[j]);
                }
                // 右面最大值
                // 找到右面最后一根柱子
                for (int j = i; j < length; j++) {
                    rMax = Math.max(rMax,height[j]);
                }
                ans = ans + Math.min(lMax, rMax) - height[i];
            }
            return ans;
        }
    }

    // 不好理解，用 Solution2 吧
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
