package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import common.TreeNode;

//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）


public class _107_二叉树的层序遍历_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int length = deque.size();
            while (length > 0) {
                TreeNode temp = deque.removeFirst();
                item.add(temp.val);
                if (temp.left != null) deque.addLast(temp.left);
                if (temp.right != null) deque.addLast(temp.right);
                length--;
            }
            ans.add(item);
        }
        List<List<Integer>> ansNew = new ArrayList<>();
        for (int i = ans.size() - 1; i >= 0; i--) {
            ansNew.add(ans.get(i));
        }
        return ansNew;
    }

}
