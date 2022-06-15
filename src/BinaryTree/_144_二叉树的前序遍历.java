package BinaryTree;

import common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _144_二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }

    private void preorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        ans.add(node.val);
        preorder(node.left, ans);
        preorder(node.right, ans);
    }

    // 迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.removeLast();
            ans.add(temp.val);
            if (temp.right != null) deque.addLast(temp.right);
            if (temp.left != null) deque.addLast(temp.left);
        }
        return ans;
    }



}
