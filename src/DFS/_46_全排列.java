package DFS;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//        示例 2：
//
//        输入：nums = [0,1]
//        输出：[[0,1],[1,0]]
//        示例 3：
//
//        输入：nums = [1]
//        输出：[[1]]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutations
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        dfs(0, nums, list);
        return list;
    }

    private void dfs(int idx, int[] nums, List<List<Integer>> list) {
        // 不能再往下搜索
        if (idx == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int value : nums) {
                result.add(value);
            }
            list.add(result);
            return;
        }
        // 枚举这一层所有可以做出的选择
        for (int i = idx; i < nums.length; i ++) {
            swap(nums, idx, i);
            dfs(idx + 1, nums, list);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
