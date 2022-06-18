package backTracking;

import java.util.*;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/permutations-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _47_全排列_II {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> item = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] flags = new boolean[nums.length];
        boolean[] used = new boolean[nums.length];
        permuteUniqueHelper(nums,flags,used);
        return ans;
    }

    private void permuteUniqueHelper(int[] nums, boolean[] flags, boolean[] used) {
        if (item.size() == nums.length) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i-1] == nums[i] && !flags[i-1]) {
                continue;
            }
            item.add(nums[i]);
            used[i] = true;
            flags[i] = true;
            permuteUniqueHelper(nums,flags,used);
            item.removeLast();
            used[i] = false;
            flags[i] = false;
        }
    }

}
