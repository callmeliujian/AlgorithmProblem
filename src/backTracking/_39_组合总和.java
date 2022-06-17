package backTracking;

import java.util.*;

public class _39_组合总和 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates,target,0,0,new LinkedList<>());
        return ans;
    }

    // 非剪枝
    private void backTracking(int[] candidates, int target, int startIndex, int sum, LinkedList<Integer> path) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates,target,i,sum,path);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    // 剪枝
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking1(candidates,target,0,0,new LinkedList<>());
        return ans;
    }
    private void backTracking1(int[] candidates, int target, int startIndex, int sum, LinkedList<Integer> path) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int res = sum += candidates[i];
            if (res > target) {
                break;
            }
            path.add(candidates[i]);
            backTracking1(candidates,target,i,sum,path);
            sum -= candidates[i];
            path.removeLast();
        }
    }

}
