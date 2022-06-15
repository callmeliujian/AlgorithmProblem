package BinaryTree;

import java.util.*;

public class _77_组合 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> item = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n,k,1);
        return ans;
    }

    private void combineHelper(int n, int k, int startIndex) {
        // 终止条件
        if (item.size() == k) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = startIndex; i <= n-(k-item.size())+1; i++) {
            item.add(i);
            combineHelper(n,k,i+1);
            item.removeLast();
        }
    }

}
