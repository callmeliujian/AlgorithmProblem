package 滑动窗口;

import 面试题._Z字形打印二叉树;

import java.util.HashMap;

// https://leetcode-cn.com/problems/maximum-erasure-value/
//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
//
//        返回 只删除一个 子数组可获得的 最大得分 。
//
//        如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
//
//         
//
//        示例 1：
//
//        输入：nums = [4,2,4,5,6]
//        输出：17
//        解释：最优子数组是 [2,4,5,6]
//        示例 2：
//
//        输入：nums = [5,2,1,2,5,2,1,2,5]
//        输出：8
//        解释：最优子数组是 [5,2,1] 或 [1,2,5]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/maximum-erasure-value
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _1695_删除子数组的最大得分 {

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            sum += temp;
            if (map.containsKey(temp)) {
                int value = map.get(temp) + 1;
                map.put(temp,value);
            } else  {
                map.put(temp,1);
            }
            if ((i - start + 1) == map.size()) {
                maxSum = Math.max(maxSum,sum);
            }

            while ((i - start + 1 ) > map.size()) {
                int head = nums[start];
                int value = map.get(head) - 1;
                if (value == 0) {
                    map.remove(head);
                } else {
                    map.put(head,value);
                }
                sum -= head;
                start ++;
            }

        }
        return maxSum;
    }

    public static  void main(String[] args) {
        _1695_删除子数组的最大得分 ob = new _1695_删除子数组的最大得分();
        int[] nums = new int[]{4,2,4,5,6};
        int value = ob.maximumUniqueSubarray(nums);
        System.out.println(value);
    }

}
