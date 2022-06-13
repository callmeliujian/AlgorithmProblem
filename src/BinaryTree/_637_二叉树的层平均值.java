package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import common.TreeNode;


public class _637_二叉树的层平均值 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int length = deque.size();
            double sum = 0;
            int num = length;
            while (length > 0) {
                TreeNode temp = deque.removeFirst();
                sum += temp.val;
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length--;
            }
            Double finalNum = sum / (double)num;
            ans.add(finalNum);
        }
        return ans;
    }

}
