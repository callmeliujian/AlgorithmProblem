package 算法;

import java.util.*;

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
//示例 1：
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
//示例 2：
//
//输入：nums = [1,1]
//输出：[2]
//链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array

public class _448_找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int num : nums) {
            // 数组范围[1,n],数组index范围[0,n-1]
            int index = (num - 1) % length;
            nums[index] += length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 题目中说数组范围为[1,n], 即 缺少 nn 的时候，num[i] == length
            if (nums[i] <= length) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

}
