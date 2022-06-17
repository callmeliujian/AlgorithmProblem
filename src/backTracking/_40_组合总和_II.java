package backTracking;

import java.util.*;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用 一次 。
//
//        注意：解集不能包含重复的组合。 
//
//         
//
//        示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        输出:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]
//        示例 2:
//
//        输入: candidates = [2,5,2,1,2], target = 5,
//        输出:
//        [
//        [1,2,2],
//        [5]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/combination-sum-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _40_组合总和_II {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] flags = new boolean[candidates.length];
        backTracking1(candidates,target,0,0,new LinkedList<>(),flags);
        return ans;
    }

    private void backTracking1(int[] candidates, int target, int startIndex, int sum, LinkedList<Integer> path, boolean[] flags) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i-1] == candidates[i] && !flags[i - 1]) {
                continue;
            }
            int res = sum += candidates[i];
            if (res > target) {
                break;
            }
            flags[i] = true;
            path.add(candidates[i]);
            backTracking1(candidates,target,i+1,sum,path,flags);
            sum -= candidates[i];
            path.removeLast();
            flags[i] = false;
        }
    }

}
