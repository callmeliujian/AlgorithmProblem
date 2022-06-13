package BinaryTree;

import java.util.*;

import common.TreeNode;

public class _515_在每个树行中找最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            int maxValue = Integer.MIN_VALUE;
            while (length > 0) {
                TreeNode temp = deque.removeFirst();
                maxValue = Math.max(maxValue,temp.val);
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length --;
            }
            ans.add(maxValue);
        }
        return ans;
    }

}
