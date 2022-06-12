package 栈_队列;
// https://leetcode-cn.com/problems/sliding-window-maximum/
// 使用双端队列，同时为单调递减队列，队头为数组元素最大值
// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//返回 滑动窗口中的最大值 。


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {

    // 20220612 最新解法
    // 单调队列,用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
    // 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
    // pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
    // push(value)：如果push的元素value大于入口元素的数值，那么就将队列入口的元素弹出，直到push元素的数值小于等于队列入口元素的数值为止
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.removeFirst();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }


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
