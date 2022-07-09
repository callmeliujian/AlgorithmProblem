package 栈.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class 在一个int数组里查找这样的数_它大于等于左侧所有数_小于等于右侧所有数 {
    // https://leetcode.cn/circle/discuss/q5wVRM/
    // 输出的为符合要求的数组下标
    // 核心思想，单调栈。遍历数组，如果遇到一个比单调栈栈顶一个数据小的数据，将单调栈里的元素不断弹出，直到栈顶元素比当前元素小，或者栈为空。
    // 设置一个最大值，如栈的元素要比当前最大值元素大才可以如栈。这个最大值保证的是，当前入栈的元素一定比之前的元素大，因为要保证，当前的值小于前面的值，大于后面的值。
    public int[] getMidNum(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int maxValue = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                stack.removeLast();
            }
            if (nums[i] > maxValue) {
                stack.addLast(i);
            }
            maxValue = Math.max(maxValue,nums[i]);
        }
        int[] ans = new int[stack.size()];
        int index = 0;
        for (int value : stack) {
            ans[index++] = value;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums  = new int[]{2,1,3,4,5,7,6};
        int[] nums1 = new int[]{3,2,1,4,7,6,5};
        int[] nums2 = new int[]{7,6,5,4,3,2,1};
        int[] nums3 = new int[]{6,5,4,3,2,1,7};
        int[] nums4 = new int[]{1,7,6,5,4,3,2};
        在一个int数组里查找这样的数_它大于等于左侧所有数_小于等于右侧所有数 a = new 在一个int数组里查找这样的数_它大于等于左侧所有数_小于等于右侧所有数();
        int[] ans = a.getMidNum(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
        System.out.println();
        int[] ans1 = a.getMidNum(nums1);
        for (int i = 0; i < ans1.length; i++) {
            System.out.println(ans1[i]);
        }
        System.out.println();
        int[] ans2 = a.getMidNum(nums2);
        for (int i = 0; i < ans2.length; i++) {
            System.out.println(ans2[i]);
        }
        System.out.println();
        int[] ans3 = a.getMidNum(nums3);
        for (int i = 0; i < ans3.length; i++) {
            System.out.println(ans3[i]);
        }
        System.out.println();
        int[] ans4 = a.getMidNum(nums4);
        for (int i = 0; i < ans4.length; i++) {
            System.out.println(ans4[i]);
        }
    }

}
