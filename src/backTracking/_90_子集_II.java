package backTracking;

import java.util.*;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
//        解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,2,2]
//        输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//        示例 2：
//
//        输入：nums = [0]
//        输出：[[],[0]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/subsets-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _90_子集_II {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> item = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean falgs[] = new boolean[nums.length];
        backTracking(nums,0,falgs);
        return ans;
    }

    private void backTracking(int[] nums, int startIndex, boolean falgs[]) {
        ans.add(new ArrayList<>(item));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !falgs[i - 1]) {
                continue;
            }
            item.add(nums[i]);
            falgs[i] = true;
            backTracking(nums,i+1,falgs);
            item.removeLast();
            falgs[i] = false;
        }
    }

}
