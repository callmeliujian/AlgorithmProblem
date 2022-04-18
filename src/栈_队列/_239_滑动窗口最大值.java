package 栈_队列;
// https://leetcode-cn.com/problems/sliding-window-maximum/
// 使用双端队列，同时为单调递减队列，队头为数组元素最大值
// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//返回 滑动窗口中的最大值 。


import java.util.Deque;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        if (k == 1)
            return nums;
        int [] maxes = new int[nums.length - (k  - 1)];
        // 当前 nums 最大值索引
        int maxIdx = 0;
        // 求出前 K 个元素最大值索引
        // i 从 1 开始因为默认第 0 个最大
        for (int i = 1; i < k; i ++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        // li 是滑动窗口的最左索引
        for (int li = 0; li < maxes.length; li++) {
            // ri是滑动窗口最右索引
            int ri = li + (k - 1);
            if (maxIdx < li) { // 最大的索引不在滑动窗口的合理范围内
                // 求出【li,ri】范围内最大的索引
                maxIdx = li;
                for (int i = li + 1; i <= ri; i ++) {
                    if (nums[i] > nums[maxIdx]) {
                        maxIdx = i;
                    }
                }
            } else if (nums[ri] >= nums[maxIdx]) {
                maxIdx = ri;
            }
            maxes[li] = nums[maxIdx];
        }
        return maxes;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1)
            return new int[0];
        if (k == 1)
            return nums;
        int[] maxes = new int[nums.length - (k - 1)];
        // 队列存放 nums 最大元素位置
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 只要nums[队尾] <= num[i],就删除队尾
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 将 i 加到队尾
            deque.offerLast(i);
            // 检查窗口的索引是否合法
            int w = i - ( k - 1);
            if (w < 0)
                continue;
            // 检查对头的合法性
            if (deque.peekFirst() < w) {
                // 对头不合法（失效，不在滑动窗口索引范围内）
                deque.pollFirst();
            }
            // 设置窗口的最大值
            maxes[w] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}
