package backTracking;

import java.util.*;

public class _77_组合 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1,new LinkedList<Integer>());
        return ans;
    }

    // 1.确定参数、返回值
    // 2.确定终止条件
    // 3.单层递归逻辑
    // 非剪枝
    private void backTracking(int n, int k, int startIndex, LinkedList<Integer> item) {
        if (item.size() == k) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            item.add(i);
            backTracking(n,k,i+1,item);
            // backtracking（回溯）
            item.removeLast();
        }
    }
    // 剪枝优化
    private void backTracking1(int n, int k, int startIndex, LinkedList<Integer> item) {
        if (item.size() == k) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = startIndex; i <= n-(k-item.size())+1; i++) {
            item.add(i);
            backTracking1(n,k,i+1,item);
            // backtracking（回溯）
            item.removeLast();
        }
    }


}
